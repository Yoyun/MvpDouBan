package com.soulin.mvpdouban.ui.main;

import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.ui.base.MvpView;

import java.util.List;

/**
 * Created by Soulin on 2017/1/18.
 */

public interface MainMvpView extends MvpView {

    void showMovies(List<Movie> movies);

    void showMoviesEmpty();

    void showError();

}
