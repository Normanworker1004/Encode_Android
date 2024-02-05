package com.sweetwater.encore.external_api.products.dto;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b5\b\u0087\b\u0018\u00002\u00020\u0001B\u00b9\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\u0002\u0010\u001dJ\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0007H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u0007H\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u00c6\u0003J\t\u0010?\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015H\u00c6\u0003J\t\u0010A\u001a\u00020\u0003H\u00c6\u0003J\t\u0010B\u001a\u00020\u0005H\u00c6\u0003J\t\u0010C\u001a\u00020\u0005H\u00c6\u0003J\t\u0010D\u001a\u00020\u001cH\u00c6\u0003J\t\u0010E\u001a\u00020\u0007H\u00c6\u0003J\t\u0010F\u001a\u00020\u0005H\u00c6\u0003J\t\u0010G\u001a\u00020\u0005H\u00c6\u0003J\t\u0010H\u001a\u00020\u0005H\u00c6\u0003J\t\u0010I\u001a\u00020\u0007H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0007H\u00c6\u0003J\u00e7\u0001\u0010L\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u00072\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u00152\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u00c6\u0001J\u0013\u0010M\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010O\u001a\u00020\u0007H\u00d6\u0001J\t\u0010P\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010!R\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010#R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u001fR\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010#R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0011\u0010\u000f\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010#R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010!R\u0011\u0010\u0011\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010#R\u0011\u0010\u0012\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010!R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010#R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0011\u0010\u0019\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010!R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106\u00a8\u0006Q"}, d2 = {"Lcom/sweetwater/encore/external_api/products/dto/ProductInfo;", "", "captureShippedSerialNumber", "", "category", "", "categoryId", "", "condition", "cost", "imageURL", "inStockExternal", "isMeasured", "locationId", "manufacturer", "manufacturerId", "name", "packingTreatment", "partNumber", "pick", "productBoxes", "", "Lcom/sweetwater/encore/external_api/products/dto/ProductBoxDto;", "productId", "productIdentifiers", "requiresSerialNumber", "shortDescription", "weight", "", "(ZLjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZILjava/lang/String;ILjava/lang/String;ILjava/lang/String;ZLjava/util/List;ILjava/util/List;ZLjava/lang/String;D)V", "getCaptureShippedSerialNumber", "()Z", "getCategory", "()Ljava/lang/String;", "getCategoryId", "()I", "getCondition", "getCost", "getImageURL", "getInStockExternal", "getLocationId", "getManufacturer", "getManufacturerId", "getName", "getPackingTreatment", "getPartNumber", "getPick", "getProductBoxes", "()Ljava/util/List;", "getProductId", "getProductIdentifiers", "getRequiresSerialNumber", "getShortDescription", "getWeight", "()D", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class ProductInfo {
    private final boolean captureShippedSerialNumber = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String category = null;
    private final int categoryId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String condition = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String cost = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String imageURL = null;
    private final int inStockExternal = 0;
    private final boolean isMeasured = false;
    private final int locationId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String manufacturer = null;
    private final int manufacturerId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String name = null;
    private final int packingTreatment = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String partNumber = null;
    private final boolean pick = false;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.sweetwater.encore.external_api.products.dto.ProductBoxDto> productBoxes = null;
    private final int productId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<java.lang.String> productIdentifiers = null;
    private final boolean requiresSerialNumber = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String shortDescription = null;
    private final double weight = 0.0;
    
    @org.jetbrains.annotations.NotNull
    public final com.sweetwater.encore.external_api.products.dto.ProductInfo copy(boolean captureShippedSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String category, int categoryId, @org.jetbrains.annotations.NotNull
    java.lang.String condition, @org.jetbrains.annotations.NotNull
    java.lang.String cost, @org.jetbrains.annotations.NotNull
    java.lang.String imageURL, int inStockExternal, boolean isMeasured, int locationId, @org.jetbrains.annotations.NotNull
    java.lang.String manufacturer, int manufacturerId, @org.jetbrains.annotations.NotNull
    java.lang.String name, int packingTreatment, @org.jetbrains.annotations.NotNull
    java.lang.String partNumber, boolean pick, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.external_api.products.dto.ProductBoxDto> productBoxes, int productId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> productIdentifiers, boolean requiresSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String shortDescription, double weight) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public ProductInfo(boolean captureShippedSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String category, int categoryId, @org.jetbrains.annotations.NotNull
    java.lang.String condition, @org.jetbrains.annotations.NotNull
    java.lang.String cost, @org.jetbrains.annotations.NotNull
    java.lang.String imageURL, int inStockExternal, boolean isMeasured, int locationId, @org.jetbrains.annotations.NotNull
    java.lang.String manufacturer, int manufacturerId, @org.jetbrains.annotations.NotNull
    java.lang.String name, int packingTreatment, @org.jetbrains.annotations.NotNull
    java.lang.String partNumber, boolean pick, @org.jetbrains.annotations.NotNull
    java.util.List<com.sweetwater.encore.external_api.products.dto.ProductBoxDto> productBoxes, int productId, @org.jetbrains.annotations.NotNull
    java.util.List<java.lang.String> productIdentifiers, boolean requiresSerialNumber, @org.jetbrains.annotations.NotNull
    java.lang.String shortDescription, double weight) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getCaptureShippedSerialNumber() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final int component3() {
        return 0;
    }
    
    public final int getCategoryId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCondition() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCost() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getImageURL() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getInStockExternal() {
        return 0;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isMeasured() {
        return false;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getLocationId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getManufacturer() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getManufacturerId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component12() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int getPackingTreatment() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPartNumber() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean getPick() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.external_api.products.dto.ProductBoxDto> component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.sweetwater.encore.external_api.products.dto.ProductBoxDto> getProductBoxes() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    public final int getProductId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<java.lang.String> getProductIdentifiers() {
        return null;
    }
    
    public final boolean component19() {
        return false;
    }
    
    public final boolean getRequiresSerialNumber() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShortDescription() {
        return null;
    }
    
    public final double component21() {
        return 0.0;
    }
    
    public final double getWeight() {
        return 0.0;
    }
}