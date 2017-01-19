package com.soulin.mvpdouban.util;

import rx.Subscription;

/**
 * Created by Soulin on 2017/1/18.
 */

public class RxUtil {

    public static void unsubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }
}
