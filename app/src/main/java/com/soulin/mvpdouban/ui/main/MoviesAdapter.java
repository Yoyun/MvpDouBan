package com.soulin.mvpdouban.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.soulin.mvpdouban.R;
import com.soulin.mvpdouban.data.model.Movie;
import com.soulin.mvpdouban.injection.ApplicationContext;
import com.soulin.mvpdouban.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Soulin on 2017/1/18.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> mMovies;
    private int mImageWidth;
    private int mImageHeight;

    @Inject
    public MoviesAdapter(@ApplicationContext Context context) {
        super();
        mMovies = new ArrayList<>();
        mImageWidth = ScreenUtils.getScreenWidth(context);
        mImageHeight = mImageWidth / 3 * 4;
    }

    public void setMovies(List<Movie> movies) {
        mMovies = movies;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movies, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mMovies.get(position);
        holder.itemView.getLayoutParams().height = mImageHeight;


        String id = (String) holder.itemView.getTag();

        if (id == null || !id.equals(movie.id())) {
            holder.itemView.setTag(movie.id());

            holder.title.setText(movie.title());

            Glide.with(holder.itemView.getContext())
                    .load(movie.images().large())
                    .into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView) ImageView imageView;
        @BindView(R.id.title) TextView title;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
