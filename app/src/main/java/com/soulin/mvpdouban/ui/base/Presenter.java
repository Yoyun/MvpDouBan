package com.soulin.mvpdouban.ui.base;

/**
 * Created by Soulin on 2017/1/18.
 */

public interface Presenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
