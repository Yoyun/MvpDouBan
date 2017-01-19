package com.soulin.mvpdouban.injection.component;

import com.soulin.mvpdouban.ui.main.MainActivity;
import com.soulin.mvpdouban.injection.PerActivity;
import com.soulin.mvpdouban.injection.module.ActivityModule;

import dagger.Subcomponent;

/**
 * Created by Soulin on 2017/1/18.
 */
@PerActivity
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
