package com.github.rezalotfi01.forecast.injection.modules;

import com.github.rezalotfi01.forecast.data.remote.IOpenWeatherMapApi;
import com.github.rezalotfi01.forecast.injection.scopes.PerApplication;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;



@Module
public class OpenWeatherMapModule {

    @Provides
    @PerApplication
    IOpenWeatherMapApi providesOpenWeatherMapApi(Retrofit retrofit) {

        return retrofit.create(IOpenWeatherMapApi.class);
    }
}