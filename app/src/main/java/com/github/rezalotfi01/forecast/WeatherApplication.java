package com.github.rezalotfi01.forecast;

import android.app.Application;

import com.github.rezalotfi01.forecast.BuildConfig;
import com.github.rezalotfi01.forecast.injection.components.AppComponent;
import com.github.rezalotfi01.forecast.injection.components.DaggerAppComponent;
import com.github.rezalotfi01.forecast.injection.components.DaggerOpenWeatherMapComponent;
import com.github.rezalotfi01.forecast.injection.components.OpenWeatherMapComponent;
import com.github.rezalotfi01.forecast.injection.modules.AppModule;
import com.github.rezalotfi01.forecast.injection.modules.NetworkModule;


public class WeatherApplication extends Application {

    private OpenWeatherMapComponent openWeatherMapComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule(BuildConfig.OPENWEATHERMAP_URL))
                .build();

        openWeatherMapComponent = DaggerOpenWeatherMapComponent
                .builder()
                .appComponent(appComponent)
                .build();
    }

    public OpenWeatherMapComponent getOpenWeatherMapComponent() {
        return openWeatherMapComponent;
    }
}
