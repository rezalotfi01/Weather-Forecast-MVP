package com.github.rezalotfi01.forecast.injection.components;

import android.app.Application;
import android.content.Context;

import com.github.rezalotfi01.forecast.WeatherApplication;
import com.github.rezalotfi01.forecast.data.local.DatabaseHelper;
import com.github.rezalotfi01.forecast.injection.modules.AppModule;
import com.github.rezalotfi01.forecast.injection.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;


@Singleton
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class
        }
)
public interface AppComponent {

    void inject(WeatherApplication weatherApplication);

    Application getApplication();

    Context getApplicationContext();

    Retrofit getRetrofit();

    DatabaseHelper getDatabaseHelper();
}
