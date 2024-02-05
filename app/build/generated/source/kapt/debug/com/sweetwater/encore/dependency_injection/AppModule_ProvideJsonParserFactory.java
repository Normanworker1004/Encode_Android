package com.sweetwater.encore.dependency_injection;

import com.google.gson.Gson;
import com.sweetwater.encore.utilities.JsonParser;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class AppModule_ProvideJsonParserFactory implements Factory<JsonParser> {
  private final Provider<Gson> gsonProvider;

  public AppModule_ProvideJsonParserFactory(Provider<Gson> gsonProvider) {
    this.gsonProvider = gsonProvider;
  }

  @Override
  public JsonParser get() {
    return provideJsonParser(gsonProvider.get());
  }

  public static AppModule_ProvideJsonParserFactory create(Provider<Gson> gsonProvider) {
    return new AppModule_ProvideJsonParserFactory(gsonProvider);
  }

  public static JsonParser provideJsonParser(Gson gson) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideJsonParser(gson));
  }
}
