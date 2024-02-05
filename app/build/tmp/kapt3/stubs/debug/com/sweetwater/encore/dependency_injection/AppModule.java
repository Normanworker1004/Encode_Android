package com.sweetwater.encore.dependency_injection;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sweetwater.encore.BuildConfig;
import com.sweetwater.encore.RecountsData;
import com.sweetwater.encore.UserInfoMessage;
import com.sweetwater.encore.authorization.data.repository.DatastoreUserInfoRepositoryImpl;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.authorization.data.serializer.UserInfoMessageSerializer;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase;
import com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase;
import com.sweetwater.encore.dependency_injection.barcode_scanner.BarcodeScanner;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.cart_scanner.CartScannerService;
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.connectivity.ConnectivityService;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import com.sweetwater.encore.dependency_injection.mqtt.IMqttService;
import com.sweetwater.encore.dependency_injection.mqtt.MqttService;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.sound.SoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import com.sweetwater.encore.dependency_injection.vibrator.VibratorService;
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI;
import com.sweetwater.encore.external_api.boxaudit.repository.BoxAuditRepository;
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository;
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI;
import com.sweetwater.encore.external_api.gds.remote.GDSAPI;
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI;
import com.sweetwater.encore.external_api.inventory.repository.InventoryRepository;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.external_api.products.remote.ProductsAPI;
import com.sweetwater.encore.external_api.products.repository.ProductsRepository;
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository;
import com.sweetwater.encore.recounts.data.repository.RecountsDataStoreRepository;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import com.sweetwater.encore.recounts.data.serializer.RecountsDataSerializer;
import com.sweetwater.encore.utilities.ApiHelper;
import com.sweetwater.encore.utilities.AuthToken;
import com.sweetwater.encore.utilities.Constants;
import com.sweetwater.encore.utilities.GsonParser;
import com.sweetwater.encore.utilities.JsonParser;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u00c6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u001f\u001a\u00020 H\u0007J\b\u0010!\u001a\u00020\"H\u0007J\b\u0010#\u001a\u00020$H\u0007J\u001a\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020$2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020 H\u0007J\"\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\"\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\b\u00100\u001a\u00020\u0011H\u0007J\b\u00101\u001a\u000202H\u0007J\u001a\u00103\u001a\u0002042\u0006\u00105\u001a\u0002022\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0016\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0007J\u0018\u0010;\u001a\b\u0012\u0004\u0012\u00020:092\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010<\u001a\u00020=2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010>\u001a\u00020\u0018H\u0007J\u0016\u0010?\u001a\u00020\u001e2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020A09H\u0007J\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020A092\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0012\u0010C\u001a\u00020D2\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006E"}, d2 = {"Lcom/sweetwater/encore/dependency_injection/AppModule;", "", "()V", "provideApiHelper", "Lcom/sweetwater/encore/utilities/ApiHelper;", "provideBarcodeScannerService", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "context", "Landroid/content/Context;", "provideBoxAuditAPI", "Lcom/sweetwater/encore/external_api/boxaudit/remote/BoxAuditAPI;", "provideBoxAuditRepo", "Lcom/sweetwater/encore/external_api/boxaudit/repository/interfaces/IBoxAuditRepository;", "boxAuditAPI", "provideCartScannerService", "Lcom/sweetwater/encore/dependency_injection/cart_scanner/ICartScannerService;", "mqttService", "Lcom/sweetwater/encore/dependency_injection/mqtt/IMqttService;", "provideConnectivityService", "Lcom/sweetwater/encore/dependency_injection/connectivity/IConnectivityService;", "provideContext", "provideDcServiceApi", "Lcom/sweetwater/encore/external_api/dcservice/remote/DcServiceAPI;", "authToken", "Lcom/sweetwater/encore/utilities/AuthToken;", "provideGDSAPI", "Lcom/sweetwater/encore/external_api/gds/remote/GDSAPI;", "provideGetEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "userInfoRepositoryImpl", "Lcom/sweetwater/encore/authorization/data/repository/interfaces/IUserInfoRepository;", "provideGson", "Lcom/google/gson/Gson;", "provideIODispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "provideInventoryApi", "Lcom/sweetwater/encore/external_api/inventory/remote/InventoryAPI;", "provideInventoryRepo", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "inventoryAPI", "provideJsonParser", "Lcom/sweetwater/encore/utilities/JsonParser;", "gson", "provideLoginEmployeeUseCase", "Lcom/sweetwater/encore/authorization/usecases/LoginEmployeeUseCase;", "api", "provideLogoutEmployeeUseCase", "Lcom/sweetwater/encore/authorization/usecases/LogoutEmployeeUseCase;", "provideMqttService", "provideProductsApi", "Lcom/sweetwater/encore/external_api/products/remote/ProductsAPI;", "provideProductsRepo", "Lcom/sweetwater/encore/external_api/products/repository/interfaces/IProductsRepository;", "productsAPI", "provideRecountDataRepo", "Lcom/sweetwater/encore/recounts/data/repository/interfaces/IRecountsRepository;", "recountsDataStore", "Landroidx/datastore/core/DataStore;", "Lcom/sweetwater/encore/RecountsData;", "provideRecountsDataStore", "provideSoundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "provideToken", "provideUserInfoRepo", "userInfoDatastore", "Lcom/sweetwater/encore/UserInfoMessage;", "provideUserInfoStore", "provideVibratorService", "Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "app_debug"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.sweetwater.encore.dependency_injection.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final android.content.Context provideContext(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final androidx.datastore.core.DataStore<com.sweetwater.encore.UserInfoMessage> provideUserInfoStore(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final androidx.datastore.core.DataStore<com.sweetwater.encore.RecountsData> provideRecountsDataStore(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.utilities.AuthToken provideToken() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.utilities.ApiHelper provideApiHelper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI provideDcServiceApi(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.utilities.AuthToken authToken) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.inventory.remote.InventoryAPI provideInventoryApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI provideBoxAuditAPI() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.products.remote.ProductsAPI provideProductsApi() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.gds.remote.GDSAPI provideGDSAPI() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.utilities.JsonParser provideJsonParser(@org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository provideInventoryRepo(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.remote.InventoryAPI inventoryAPI, @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository provideBoxAuditRepo(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI boxAuditAPI, @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository provideProductsRepo(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.products.remote.ProductsAPI productsAPI, @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository provideUserInfoRepo(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<com.sweetwater.encore.UserInfoMessage> userInfoDatastore) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository provideRecountDataRepo(@org.jetbrains.annotations.NotNull
    androidx.datastore.core.DataStore<com.sweetwater.encore.RecountsData> recountsDataStore) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase provideLoginEmployeeUseCase(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI api, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository userInfoRepositoryImpl, @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase provideLogoutEmployeeUseCase(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI api, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository userInfoRepositoryImpl, @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase provideGetEmployeeLoginDetailsUseCase(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository userInfoRepositoryImpl, @org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.sweetwater.encore.dependency_injection.mqtt.IMqttService provideMqttService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService provideCartScannerService(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.mqtt.IMqttService mqttService) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner provideBarcodeScannerService(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    public final com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService provideConnectivityService(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.dependency_injection.sound.ISoundService provideSoundService(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.sweetwater.encore.dependency_injection.vibrator.IVibratorService provideVibratorService(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final kotlinx.coroutines.CoroutineDispatcher provideIODispatcher() {
        return null;
    }
}