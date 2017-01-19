package com.soulin.mvpdouban;

import android.support.test.runner.AndroidJUnit4;

import com.google.gson.Gson;
import com.soulin.mvpdouban.data.model.MovieList;
import com.soulin.mvpdouban.data.remote.MoviesService;

import org.junit.Test;
import org.junit.runner.RunWith;

import rx.functions.Action1;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {

        MoviesService moviesService = MoviesService.Creator.newMoviesService();
        moviesService.getMovies(0, 10).subscribe(new Action1<MovieList>() {
            @Override
            public void call(MovieList movieList) {
                System.out.println(new Gson().toJson(movieList));
            }
        });
    }
}
