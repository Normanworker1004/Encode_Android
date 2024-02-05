package com.sweetwater.encore.cycle_counts.viewmodels;

import android.content.Context;
import androidx.compose.runtime.State;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.sweetwater.encore.R;
import com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase;
import com.sweetwater.encore.cycle_counts.dto.ProductScanInfo;
import com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState;
import com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner;
import com.sweetwater.encore.dependency_injection.sound.ISoundService;
import com.sweetwater.encore.dependency_injection.vibrator.IVibratorService;
import com.sweetwater.encore.external_api.inventory.dto.requests.UploadProductCountsRequest;
import com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository;
import com.sweetwater.encore.external_api.products.dto.ProductInfo;
import com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse;
import com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository;
import com.sweetwater.encore.utilities.IKeyboardInputViewModel;
import com.sweetwater.encore.utilities.Resource;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.CoroutineDispatcher;
import java.time.LocalDateTime;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0004\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BO\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u0006\u00107\u001a\u000208J\u0011\u00109\u001a\u000208H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010:J\u0019\u0010;\u001a\u0002082\u0006\u0010<\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010=J\u0019\u0010>\u001a\u0002082\u0006\u0010\u0011\u001a\u00020\u0012H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010?J\u0018\u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0017H\u0002J\u0010\u0010B\u001a\u0002082\u0006\u0010C\u001a\u00020\u0017H\u0002J\u0018\u0010D\u001a\u0002082\u0006\u0010A\u001a\u00020\"2\u0006\u0010E\u001a\u00020\u0017H\u0002J\u0010\u0010F\u001a\u0002082\u0006\u0010E\u001a\u00020\u0017H\u0016J\u0006\u0010G\u001a\u000208J\u0010\u0010H\u001a\u0002082\u0006\u0010I\u001a\u00020\"H\u0016J\u0006\u0010J\u001a\u000208J\u001e\u0010K\u001a\u0002082\u0006\u0010L\u001a\u00020\u00172\u0006\u0010C\u001a\u00020\u00172\u0006\u0010M\u001a\u00020\"J\u0017\u0010N\u001a\u0002082\b\u0010O\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u0002082\u0006\u0010C\u001a\u00020\u0017H\u0002J\u001f\u0010R\u001a\u0002082\u0006\u0010S\u001a\u00020T2\b\u0010O\u001a\u0004\u0018\u00010\u0019H\u0002\u00a2\u0006\u0002\u0010UJ\u0018\u0010V\u001a\u0002082\u0006\u0010S\u001a\u00020T2\u0006\u0010C\u001a\u00020\u0017H\u0002J\b\u0010W\u001a\u000208H\u0002J\u0019\u0010X\u001a\u0002082\u0006\u0010Y\u001a\u00020\"H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010ZJ!\u0010[\u001a\u0002082\u0006\u0010C\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020]H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010^R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b\'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001c0-\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u00100\u001a\u00020\u00198F\u00a2\u0006\u0006\u001a\u0004\b1\u0010(R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00102\u001a\u00020\u00178F\u00a2\u0006\u0006\u001a\u0004\b3\u0010%R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u00104\u001a\u00020\"8F\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006_"}, d2 = {"Lcom/sweetwater/encore/cycle_counts/viewmodels/CycleCountScanUpcsViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/sweetwater/encore/utilities/IKeyboardInputViewModel;", "inventoryRepository", "Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;", "productsRepository", "Lcom/sweetwater/encore/external_api/products/repository/interfaces/IProductsRepository;", "getEmployeeLoginDetailsUseCase", "Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;", "barcodeScanner", "Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;", "soundService", "Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;", "vibratorService", "Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "context", "Landroid/content/Context;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lcom/sweetwater/encore/external_api/inventory/repository/interfaces/IInventoryRepository;Lcom/sweetwater/encore/external_api/products/repository/interfaces/IProductsRepository;Lcom/sweetwater/encore/authorization/usecases/GetEmployeeLoginDetailsUseCase;Lcom/sweetwater/encore/dependency_injection/barcode_scanner/IBarcodeScanner;Lcom/sweetwater/encore/dependency_injection/sound/ISoundService;Lcom/sweetwater/encore/dependency_injection/vibrator/IVibratorService;Lkotlinx/coroutines/CoroutineDispatcher;Landroid/content/Context;Landroidx/lifecycle/SavedStateHandle;)V", "_campusId", "", "_countRequestId", "", "_cycleCountScanUpcsState", "Landroidx/compose/runtime/MutableState;", "Lcom/sweetwater/encore/cycle_counts/state/CycleCountScanUpcsState;", "_employeeId", "_isValidSerialNumber", "Lcom/sweetwater/encore/external_api/products/dto/SerialNumbersValidationResponse;", "_locationName", "_shouldForce", "", "campusId", "getCampusId", "()Ljava/lang/String;", "countRequestId", "getCountRequestId", "()I", "currentProductInfo", "Ljava/util/ArrayList;", "Lcom/sweetwater/encore/external_api/products/dto/ProductInfo;", "cycleCountScanUpcsState", "Landroidx/compose/runtime/State;", "getCycleCountScanUpcsState", "()Landroidx/compose/runtime/State;", "employeeId", "getEmployeeId", "locationName", "getLocationName", "shouldForce", "getShouldForce", "()Z", "clearErrorMessage", "", "displayFullScreenError", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProductInfo", "productIdentifier", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserData", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleProductIdentifierInput", "isKeyed", "handleSerialNumberInput", "serialNumber", "handleTextInput", "text", "onConfirmKeyboard", "onDoneButtonClicked", "onKeyboardToggled", "isToggled", "onNavigatedTo", "onProductClicked", "name", "requiresSerialNumber", "updateEditingProductQuantity", "quantity", "(Ljava/lang/Integer;)V", "updateEditingProductSerialNumber", "updateProductQuantity", "product", "Lcom/sweetwater/encore/cycle_counts/dto/ProductScanInfo;", "(Lcom/sweetwater/encore/cycle_counts/dto/ProductScanInfo;Ljava/lang/Integer;)V", "updateProductSerialNumber", "updateScanInfoWithVariance", "uploadProductCountsForCountRequest", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateSerialNumbersForProductId", "productId", "", "(Ljava/lang/String;Ljava/lang/Number;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CycleCountScanUpcsViewModel extends androidx.lifecycle.ViewModel implements com.sweetwater.encore.utilities.IKeyboardInputViewModel {
    private final com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository = null;
    private final com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository productsRepository = null;
    private final com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase = null;
    private final com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner = null;
    private final com.sweetwater.encore.dependency_injection.sound.ISoundService soundService = null;
    private final com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService = null;
    private final kotlinx.coroutines.CoroutineDispatcher ioDispatcher = null;
    private final android.content.Context context = null;
    private androidx.compose.runtime.MutableState<com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState> _cycleCountScanUpcsState;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.State<com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState> cycleCountScanUpcsState = null;
    private java.lang.String _locationName = "";
    private int _countRequestId = 0;
    private int _employeeId = 0;
    private java.lang.String _campusId = "";
    private java.util.ArrayList<com.sweetwater.encore.external_api.products.dto.ProductInfo> currentProductInfo;
    private boolean _shouldForce = false;
    private com.sweetwater.encore.external_api.products.dto.SerialNumbersValidationResponse _isValidSerialNumber;
    
    @javax.inject.Inject
    public CycleCountScanUpcsViewModel(@org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.inventory.repository.interfaces.IInventoryRepository inventoryRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.external_api.products.repository.interfaces.IProductsRepository productsRepository, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.authorization.usecases.GetEmployeeLoginDetailsUseCase getEmployeeLoginDetailsUseCase, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.barcode_scanner.IBarcodeScanner barcodeScanner, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.sound.ISoundService soundService, @org.jetbrains.annotations.NotNull
    com.sweetwater.encore.dependency_injection.vibrator.IVibratorService vibratorService, @org.jetbrains.annotations.NotNull
    kotlinx.coroutines.CoroutineDispatcher ioDispatcher, @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.runtime.State<com.sweetwater.encore.cycle_counts.state.CycleCountScanUpcsState> getCycleCountScanUpcsState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLocationName() {
        return null;
    }
    
    public final int getCountRequestId() {
        return 0;
    }
    
    public final int getEmployeeId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCampusId() {
        return null;
    }
    
    public final boolean getShouldForce() {
        return false;
    }
    
    public final void onNavigatedTo() {
    }
    
    public final void onDoneButtonClicked() {
    }
    
    public final void onProductClicked(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String serialNumber, boolean requiresSerialNumber) {
    }
    
    public final void clearErrorMessage() {
    }
    
    private final void handleTextInput(boolean isKeyed, java.lang.String text) {
    }
    
    private final void handleSerialNumberInput(java.lang.String serialNumber) {
    }
    
    private final void handleProductIdentifierInput(boolean isKeyed, java.lang.String productIdentifier) {
    }
    
    private final void updateEditingProductQuantity(java.lang.Integer quantity) {
    }
    
    private final void updateEditingProductSerialNumber(java.lang.String serialNumber) {
    }
    
    private final void updateProductQuantity(com.sweetwater.encore.cycle_counts.dto.ProductScanInfo product, java.lang.Integer quantity) {
    }
    
    private final void updateProductSerialNumber(com.sweetwater.encore.cycle_counts.dto.ProductScanInfo product, java.lang.String serialNumber) {
    }
    
    private final void updateScanInfoWithVariance() {
    }
    
    private final java.lang.Object getProductInfo(java.lang.String productIdentifier, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object validateSerialNumbersForProductId(java.lang.String serialNumber, java.lang.Number productId, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object uploadProductCountsForCountRequest(boolean force, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    private final java.lang.Object getUserData(android.content.Context context, kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @java.lang.Override
    public void onKeyboardToggled(boolean isToggled) {
    }
    
    @java.lang.Override
    public void onConfirmKeyboard(@org.jetbrains.annotations.NotNull
    java.lang.String text) {
    }
    
    private final java.lang.Object displayFullScreenError(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
}