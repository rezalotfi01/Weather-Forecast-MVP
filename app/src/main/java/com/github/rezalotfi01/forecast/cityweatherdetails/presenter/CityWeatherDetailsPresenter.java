package com.github.rezalotfi01.forecast.cityweatherdetails.presenter;

import com.github.rezalotfi01.forecast.cityweatherdetails.CityWeatherDetailsContract;
import com.github.rezalotfi01.forecast.common.MvpBasePresenter;
import com.github.rezalotfi01.forecast.data.remote.DataManager;

import static com.github.rezalotfi01.forecast.data.remote.DataManager.applySchedulers;


public class CityWeatherDetailsPresenter extends MvpBasePresenter<CityWeatherDetailsContract.View>
        implements CityWeatherDetailsContract.Presenter {

    private DataManager dataManager;

    public CityWeatherDetailsPresenter(DataManager dataManager) {

        this.dataManager = dataManager;
    }

    @Override
    public void loadCityWeatherData(long id) {

        dataManager
                .getWeatherByCityId(id)
                .compose(applySchedulers())
                .subscribe(cityWeather -> {

                    if (getView() != null) {

                        getView().showCityWeatherData(cityWeather);
                    }
                });
    }
}
