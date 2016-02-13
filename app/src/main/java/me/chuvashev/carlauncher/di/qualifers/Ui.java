package me.chuvashev.carlauncher.di.qualifers;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:48
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Ui {}
