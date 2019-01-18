package com.github.rezalotfi01.forecast.injection.components;

import com.github.rezalotfi01.forecast.data.remote.DataManager;
import com.github.rezalotfi01.forecast.injection.modules.OpenWeatherMapModule;
import com.github.rezalotfi01.forecast.injection.scopes.PerApplication;

import dagger.Component;


@PerApplication
@Component(
        modules = OpenWeatherMapModule.class,
        dependencies = AppComponent.class
)
public interface OpenWeatherMapComponent {

    DataManager getDataManager();
}
