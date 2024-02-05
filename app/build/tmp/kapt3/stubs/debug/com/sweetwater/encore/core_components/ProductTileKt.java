package com.sweetwater.encore.core_components;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.tooling.preview.Preview;
import com.sweetwater.encore.R;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0003\u001a\u00da\u0001\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112M\u0010\u0014\u001aI\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0016\u0012\b\b\u0005\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0016\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0016\u0012\b\b\u0005\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00010\u0015H\u0007\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"ProductItemViewPreview", "", "ProductTile", "modifier", "Landroidx/compose/ui/Modifier;", "name", "", "imageUrl", "productManufacturer", "shortDescription", "isSerialNumberRequired", "", "isVarianceDetected", "hasBorderStroke", "hasBackground", "serialNumber", "productQuantity", "", "priority", "productBoxesCount", "onProductItemClicked", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "requiresSerialNumber", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;ILkotlin/jvm/functions/Function3;)V", "app_debug"})
public final class ProductTileKt {
    
    @androidx.compose.runtime.Composable
    @androidx.compose.ui.tooling.preview.Preview
    private static final void ProductItemViewPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ProductTile(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String imageUrl, @org.jetbrains.annotations.NotNull
    java.lang.String productManufacturer, @org.jetbrains.annotations.NotNull
    java.lang.String shortDescription, boolean isSerialNumberRequired, boolean isVarianceDetected, boolean hasBorderStroke, boolean hasBackground, @org.jetbrains.annotations.Nullable
    java.lang.String serialNumber, @org.jetbrains.annotations.Nullable
    java.lang.Integer productQuantity, @org.jetbrains.annotations.Nullable
    java.lang.Integer priority, int productBoxesCount, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.Boolean, kotlin.Unit> onProductItemClicked) {
    }
}