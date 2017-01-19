package com.soulin.mvpdouban.injection.module;

import android.app.Activity;
import android.content.Context;

import com.soulin.mvpdouban.injection.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Soulin on 2017/1/18.
 */
@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }
}
