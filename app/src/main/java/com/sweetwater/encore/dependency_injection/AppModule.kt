package com.sweetwater.encore.dependency_injection

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStoreFile
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sweetwater.encore.BuildConfig
import com.sweetwater.encore.RecountsData
import com.sweetwater.encore.UserInfoMessage
import com.sweetwater.encore.authorization.data.repository.DatastoreUserInfoRepositoryImpl
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository
import com.sweetwater.encore.authorization.data.serializer.UserInfoMessageSerializer
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase
import com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase
import com.sweetwater.encore.dependency_injection.barcode_scanner.BarcodeScanner
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner
import com.sweetwater.encore.dependency_injection.cart_scanner.CartScannerService
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService
import com.sweetwater.encore.dependency_injection.connectivity.ConnectivityService
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService
import com.sweetwater.encore.dependency_injection.mqtt.IMqttService
import com.sweetwater.encore.dependency_injection.mqtt.MqttService
import com.sweetwater.encore.dependency_injection.sound.ISoundService
import com.sweetwater.encore.dependency_injection.sound.SoundService
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService
import com.sweetwater.encore.dependency_injection.vibrator.VibratorService
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI
import com.sweetwater.encore.external_api.boxaudit.repository.BoxAuditRepository
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI
import com.sweetwater.encore.external_api.gds.remote.GDSAPI
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI
import com.sweetwater.encore.external_api.inventory.repository.InventoryRepository
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository
import com.sweetwater.encore.external_api.products.remote.ProductsAPI
import com.sweetwater.encore.external_api.products.repository.ProductsRepository
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository
import com.sweetwater.encore.recounts.data.repository.RecountsDataStoreRepository
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository
import com.sweetwater.encore.recounts.data.serializer.RecountsDataSerializer
import com.sweetwater.encore.utilities.ApiHelper
import com.sweetwater.encore.utilities.AuthToken
import com.sweetwater.encore.utilities.Constants
import com.sweetwater.encore.utilities.GsonParser
import com.sweetwater.encore.utilities.JsonParser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Singleton
    @Provides
    fun provideUserInfoStore(@ApplicationContext context: Context): DataStore<UserInfoMessage> {
        return DataStoreFactory.create(
            serializer = UserInfoMessageSerializer,
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { UserInfoMessage.getDefaultInstance() }
            ),
            migrations = listOf(),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { context.dataStoreFile(Constants.LOGIN_DETAILS_DATASTORE_FILE_NAME) }
        )
    }

    @Singleton
    @Provides
    fun provideRecountsDataStore(@ApplicationContext context: Context): DataStore<RecountsData> {
        return DataStoreFactory.create(
            serializer = RecountsDataSerializer,
            corruptionHandler = ReplaceFileCorruptionHandler(
                produceNewData = { RecountsData.getDefaultInstance() }
            ),
            migrations = listOf(),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { context.dataStoreFile(Constants.RECOUNT_DATASTORE_FILE_NAME) }
        )
    }

    @Provides
    @Singleton
    fun provideToken(): AuthToken {
        return AuthToken("SWa83-74b.vb79mw")
    }

    @Provides
    @Singleton
    fun provideApiHelper(): ApiHelper {
        return ApiHelper()
    }

    @Provides
    @Singleton
    fun provideDcServiceApi(authToken: AuthToken): DcServiceAPI {
        val nullOnEmptyConverterFactory = object : Converter.Factory() {
            fun converterFactory() = this
            override fun responseBodyConverter(
                type: Type,
                annotations: Array<out Annotation>,
                retrofit: Retrofit
            ) = object : Converter<ResponseBody, Any?> {
                val nextResponseBodyConverter =
                    retrofit.nextResponseBodyConverter<Any?>(converterFactory(), type, annotations)

                override fun convert(value: ResponseBody) =
                    if (value.contentLength() != 0L) nextResponseBodyConverter.convert(value) else null
            }
        }

        return Retrofit.Builder()
            .baseUrl(BuildConfig.DC_SERVICE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            builder.header(
                                name = "Authorization",
                                value = authToken.token
                            )
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build()
            )
            .addConverterFactory(nullOnEmptyConverterFactory)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DcServiceAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideInventoryApi(): InventoryAPI {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.DC_SERVICE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InventoryAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideBoxAuditAPI(): BoxAuditAPI {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.DC_SERVICE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BoxAuditAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideProductsApi(): ProductsAPI {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.DC_SERVICE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductsAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGDSAPI(): GDSAPI {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.DC_SERVICE_BASE_URL)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BASIC
                        })
                    .addInterceptor(
                        Interceptor { chain ->
                            val builder = chain.request().newBuilder()
                            return@Interceptor chain.proceed(builder.build())
                        }
                    )
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GDSAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideJsonParser(gson: Gson): JsonParser {
        return GsonParser(gson)
    }

    @Provides
    @Singleton
    fun provideInventoryRepo(
        inventoryAPI: InventoryAPI,
        @ApplicationContext context: Context
    ): IInventoryRepository {
        return InventoryRepository(inventoryAPI, context)
    }

    @Provides
    @Singleton
    fun provideBoxAuditRepo(
        boxAuditAPI: BoxAuditAPI,
        @ApplicationContext context: Context
    ): IBoxAuditRepository {
        return BoxAuditRepository(boxAuditAPI, context)
    }

    @Provides
    @Singleton
    fun provideProductsRepo(
        productsAPI: ProductsAPI,
        @ApplicationContext context: Context
    ): IProductsRepository {
        return ProductsRepository(productsAPI, context)
    }

    @Singleton
    @Provides
    fun provideUserInfoRepo(userInfoDatastore: DataStore<UserInfoMessage>): IUserInfoRepository {
        return DatastoreUserInfoRepositoryImpl(userInfoDatastore)
    }

    @Singleton
    @Provides
    fun provideRecountDataRepo(recountsDataStore: DataStore<RecountsData>): IRecountsRepository {
        return RecountsDataStoreRepository(recountsDataStore)
    }

    @Singleton
    @Provides
    fun provideLoginEmployeeUseCase(
        api: DcServiceAPI,
        userInfoRepositoryImpl: IUserInfoRepository,
        @ApplicationContext context: Context
    ): LoginEmployeeUseCase {
        return LoginEmployeeUseCase(api, userInfoRepositoryImpl, context)
    }

    @Singleton
    @Provides
    fun provideLogoutEmployeeUseCase(
        api: DcServiceAPI,
        userInfoRepositoryImpl: IUserInfoRepository,
        @ApplicationContext context: Context
    ): LogoutEmployeeUseCase {
        return LogoutEmployeeUseCase(api, userInfoRepositoryImpl, context)
    }

    @Singleton
    @Provides
    fun provideGetEmployeeLoginDetailsUseCase(
        userInfoRepositoryImpl: IUserInfoRepository,
        @ApplicationContext context: Context
    ): GetEmployeeLoginDetailsUseCase {
        return GetEmployeeLoginDetailsUseCase(userInfoRepositoryImpl, context)
    }

    @Provides
    fun provideMqttService(): IMqttService {
        return MqttService()
    }

    @Provides
    @Singleton
    fun provideCartScannerService(mqttService: IMqttService): ICartScannerService {
        return CartScannerService(mqttService)
    }

    @Provides
    @Singleton
    fun provideBarcodeScannerService(@ApplicationContext context: Context): IBarcodeScanner {
        return BarcodeScanner(context)
    }


    @Provides
    fun provideConnectivityService(@ApplicationContext context: Context): IConnectivityService {
        return ConnectivityService(context)
    }

    @Provides
    @Singleton
    fun provideSoundService(@ApplicationContext context: Context): ISoundService {
        return SoundService(context)
    }

    @Provides
    @Singleton
    fun provideVibratorService(@ApplicationContext context: Context): IVibratorService {
        return VibratorService(context)
    }

    @Provides
    @Singleton
    fun provideIODispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }
}