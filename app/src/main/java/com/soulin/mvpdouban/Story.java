package com.soulin.mvpdouban;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

/**
 * Created by Soulin on 2017/1/16.
 */

@AutoValue
public abstract class Story {
    public abstract int id();

    public abstract String title();

    public static Story create(int id, String title) {
        return new AutoValue_Story(id, title);
    }

    public static TypeAdapter<Story> typeAdapter(Gson gson) {
        return new AutoValue_Story.GsonTypeAdapter(gson);
    }
}
