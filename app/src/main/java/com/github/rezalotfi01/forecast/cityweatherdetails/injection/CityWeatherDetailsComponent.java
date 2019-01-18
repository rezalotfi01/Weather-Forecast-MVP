package com.github.rezalotfi01.forecast.cityweatherdetails.injection;

import com.github.rezalotfi01.forecast.cityweatherdetails.view.CityWeatherDetailsActivity;
import com.github.rezalotfi01.forecast.injection.components.OpenWeatherMapComponent;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;

import dagger.Component;


@PerActivity
@Component(
        dependencies = OpenWeatherMapComponent.class,
        modules = CityWeatherDetailsModule.class
)
public interface CityWeatherDetailsComponent {

    CityWeatherDetailsActivity inject(CityWeatherDetailsActivity cityWeatherDetailsActivity);
}
