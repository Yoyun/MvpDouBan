package com.soulin.mvpdouban.injection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Soulin on 2017/1/18.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ConfigPersistent {
}
