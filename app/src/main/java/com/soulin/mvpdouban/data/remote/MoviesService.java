package com.soulin.mvpdouban.data.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soulin.mvpdouban.data.model.MovieList;
import com.soulin.mvpdouban.util.MyGsonTypeAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by Soulin on 2017/1/17.
 */

public interface MoviesService {

    String ENDPOINT = "https://api.douban.com/";

    @GET("v2/movie/coming_soon")
    Observable<MovieList> getMovies(
            @Query("start") int start,
            @Query("count") int count
    );

    class Creator {

        public static MoviesService newMoviesService() {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapterFactory(MyGsonTypeAdapterFactory.create())
                    .setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(MoviesService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(MoviesService.class);
        }
    }
}
