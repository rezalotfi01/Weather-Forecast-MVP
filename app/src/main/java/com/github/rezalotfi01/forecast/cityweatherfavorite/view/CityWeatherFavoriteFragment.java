package com.github.rezalotfi01.forecast.cityweatherfavorite.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rezalotfi01.forecast.R;
import com.github.rezalotfi01.forecast.WeatherApplication;
import com.github.rezalotfi01.forecast.cityweathercommon.CityWeatherAdapter;
import com.github.rezalotfi01.forecast.cityweatherfavorite.CityWeatherFavoriteContract;
import com.github.rezalotfi01.forecast.cityweatherfavorite.injection.DaggerCityWeatherFavoriteComponent;
import com.github.rezalotfi01.forecast.cityweatherfavorite.presenter.CityWeatherFavoritePresenter;
import com.github.rezalotfi01.forecast.model.CityWeather;
import com.github.rezalotfi01.forecast.widgets.ItemOffsetDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CityWeatherFavoriteFragment extends Fragment implements CityWeatherFavoriteContract.View {

    @Inject
    public CityWeatherFavoritePresenter presenter;

    @BindView(R.id.citiesweatherfavorite_recyclerview)
    RecyclerView cityWeatherRecyclerView;

    private CityWeatherAdapter cityWeatherAdapter;

    public static CityWeatherFavoriteFragment newInstance() {

        return new CityWeatherFavoriteFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerCityWeatherFavoriteComponent
                .builder()
                .openWeatherMapComponent(((WeatherApplication) getActivity().getApplication()).getOpenWeatherMapComponent())
                .build()
                .inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_cityweatherfavorite, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cityWeatherAdapter = new CityWeatherAdapter(getContext(), new ArrayList<>(), R.layout.item_city_weather_card);
        cityWeatherRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        ItemOffsetDecoration itemOffsetDecoration = new ItemOffsetDecoration(getContext(), R.dimen.item_offset);
        cityWeatherRecyclerView.addItemDecoration(itemOffsetDecoration);
        cityWeatherRecyclerView.setAdapter(cityWeatherAdapter);

        presenter.attachView(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.getFavoriteData();
    }

    @Override
    public void onDestroyView() {
        presenter.detachView(false);
        super.onDestroyView();
    }

    @Override
    public void addData(CityWeather data) {

    }

    @Override
    public void showData(List<CityWeather> data) {

        cityWeatherAdapter.setCityWeatherList(data);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showError(Throwable e) {

    }
}
