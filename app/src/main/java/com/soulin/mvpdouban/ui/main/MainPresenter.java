package com.soulin.mvpdouban.ui.main;

import com.soulin.mvpdouban.data.DataManager;
import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.injection.ConfigPersistent;
import com.soulin.mvpdouban.ui.base.BasePresenter;
import com.soulin.mvpdouban.util.RxUtil;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by Soulin on 2017/1/18.
 */

@ConfigPersistent
public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public MainPresenter(DataManager dataManager) {
        this.mDataManager = dataManager;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

    public void loadMovies() {
        checkViewAttached();
        RxUtil.unsubscribe(mSubscription);
        mSubscription = mDataManager.getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e, "There was an error loading the movies.");
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(List<Movie> movies) {
                        if (movies.isEmpty()) {
                            getMvpView().showMoviesEmpty();
                        } else {
                            getMvpView().showMovies(movies);
                        }
                    }
                });
    }
}
