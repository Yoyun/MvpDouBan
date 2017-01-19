package com.soulin.mvpdouban.data;

import com.soulin.mvpdouban.data.local.DatabaseHelper;
import com.soulin.mvpdouban.data.local.PreferencesHelper;
import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.data.model.MovieList;
import com.soulin.mvpdouban.data.remote.MoviesService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Soulin on 2017/1/18.
 */

@Singleton
public class DataManager {

    private final MoviesService mMoviesService;
    private final DatabaseHelper mDatabaseHelper;
    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(MoviesService mMoviesService, DatabaseHelper mDatabaseHelper,
                       PreferencesHelper mPreferencesHelper) {
        this.mMoviesService = mMoviesService;
        this.mDatabaseHelper = mDatabaseHelper;
        this.mPreferencesHelper = mPreferencesHelper;
    }

    public PreferencesHelper getmPreferencesHelper() {
        return mPreferencesHelper;
    }

    public Observable<Movie> syncMovies() {
        return mMoviesService.getMovies(0, 66)
                .concatMap(new Func1<MovieList, Observable<Movie>>() {
                    @Override
                    public Observable<Movie> call(MovieList movieList) {
                        return mDatabaseHelper.setMovies(movieList.subjects());
                    }
                });
    }

    public Observable<List<Movie>> getMovies() {
        return mDatabaseHelper.getMovies().distinct();
    }
}
