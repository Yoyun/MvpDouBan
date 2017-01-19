package com.soulin.mvpdouban.injection.component;

import com.soulin.mvpdouban.injection.ConfigPersistent;
import com.soulin.mvpdouban.injection.module.ActivityModule;

import dagger.Component;

/**
 * Created by Soulin on 2017/1/18.
 */
@ConfigPersistent
@Component(dependencies = ApplicationComponent.class)
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

}
