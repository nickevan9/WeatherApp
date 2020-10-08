package com.example.weatherapp.di.modules;

import com.example.weatherapp.BuildConfig;
import com.example.weatherapp.data.response.AirService;
import com.example.weatherapp.data.response.WeatherService;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.lang.annotation.Retention;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Singleton
@Module()
public class WeatherAppModule {

    private static final String BASE_URL_WEATHER = "http://www.hmhweather.xyz/api/";
    private static final String BASE_URL_AIR = "http://aqi.wd.amberweather.com/";

    @Singleton
    @Provides
    @Named("weather")
    static Retrofit provideWeatherRetrofit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL_WEATHER)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    @Named("air")
    static Retrofit provideAirRetrofit() {
        return new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL_AIR)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    public final OkHttpClient providesOkHttpClient() {
        okhttp3.OkHttpClient.Builder client = (new okhttp3.OkHttpClient.Builder()).connectTimeout(60L, TimeUnit.SECONDS).writeTimeout(60L, TimeUnit.SECONDS).readTimeout(60L, TimeUnit.SECONDS);
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addNetworkInterceptor((Interceptor)interceptor);
        OkHttpClient httpClient = client.build();
        return httpClient;
    }

    @Provides
    @Singleton
    public final Gson providesGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public final GsonConverterFactory providesGsonConverterFactory() {

        return GsonConverterFactory.create();
    }

    @Provides
    @Singleton
    public final RxJava2CallAdapterFactory providesRxJavaCallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }



    @Singleton
    @Provides
    static WeatherService provideRetrofitService(@Named("weather") Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }

    @Singleton
    @Provides
    static AirService provideAirService(@Named("air") Retrofit retrofit) {
        return retrofit.create(AirService.class);
    }

    @Qualifier
    @Retention(RUNTIME)
    public @interface Weather {}

    @Qualifier
    @Retention(RUNTIME)
    public @interface Air {}
}