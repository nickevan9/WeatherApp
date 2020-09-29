package com.example.weatherapp.di.modules;

import com.example.weatherapp.data.response.AirService;
import com.example.weatherapp.data.response.WeatherService;

import java.lang.annotation.Retention;

import javax.inject.Named;
import javax.inject.Qualifier;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Singleton
@Module(includes = ViewModelModule.class)
public class WeatherAppModule {

    private static final String BASE_URL_WEATHER = "http://www.hmhweather.xyz/api/";
    private static final String BASE_URL_AIR = "http://aqi.wd.amberweather.com/";

    @Singleton
    @Provides
    @Named("weather")
    static Retrofit provideWeatherRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL_WEATHER)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
                .build();
    }

    @Singleton
    @Provides
    @Named("air")
    static Retrofit provideAirRetrofit() {
        return new Retrofit.Builder().baseUrl(BASE_URL_AIR)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .client(okHttpClient)
                .build();
    }


//
//    @Singleton
//    @Provides
//    OkHttpClient getOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor) {
//        return new OkHttpClient.Builder()
//                .addInterceptor(httpLoggingInterceptor)
//                .build();
//    }
//
//
//    @Singleton
//    @Provides
//    HttpLoggingInterceptor getHttpLoggingInterceptor() {
//        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        return httpLoggingInterceptor;
//    }

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