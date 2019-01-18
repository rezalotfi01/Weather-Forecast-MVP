package com.github.rezalotfi01.forecast.cityweathersearch.presenter;

import android.util.Log;

import com.github.rezalotfi01.forecast.cityweathersearch.CityWeatherSearchContract;
import com.github.rezalotfi01.forecast.common.MvpBasePresenter;
import com.github.rezalotfi01.forecast.data.remote.DataManager;
import com.github.rezalotfi01.forecast.injection.scopes.PerActivity;
import com.github.rezalotfi01.forecast.model.CityWeather;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

import static com.github.rezalotfi01.forecast.data.remote.DataManager.applySchedulers;



@PerActivity
public class CityWeatherSearchPresenter extends MvpBasePresenter<CityWeatherSearchContract.View>
        implements CityWeatherSearchContract.Presenter {

    private DataManager dataManager;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    @Inject
    public CityWeatherSearchPresenter(DataManager dataManager) {

        this.dataManager = dataManager;
    }

    @Override
    public void detachView(boolean retainInstance) {

        if (compositeSubscription != null && !compositeSubscription.isUnsubscribed()) {

            compositeSubscription.unsubscribe();
        }
        super.detachView(retainInstance);
    }

    @Override
    public void onSearchTextChanged(Observable<CharSequence> searchObservable) {

        Subscription subscription = searchObservable
                .debounce(300, TimeUnit.MILLISECONDS)
                .map(CharSequence::toString)
                .map(String::trim)
                .filter(searchTerm -> searchTerm.length() > 2)
                .distinctUntilChanged()
                // use switchmap to cancel the previous request
                .switchMap(searchTerm -> dataManager.getWeatherByCityName(searchTerm).subscribeOn(Schedulers.io()))
                .flatMap(cityWeather ->
                        dataManager.isCityWeatherFavorite(cityWeather.getId())
                                .flatMap(favorite -> {
                                    cityWeather.setFavorite(favorite);
                                    return Observable.<CityWeather>just(cityWeather);
                                }))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cityWeather -> {

                    if (getView() != null) {

                        getView().addData(cityWeather);
                    }
                }, error -> Log.d("onError", error.toString()));

        compositeSubscription.add(subscription);
    }


    @Override
    public void onFavoriteSelected(CityWeather cityWeather) {

        if (cityWeather.isFavorite()) {

            cityWeather.setFavorite(false);
            dataManager
                    .removeCityWeatherFromFavorites(cityWeather)
                    .compose(applySchedulers())
                    .subscribe(aVoid -> {
                        if (getView() != null) {

                            getView().showRemovedFromFavoritesSuccessful(cityWeather);
                        }

                    }, throwable -> {

                        cityWeather.setFavorite(true);

                        throwable.printStackTrace();
                        if (getView() != null) {

                            getView().showRemovedFromFavoritesFailed(cityWeather);
                        }
                    });
        } else {

            cityWeather.setFavorite(true);
            dataManager
                    .addCityWeatherToFavorites(cityWeather)
                    .compose(applySchedulers())
                    .subscribe(aVoid -> {

                        if (getView() != null) {

                            getView().showSetToFavoritesSuccessful(cityWeather);
                        }
                    }, throwable -> {

                        cityWeather.setFavorite(false);
                        throwable.printStackTrace();
                        if (getView() != null) {

                            getView().showSetToFavoritesFailed(cityWeather);
                        }
                    });
        }
    }
}
