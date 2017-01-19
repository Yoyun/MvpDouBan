package com.soulin.mvpdouban.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.soulin.mvpdouban.injection.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Soulin on 2017/1/18.
 */

@Singleton
public class PreferencesHelper {

    public static final String PREF_FILE_NAME = "douban_pref_file";

    private final SharedPreferences mPref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        mPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear() {
        mPref.edit().clear().apply();
    }
}
