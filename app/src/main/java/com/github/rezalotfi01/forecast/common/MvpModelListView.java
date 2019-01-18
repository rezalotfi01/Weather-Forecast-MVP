package com.github.rezalotfi01.forecast.common;

import java.util.List;


public interface MvpModelListView<M> extends MvpView {

    void addData(M data);

    void showData(List<M> data);

    void showLoading();

    void hideLoading();

    void showEmpty();

    void showError(Throwable e);
}
