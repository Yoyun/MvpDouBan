package com.soulin.mvpdouban.injection.module;

import android.app.Application;
import android.content.Context;

import com.soulin.mvpdouban.data.remote.MoviesService;
import com.soulin.mvpdouban.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Soulin on 2017/1/18.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        this.mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    MoviesService provideMoviesService() {
        return MoviesService.Creator.newMoviesService();
    }
}
