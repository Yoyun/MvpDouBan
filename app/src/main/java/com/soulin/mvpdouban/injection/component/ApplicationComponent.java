package com.soulin.mvpdouban.injection.component;

import android.app.Application;
import android.content.Context;

import com.soulin.mvpdouban.data.DataManager;
import com.soulin.mvpdouban.data.SyncService;
import com.soulin.mvpdouban.data.local.DatabaseHelper;
import com.soulin.mvpdouban.data.local.PreferencesHelper;
import com.soulin.mvpdouban.data.remote.MoviesService;
import com.soulin.mvpdouban.injection.ApplicationContext;
import com.soulin.mvpdouban.injection.module.ApplicationModule;
import com.soulin.mvpdouban.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Soulin on 2017/1/18.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SyncService syncService);

    @ApplicationContext
    Context context();
    Application application();
    MoviesService moviesService();
    PreferencesHelper preferencesHelper();
    DatabaseHelper databaseHelper();
    DataManager dataManager();
    RxEventBus eventBus();
}
