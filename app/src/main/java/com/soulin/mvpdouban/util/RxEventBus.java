package com.soulin.mvpdouban.util;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Soulin on 2017/1/18.
 */

@Singleton
public class RxEventBus {

    private final PublishSubject<Object> mBusSubject;

    @Inject
    public RxEventBus() {
        mBusSubject = PublishSubject.create();
    }

    public void post(Object event) {
        mBusSubject.onNext(event);
    }

    public Observable<Object> observable() {
        return mBusSubject;
    }

    public <T> Observable<T> filteredObservable(final Class<T> eventClass) {
        return mBusSubject.ofType(eventClass);
    }
}
