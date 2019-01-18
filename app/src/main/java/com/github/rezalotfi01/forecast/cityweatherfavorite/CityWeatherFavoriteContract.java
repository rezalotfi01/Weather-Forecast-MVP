package com.github.rezalotfi01.forecast.cityweatherfavorite;

import com.github.rezalotfi01.forecast.common.MvpModelListView;
import com.github.rezalotfi01.forecast.model.CityWeather;


public interface CityWeatherFavoriteContract {

    interface View extends MvpModelListView<CityWeather> {

    }

    interface Presenter extends com.github.rezalotfi01.forecast.common.Presenter<View> {

        void onFavoriteSelected(CityWeather cityWeather);

        void getFavoriteData();
    }
}
