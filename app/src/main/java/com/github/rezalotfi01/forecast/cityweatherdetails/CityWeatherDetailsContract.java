package com.github.rezalotfi01.forecast.cityweatherdetails;

import com.github.rezalotfi01.forecast.common.MvpView;
import com.github.rezalotfi01.forecast.model.CityWeather;


public interface CityWeatherDetailsContract {

    interface View extends MvpView {

        void showCityWeatherData(CityWeather cityWeather);
    }

    interface Presenter extends com.github.rezalotfi01.forecast.common.Presenter<View> {

        void loadCityWeatherData(long id);
    }
}