package com.github.rezalotfi01.forecast.cityweathersearch.injection;

import com.github.rezalotfi01.forecast.cityweathersearch.CityWeatherSearchContract;
import com.github.rezalotfi01.forecast.cityweathersearch.presenter.CityWeatherSearchPresenter;
import com.github.rezalotfi01.forecast.data.remote.DataManager;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;


@Module
public class CityWeatherSearchModule {

    @PerActivity
    @Provides
    CityWeatherSearchContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherSearchPresenter(dataManager);
    }
}