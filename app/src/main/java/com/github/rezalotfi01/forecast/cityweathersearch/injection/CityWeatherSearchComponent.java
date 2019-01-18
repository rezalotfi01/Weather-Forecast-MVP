package com.github.rezalotfi01.forecast.cityweathersearch.injection;

import com.github.rezalotfi01.forecast.cityweathersearch.view.CityWeatherSearchFragment;
import com.github.rezalotfi01.forecast.injection.components.OpenWeatherMapComponent;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;

import dagger.Component;


@PerActivity
@Component(
        dependencies = OpenWeatherMapComponent.class,
        modules = CityWeatherSearchModule.class
)
public interface CityWeatherSearchComponent {

    CityWeatherSearchFragment inject(CityWeatherSearchFragment fragment);
}