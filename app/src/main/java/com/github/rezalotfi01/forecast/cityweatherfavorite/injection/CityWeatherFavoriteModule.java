package com.github.rezalotfi01.forecast.cityweatherfavorite.injection;

import com.github.rezalotfi01.forecast.cityweatherfavorite.CityWeatherFavoriteContract;
import com.github.rezalotfi01.forecast.cityweatherfavorite.presenter.CityWeatherFavoritePresenter;
import com.github.rezalotfi01.forecast.data.remote.DataManager;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;


@Module
public class CityWeatherFavoriteModule {

    @PerActivity
    @Provides
    CityWeatherFavoriteContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherFavoritePresenter(dataManager);
    }
}
