package com.soulin.mvpdouban.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.soulin.mvpdouban.R;
import com.soulin.mvpdouban.data.SyncService;
import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.ui.base.BaseActivity;
import com.soulin.mvpdouban.util.DialogFactory;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements MainMvpView  {

    private static final String EXTRA_TRIGGER_SYNC_FLAG =
            "com.soulin.weidao.ui.main.MainActivity.EXTRA_TRIGGER_SYNC_FLAG";

    @Inject
    MainPresenter mMainPresenter;
    @Inject
    MoviesAdapter mMoviesAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    // 用于触发数据的同步与创建
    public static Intent getStartIntent(Context context, boolean triggerDataSyncOnCreate) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(EXTRA_TRIGGER_SYNC_FLAG, triggerDataSyncOnCreate);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        activityComponent().inject(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRecyclerView.setAdapter(mMoviesAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMainPresenter.attachView(this);
        mMainPresenter.loadMovies();

        if (getIntent().getBooleanExtra(EXTRA_TRIGGER_SYNC_FLAG, true)) {
            startService(SyncService.getStartIntent(this));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMainPresenter.detachView();
    }

    @Override
    public void showMovies(List<Movie> movies) {
        mMoviesAdapter.setMovies(movies);
        mMoviesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoviesEmpty() {
        mMoviesAdapter.setMovies(Collections.<Movie>emptyList());
        mMoviesAdapter.notifyDataSetChanged();
        Toast.makeText(this, R.string.empty_movies, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError() {
        DialogFactory.createGenericErrorDialog(this, getString(R.string.error_loading_movies))
                .show();
    }
}
