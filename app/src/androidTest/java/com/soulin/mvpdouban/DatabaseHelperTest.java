package com.soulin.mvpdouban;

import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;
import com.soulin.mvpdouban.data.local.DatabaseHelper;
import com.soulin.mvpdouban.data.local.DbOpenHelper;
import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.data.model.MovieList;
import com.soulin.mvpdouban.data.remote.MoviesService;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import rx.Subscriber;
import rx.functions.Action1;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DatabaseHelperTest{
    @Test
    public void useAppContext() throws Exception {

        final DatabaseHelper mDatabaseHelper =
                new DatabaseHelper(new DbOpenHelper(App.getInstance()));

        MoviesService moviesService = MoviesService.Creator.newMoviesService();
        moviesService.getMovies(0, 10).subscribe(new Action1<MovieList>() {
            @Override
            public void call(MovieList movieList) {
                List<Movie> movies = movieList.subjects();
                mDatabaseHelper.setMovies(movies).subscribe(new Subscriber<Movie>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("onCompleted");
                        mDatabaseHelper.getMovies().subscribe(new Action1<List<Movie>>() {
                            @Override
                            public void call(List<Movie> movies) {
                                System.out.println(new Gson().toJson(movies));
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("onError: "+e.getMessage());
                    }

                    @Override
                    public void onNext(Movie movie) {
                        System.out.println("onNext");
                    }
                });
            }
        });
    }
}
