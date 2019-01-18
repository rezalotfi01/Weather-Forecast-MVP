package com.github.rezalotfi01.forecast.cityweatherdetails.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;

import com.github.rezalotfi01.forecast.R;
import com.github.rezalotfi01.forecast.WeatherApplication;
import com.github.rezalotfi01.forecast.cityweatherdetails.CityWeatherDetailsContract;
import com.github.rezalotfi01.forecast.cityweatherdetails.injection.DaggerCityWeatherDetailsComponent;
import com.github.rezalotfi01.forecast.common.BaseToolbarActivity;
import com.github.rezalotfi01.forecast.model.CityWeather;
import com.github.rezalotfi01.forecast.utilities.WeatherUtils;

import javax.inject.Inject;

import butterknife.BindView;


public class CityWeatherDetailsActivity extends BaseToolbarActivity
        implements CityWeatherDetailsContract.View {

    public static String CITY_ID_EXTRA = "city_id_extra";
    public static String CITY_NAME_EXTRA = "city_name_extra";

    @BindView(R.id.city_weather_icon_imageview)
    ImageView cityWeatherIconImageView;

    @Inject
    CityWeatherDetailsContract.Presenter presenter;

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_cityweatherdetails;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        long id = intent.getLongExtra(CITY_ID_EXTRA, Long.MIN_VALUE);
        String cityName = intent.getStringExtra(CITY_NAME_EXTRA);

        if (id == Long.MIN_VALUE || TextUtils.isEmpty(cityName)) {

            throw new IllegalArgumentException("id and cityName must be defined");
        }

        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle(cityName);
        }

        DaggerCityWeatherDetailsComponent
                .builder()
                .openWeatherMapComponent(((WeatherApplication) getApplication()).getOpenWeatherMapComponent())
                .build()
                .inject(this);

        presenter.attachView(this);
        presenter.loadCityWeatherData(id);
    }

    @Override
    protected void onDestroy() {
        presenter.detachView(false);
        super.onDestroy();
    }

    @Override
    public void showCityWeatherData(CityWeather cityWeather) {

        cityWeatherIconImageView
                .setImageResource(WeatherUtils
                        .getArtResourceForWeatherCondition(cityWeather.getWeather().get(0).getId()));
    }
}
