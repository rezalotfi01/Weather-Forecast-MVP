package com.github.rezalotfi01.forecast.cityweatherfavorite.injection;

import com.github.rezalotfi01.forecast.cityweatherfavorite.view.CityWeatherFavoriteFragment;
import com.github.rezalotfi01.forecast.injection.components.OpenWeatherMapComponent;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;

import dagger.Component;


@PerActivity
@Component(
        dependencies = OpenWeatherMapComponent.class,
        modules = CityWeatherFavoriteModule.class)
public interface CityWeatherFavoriteComponent {

    CityWeatherFavoriteFragment inject(CityWeatherFavoriteFragment fragment);
}