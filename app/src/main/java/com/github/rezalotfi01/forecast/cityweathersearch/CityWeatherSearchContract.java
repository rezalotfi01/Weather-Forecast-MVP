package com.github.rezalotfi01.forecast.cityweathersearch;

import com.github.rezalotfi01.forecast.common.MvpModelListView;
import com.github.rezalotfi01.forecast.model.CityWeather;

import rx.Observable;


public interface CityWeatherSearchContract {

    interface View extends MvpModelListView<CityWeather> {

        void showSetToFavoritesSuccessful(CityWeather cityWeather);

        void showSetToFavoritesFailed(CityWeather cityWeather);

        void showRemovedFromFavoritesSuccessful(CityWeather cityWeather);

        void showRemovedFromFavoritesFailed(CityWeather cityWeather);
    }

    interface Presenter extends com.github.rezalotfi01.forecast.common.Presenter<View> {

        void onSearchTextChanged(Observable<CharSequence> searchObservable);

        void onFavoriteSelected(CityWeather cityWeather);
    }
}
