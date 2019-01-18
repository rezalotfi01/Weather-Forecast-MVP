package com.github.rezalotfi01.forecast.cityweatherfavorite.presenter;

import android.util.Log;

import com.github.rezalotfi01.forecast.cityweatherfavorite.CityWeatherFavoriteContract;
import com.github.rezalotfi01.forecast.common.MvpBasePresenter;
import com.github.rezalotfi01.forecast.data.remote.DataManager;
import com.github.rezalotfi01.forecast.model.CityWeather;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class CityWeatherFavoritePresenter extends MvpBasePresenter<CityWeatherFavoriteContract.View>
        implements CityWeatherFavoriteContract.Presenter {

    private final DataManager dataManager;

    @Inject
    public CityWeatherFavoritePresenter(DataManager dataManager) {

        this.dataManager = dataManager;
    }

    @Override
    public void getFavoriteData() {

        dataManager
                .getAllFavoriteCityWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cityWeathers -> {
                    if (getView() != null) {

                        getView().showData(cityWeathers);
                    }
                }, throwable -> Log.e("Error", throwable.toString()));
    }

    @Override
    public void onFavoriteSelected(CityWeather cityWeather) {

        // TODO: Implement favorite handling
    }
}
