package me.chuvashev.carlauncher.data.common;

import rx.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:17
 */
public interface Storage<Type> {

    Observable<Type> get();
    Observable<Void> put(Type type);

}
