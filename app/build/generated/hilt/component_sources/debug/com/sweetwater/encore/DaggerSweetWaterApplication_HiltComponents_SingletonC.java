package com.sweetwater.encore;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.datastore.core.DataStore;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.authorization.data.AppLoginStatusStorage;
import com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase;
import com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase;
import com.sweetwater.encore.authorization.viewmodels.AppAuthViewModel;
import com.sweetwater.encore.authorization.viewmodels.AppAuthViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.authorization.viewmodels.LoginViewModel;
import com.sweetwater.encore.authorization.viewmodels.LoginViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel;
import com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel;
import com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel;
import com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel;
import com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarViewModel;
import com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.dashboard.viewmodels.DashboardViewModel;
import com.sweetwater.encore.dashboard.viewmodels.DashboardViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideBarcodeScannerServiceFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideBoxAuditAPIFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideBoxAuditRepoFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideCartScannerServiceFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideConnectivityServiceFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideContextFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideDcServiceApiFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideGDSAPIFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideGetEmployeeLoginDetailsUseCaseFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideIODispatcherFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideInventoryApiFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideInventoryRepoFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideLoginEmployeeUseCaseFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideLogoutEmployeeUseCaseFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideMqttServiceFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideProductsApiFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideProductsRepoFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideRecountDataRepoFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideRecountsDataStoreFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideSoundServiceFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideTokenFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideUserInfoRepoFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideUserInfoStoreFactory;
import com.sweetwater.encore.dependency_injection.AppModule_ProvideVibratorServiceFactory;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService;
import com.sweetwater.encore.dependency_injection.connectivity.IConnectivityService;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI;
import com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository;
import com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI;
import com.sweetwater.encore.external_api.gds.remote.GDSAPI;
import com.sweetwater.encore.external_api.gds.repository.GDSRepository;
import com.sweetwater.encore.external_api.inventory.remote.InventoryAPI;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.external_api.products.remote.ProductsAPI;
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository;
import com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository;
import com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel;
import com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel;
import com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel_HiltModules_KeyModule_ProvideFactory;
import com.sweetwater.encore.utilities.AuthToken;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.SetBuilder;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DaggerSweetWaterApplication_HiltComponents_SingletonC {
  private DaggerSweetWaterApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public SweetWaterApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements SweetWaterApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements SweetWaterApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements SweetWaterApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements SweetWaterApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements SweetWaterApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements SweetWaterApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements SweetWaterApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public SweetWaterApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends SweetWaterApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends SweetWaterApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends SweetWaterApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends SweetWaterApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectSweetWaterActivity(SweetWaterActivity arg0) {
      injectSweetWaterActivity2(arg0);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return SetBuilder.<String>newSetBuilder(17).add(AppAuthViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(BoxAuditScanTrackingViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(CartScannerViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(CycleCountChooseZoneViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(CycleCountScanLocationViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(CycleCountScanUpcsViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(DashboardViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(LoginViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RecountsChooseZoneViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RecountsCompleteViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RecountsScanLocationViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RecountsScanProductViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(RecountsScanUPCViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(ScanCartQrCodeViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(TakeAPhotoCaptureViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(TakeAPhotoScanUPCViewModel_HiltModules_KeyModule_ProvideFactory.provide()).add(TopAppBarViewModel_HiltModules_KeyModule_ProvideFactory.provide()).build();
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    private SweetWaterActivity injectSweetWaterActivity2(SweetWaterActivity instance) {
      SweetWaterActivity_MembersInjector.injectStorage(instance, singletonCImpl.appLoginStatusStorageProvider.get());
      return instance;
    }
  }

  private static final class ViewModelCImpl extends SweetWaterApplication_HiltComponents.ViewModelC {
    private final SavedStateHandle savedStateHandle;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AppAuthViewModel> appAuthViewModelProvider;

    private Provider<BoxAuditScanTrackingViewModel> boxAuditScanTrackingViewModelProvider;

    private Provider<CartScannerViewModel> cartScannerViewModelProvider;

    private Provider<CycleCountChooseZoneViewModel> cycleCountChooseZoneViewModelProvider;

    private Provider<CycleCountScanLocationViewModel> cycleCountScanLocationViewModelProvider;

    private Provider<CycleCountScanUpcsViewModel> cycleCountScanUpcsViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<RecountsChooseZoneViewModel> recountsChooseZoneViewModelProvider;

    private Provider<RecountsCompleteViewModel> recountsCompleteViewModelProvider;

    private Provider<RecountsScanLocationViewModel> recountsScanLocationViewModelProvider;

    private Provider<RecountsScanProductViewModel> recountsScanProductViewModelProvider;

    private Provider<RecountsScanUPCViewModel> recountsScanUPCViewModelProvider;

    private Provider<ScanCartQrCodeViewModel> scanCartQrCodeViewModelProvider;

    private Provider<TakeAPhotoCaptureViewModel> takeAPhotoCaptureViewModelProvider;

    private Provider<TakeAPhotoScanUPCViewModel> takeAPhotoScanUPCViewModelProvider;

    private Provider<TopAppBarViewModel> topAppBarViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.savedStateHandle = savedStateHandleParam;
      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private GDSRepository gDSRepository() {
      return new GDSRepository(singletonCImpl.provideGDSAPIProvider.get(), singletonCImpl.provideContextProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.appAuthViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.boxAuditScanTrackingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.cartScannerViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.cycleCountChooseZoneViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.cycleCountScanLocationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.cycleCountScanUpcsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.recountsChooseZoneViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.recountsCompleteViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.recountsScanLocationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.recountsScanProductViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.recountsScanUPCViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
      this.scanCartQrCodeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 13);
      this.takeAPhotoCaptureViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 14);
      this.takeAPhotoScanUPCViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 15);
      this.topAppBarViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 16);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return MapBuilder.<String, Provider<ViewModel>>newMapBuilder(17).put("com.sweetwater.encore.authorization.viewmodels.AppAuthViewModel", ((Provider) appAuthViewModelProvider)).put("com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel", ((Provider) boxAuditScanTrackingViewModelProvider)).put("com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel", ((Provider) cartScannerViewModelProvider)).put("com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel", ((Provider) cycleCountChooseZoneViewModelProvider)).put("com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel", ((Provider) cycleCountScanLocationViewModelProvider)).put("com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel", ((Provider) cycleCountScanUpcsViewModelProvider)).put("com.sweetwater.encore.dashboard.viewmodels.DashboardViewModel", ((Provider) dashboardViewModelProvider)).put("com.sweetwater.encore.authorization.viewmodels.LoginViewModel", ((Provider) loginViewModelProvider)).put("com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel", ((Provider) recountsChooseZoneViewModelProvider)).put("com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel", ((Provider) recountsCompleteViewModelProvider)).put("com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel", ((Provider) recountsScanLocationViewModelProvider)).put("com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel", ((Provider) recountsScanProductViewModelProvider)).put("com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel", ((Provider) recountsScanUPCViewModelProvider)).put("com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel", ((Provider) scanCartQrCodeViewModelProvider)).put("com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel", ((Provider) takeAPhotoCaptureViewModelProvider)).put("com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel", ((Provider) takeAPhotoScanUPCViewModelProvider)).put("com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarViewModel", ((Provider) topAppBarViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return Collections.<String, Object>emptyMap();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.sweetwater.encore.authorization.viewmodels.AppAuthViewModel 
          return (T) new AppAuthViewModel(singletonCImpl.provideLoginEmployeeUseCaseProvider.get(), singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideLogoutEmployeeUseCaseProvider.get(), singletonCImpl.appLoginStatusStorageProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get());

          case 1: // com.sweetwater.encore.box_audit.viewmodels.BoxAuditScanTrackingViewModel 
          return (T) new BoxAuditScanTrackingViewModel(singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideBoxAuditRepoProvider.get(), singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get(), viewModelCImpl.savedStateHandle);

          case 2: // com.sweetwater.encore.cart_scanner.viewmodels.CartScannerViewModel 
          return (T) new CartScannerViewModel(singletonCImpl.provideContextProvider.get(), singletonCImpl.provideCartScannerServiceProvider.get(), singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.iConnectivityService(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideVibratorServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get());

          case 3: // com.sweetwater.encore.cycle_counts.viewmodels.CycleCountChooseZoneViewModel 
          return (T) new CycleCountChooseZoneViewModel(singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get());

          case 4: // com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanLocationViewModel 
          return (T) new CycleCountScanLocationViewModel(singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get(), viewModelCImpl.savedStateHandle);

          case 5: // com.sweetwater.encore.cycle_counts.viewmodels.CycleCountScanUpcsViewModel 
          return (T) new CycleCountScanUpcsViewModel(singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideProductsRepoProvider.get(), singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideVibratorServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get(), viewModelCImpl.savedStateHandle);

          case 6: // com.sweetwater.encore.dashboard.viewmodels.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.provideContextProvider.get(), singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get());

          case 7: // com.sweetwater.encore.authorization.viewmodels.LoginViewModel 
          return (T) new LoginViewModel(viewModelCImpl.savedStateHandle);

          case 8: // com.sweetwater.encore.recounts.viewmodels.RecountsChooseZoneViewModel 
          return (T) new RecountsChooseZoneViewModel(singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get());

          case 9: // com.sweetwater.encore.recounts.viewmodels.RecountsCompleteViewModel 
          return (T) new RecountsCompleteViewModel(singletonCImpl.provideRecountDataRepoProvider.get());

          case 10: // com.sweetwater.encore.recounts.viewmodels.RecountsScanLocationViewModel 
          return (T) new RecountsScanLocationViewModel(singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.provideRecountDataRepoProvider.get(), singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get());

          case 11: // com.sweetwater.encore.recounts.viewmodels.RecountsScanProductViewModel 
          return (T) new RecountsScanProductViewModel(singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideRecountDataRepoProvider.get(), singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), viewModelCImpl.savedStateHandle, singletonCImpl.provideContextProvider.get());

          case 12: // com.sweetwater.encore.recounts.viewmodels.RecountsScanUPCViewModel 
          return (T) new RecountsScanUPCViewModel(singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.provideRecountDataRepoProvider.get(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideVibratorServiceProvider.get(), viewModelCImpl.savedStateHandle, singletonCImpl.provideInventoryRepoProvider.get(), singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), singletonCImpl.provideContextProvider.get());

          case 13: // com.sweetwater.encore.cart_scanner.viewmodels.ScanCartQrCodeViewModel 
          return (T) new ScanCartQrCodeViewModel(singletonCImpl.provideContextProvider.get(), singletonCImpl.provideCartScannerServiceProvider.get(), singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.iConnectivityService(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideVibratorServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get());

          case 14: // com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoCaptureViewModel 
          return (T) new TakeAPhotoCaptureViewModel(singletonCImpl.provideContextProvider.get(), viewModelCImpl.gDSRepository(), singletonCImpl.provideGetEmployeeLoginDetailsUseCaseProvider.get(), singletonCImpl.provideSoundServiceProvider.get(), singletonCImpl.provideBarcodeScannerServiceProvider.get(), singletonCImpl.provideIODispatcherProvider.get(), viewModelCImpl.savedStateHandle);

          case 15: // com.sweetwater.encore.take_a_photo.viewmodels.TakeAPhotoScanUPCViewModel 
          return (T) new TakeAPhotoScanUPCViewModel(singletonCImpl.provideBarcodeScannerServiceProvider.get());

          case 16: // com.sweetwater.encore.dashboard.topappbar.presentation.TopAppBarViewModel 
          return (T) new TopAppBarViewModel();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends SweetWaterApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends SweetWaterApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends SweetWaterApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<AppLoginStatusStorage> appLoginStatusStorageProvider;

    private Provider<AuthToken> provideTokenProvider;

    private Provider<DcServiceAPI> provideDcServiceApiProvider;

    private Provider<DataStore<UserInfoMessage>> provideUserInfoStoreProvider;

    private Provider<IUserInfoRepository> provideUserInfoRepoProvider;

    private Provider<LoginEmployeeUseCase> provideLoginEmployeeUseCaseProvider;

    private Provider<GetEmployeeLoginDetailsUseCase> provideGetEmployeeLoginDetailsUseCaseProvider;

    private Provider<LogoutEmployeeUseCase> provideLogoutEmployeeUseCaseProvider;

    private Provider<CoroutineDispatcher> provideIODispatcherProvider;

    private Provider<Context> provideContextProvider;

    private Provider<BoxAuditAPI> provideBoxAuditAPIProvider;

    private Provider<IBoxAuditRepository> provideBoxAuditRepoProvider;

    private Provider<IBarcodeScanner> provideBarcodeScannerServiceProvider;

    private Provider<ISoundService> provideSoundServiceProvider;

    private Provider<ICartScannerService> provideCartScannerServiceProvider;

    private Provider<IVibratorService> provideVibratorServiceProvider;

    private Provider<InventoryAPI> provideInventoryApiProvider;

    private Provider<IInventoryRepository> provideInventoryRepoProvider;

    private Provider<ProductsAPI> provideProductsApiProvider;

    private Provider<IProductsRepository> provideProductsRepoProvider;

    private Provider<DataStore<RecountsData>> provideRecountsDataStoreProvider;

    private Provider<IRecountsRepository> provideRecountDataRepoProvider;

    private Provider<GDSAPI> provideGDSAPIProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private IConnectivityService iConnectivityService() {
      return AppModule_ProvideConnectivityServiceFactory.provideConnectivityService(ApplicationContextModule_ProvideContextFactory.provideContext(applicationContextModule));
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.appLoginStatusStorageProvider = DoubleCheck.provider(new SwitchingProvider<AppLoginStatusStorage>(singletonCImpl, 0));
      this.provideTokenProvider = DoubleCheck.provider(new SwitchingProvider<AuthToken>(singletonCImpl, 3));
      this.provideDcServiceApiProvider = DoubleCheck.provider(new SwitchingProvider<DcServiceAPI>(singletonCImpl, 2));
      this.provideUserInfoStoreProvider = DoubleCheck.provider(new SwitchingProvider<DataStore<UserInfoMessage>>(singletonCImpl, 5));
      this.provideUserInfoRepoProvider = DoubleCheck.provider(new SwitchingProvider<IUserInfoRepository>(singletonCImpl, 4));
      this.provideLoginEmployeeUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<LoginEmployeeUseCase>(singletonCImpl, 1));
      this.provideGetEmployeeLoginDetailsUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<GetEmployeeLoginDetailsUseCase>(singletonCImpl, 6));
      this.provideLogoutEmployeeUseCaseProvider = DoubleCheck.provider(new SwitchingProvider<LogoutEmployeeUseCase>(singletonCImpl, 7));
      this.provideIODispatcherProvider = DoubleCheck.provider(new SwitchingProvider<CoroutineDispatcher>(singletonCImpl, 8));
      this.provideContextProvider = DoubleCheck.provider(new SwitchingProvider<Context>(singletonCImpl, 9));
      this.provideBoxAuditAPIProvider = DoubleCheck.provider(new SwitchingProvider<BoxAuditAPI>(singletonCImpl, 11));
      this.provideBoxAuditRepoProvider = DoubleCheck.provider(new SwitchingProvider<IBoxAuditRepository>(singletonCImpl, 10));
      this.provideBarcodeScannerServiceProvider = DoubleCheck.provider(new SwitchingProvider<IBarcodeScanner>(singletonCImpl, 12));
      this.provideSoundServiceProvider = DoubleCheck.provider(new SwitchingProvider<ISoundService>(singletonCImpl, 13));
      this.provideCartScannerServiceProvider = DoubleCheck.provider(new SwitchingProvider<ICartScannerService>(singletonCImpl, 14));
      this.provideVibratorServiceProvider = DoubleCheck.provider(new SwitchingProvider<IVibratorService>(singletonCImpl, 15));
      this.provideInventoryApiProvider = DoubleCheck.provider(new SwitchingProvider<InventoryAPI>(singletonCImpl, 17));
      this.provideInventoryRepoProvider = DoubleCheck.provider(new SwitchingProvider<IInventoryRepository>(singletonCImpl, 16));
      this.provideProductsApiProvider = DoubleCheck.provider(new SwitchingProvider<ProductsAPI>(singletonCImpl, 19));
      this.provideProductsRepoProvider = DoubleCheck.provider(new SwitchingProvider<IProductsRepository>(singletonCImpl, 18));
      this.provideRecountsDataStoreProvider = DoubleCheck.provider(new SwitchingProvider<DataStore<RecountsData>>(singletonCImpl, 21));
      this.provideRecountDataRepoProvider = DoubleCheck.provider(new SwitchingProvider<IRecountsRepository>(singletonCImpl, 20));
      this.provideGDSAPIProvider = DoubleCheck.provider(new SwitchingProvider<GDSAPI>(singletonCImpl, 22));
    }

    @Override
    public void injectSweetWaterApplication(SweetWaterApplication sweetWaterApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.sweetwater.encore.authorization.data.AppLoginStatusStorage 
          return (T) new AppLoginStatusStorage();

          case 1: // com.sweetwater.encore.authorization.usecases.LoginEmployeeUseCase 
          return (T) AppModule_ProvideLoginEmployeeUseCaseFactory.provideLoginEmployeeUseCase(singletonCImpl.provideDcServiceApiProvider.get(), singletonCImpl.provideUserInfoRepoProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.sweetwater.encore.external_api.dcservice.remote.DcServiceAPI 
          return (T) AppModule_ProvideDcServiceApiFactory.provideDcServiceApi(singletonCImpl.provideTokenProvider.get());

          case 3: // com.sweetwater.encore.utilities.AuthToken 
          return (T) AppModule_ProvideTokenFactory.provideToken();

          case 4: // com.sweetwater.encore.authorization.data.repository.interfaces.IUserInfoRepository 
          return (T) AppModule_ProvideUserInfoRepoFactory.provideUserInfoRepo(singletonCImpl.provideUserInfoStoreProvider.get());

          case 5: // androidx.datastore.core.DataStore<com.sweetwater.encore.UserInfoMessage> 
          return (T) AppModule_ProvideUserInfoStoreFactory.provideUserInfoStore(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase 
          return (T) AppModule_ProvideGetEmployeeLoginDetailsUseCaseFactory.provideGetEmployeeLoginDetailsUseCase(singletonCImpl.provideUserInfoRepoProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 7: // com.sweetwater.encore.authorization.usecases.LogoutEmployeeUseCase 
          return (T) AppModule_ProvideLogoutEmployeeUseCaseFactory.provideLogoutEmployeeUseCase(singletonCImpl.provideDcServiceApiProvider.get(), singletonCImpl.provideUserInfoRepoProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 8: // kotlinx.coroutines.CoroutineDispatcher 
          return (T) AppModule_ProvideIODispatcherFactory.provideIODispatcher();

          case 9: // android.content.Context 
          return (T) AppModule_ProvideContextFactory.provideContext(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 10: // com.sweetwater.encore.external_api.boxaudit.repository.interfaces.IBoxAuditRepository 
          return (T) AppModule_ProvideBoxAuditRepoFactory.provideBoxAuditRepo(singletonCImpl.provideBoxAuditAPIProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 11: // com.sweetwater.encore.external_api.boxaudit.remote.BoxAuditAPI 
          return (T) AppModule_ProvideBoxAuditAPIFactory.provideBoxAuditAPI();

          case 12: // com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner 
          return (T) AppModule_ProvideBarcodeScannerServiceFactory.provideBarcodeScannerService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 13: // com.sweetwater.encore.dependency_injection.sound.ISoundService 
          return (T) AppModule_ProvideSoundServiceFactory.provideSoundService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 14: // com.sweetwater.encore.dependency_injection.cart_scanner.ICartScannerService 
          return (T) AppModule_ProvideCartScannerServiceFactory.provideCartScannerService(AppModule_ProvideMqttServiceFactory.provideMqttService());

          case 15: // com.sweetwater.encore.dependency_injection.vibrator.IVibratorService 
          return (T) AppModule_ProvideVibratorServiceFactory.provideVibratorService(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 16: // com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository 
          return (T) AppModule_ProvideInventoryRepoFactory.provideInventoryRepo(singletonCImpl.provideInventoryApiProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 17: // com.sweetwater.encore.external_api.inventory.remote.InventoryAPI 
          return (T) AppModule_ProvideInventoryApiFactory.provideInventoryApi();

          case 18: // com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository 
          return (T) AppModule_ProvideProductsRepoFactory.provideProductsRepo(singletonCImpl.provideProductsApiProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 19: // com.sweetwater.encore.external_api.products.remote.ProductsAPI 
          return (T) AppModule_ProvideProductsApiFactory.provideProductsApi();

          case 20: // com.sweetwater.encore.recounts.data.repository.interfaces.IRecountsRepository 
          return (T) AppModule_ProvideRecountDataRepoFactory.provideRecountDataRepo(singletonCImpl.provideRecountsDataStoreProvider.get());

          case 21: // androidx.datastore.core.DataStore<com.sweetwater.encore.RecountsData> 
          return (T) AppModule_ProvideRecountsDataStoreFactory.provideRecountsDataStore(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 22: // com.sweetwater.encore.external_api.gds.remote.GDSAPI 
          return (T) AppModule_ProvideGDSAPIFactory.provideGDSAPI();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
