package com.github.rezalotfi01.forecast.data.remote;

import com.github.rezalotfi01.forecast.model.CityWeather;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface IOpenWeatherMapApi {

    @GET("weather")
    public Observable<CityWeather> getWeatherByCityName(@Query("q") String cityName, @Query("appid") String appId);

    @GET("weather")
    public Observable<CityWeather> getWeatherByCityId(@Query("id") long cityId, @Query("appid") String appId);
}
