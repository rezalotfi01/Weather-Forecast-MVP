package com.github.rezalotfi01.forecast.common;


public interface Presenter<V extends MvpView> {

    void attachView(V view);

    void detachView(boolean retainInstance);
}
