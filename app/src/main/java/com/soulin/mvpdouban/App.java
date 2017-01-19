package com.soulin.mvpdouban;

import android.app.Application;
import android.content.Context;

import com.soulin.mvpdouban.injection.component.ApplicationComponent;
import com.soulin.mvpdouban.injection.component.DaggerApplicationComponent;
import com.soulin.mvpdouban.injection.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by Soulin on 2017/1/18.
 */

public class App extends Application {
    private static App instance;
    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static App getInstance() {
        return instance;
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    public void setComponent(ApplicationComponent applicationComponent) {
        this.mApplicationComponent = applicationComponent;
    }
}
