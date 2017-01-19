package com.soulin.mvpdouban.util;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * Created by Soulin on 2017/1/17.
 */

@GsonTypeAdapterFactory
public abstract class MyGsonTypeAdapterFactory implements TypeAdapterFactory {

    public static TypeAdapterFactory create() {
        return new AutoValueGson_MyGsonTypeAdapterFactory();
    }
}
