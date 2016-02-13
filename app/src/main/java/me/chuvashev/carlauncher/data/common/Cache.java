package me.chuvashev.carlauncher.data.common;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:16
 */
public interface Cache<Type> {

    void put(Type type);
    Type get(Type type);

}
