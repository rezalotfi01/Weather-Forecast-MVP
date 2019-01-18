package com.github.rezalotfi01.forecast.cityweatherdetails.injection;

import com.github.rezalotfi01.forecast.cityweatherdetails.CityWeatherDetailsContract;
import com.github.rezalotfi01.forecast.cityweatherdetails.presenter.CityWeatherDetailsPresenter;
import com.github.rezalotfi01.forecast.data.remote.DataManager;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;

import dagger.Module;
import dagger.Provides;


@Module
public class CityWeatherDetailsModule {

    @PerActivity
    @Provides
    CityWeatherDetailsContract.Presenter providesPresenter(DataManager dataManager) {

        return new CityWeatherDetailsPresenter(dataManager);
    }
}
