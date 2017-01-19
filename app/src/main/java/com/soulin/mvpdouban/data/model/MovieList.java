package com.soulin.mvpdouban.data.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Soulin on 2017/1/17.
 */

@AutoValue
public abstract class MovieList {

    @SerializedName("count")
    public abstract int count();

    @SerializedName("start")
    public abstract int start();

    @SerializedName("total")
    public abstract int total();

    @SerializedName("subjects")
    public abstract List<Movie> subjects();

    public static TypeAdapter<MovieList> typeAdapter(Gson gson) {
        return new AutoValue_MovieList.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_MovieList.Builder();
    }


    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder count(int count);

        public abstract Builder start(int start);

        public abstract Builder total(int total);

        public abstract Builder subjects(List<Movie> subjects);

        public abstract MovieList build();
    }
}
