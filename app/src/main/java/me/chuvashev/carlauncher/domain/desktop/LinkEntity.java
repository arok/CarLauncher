package me.chuvashev.carlauncher.domain.desktop;

import android.support.annotation.NonNull;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:36
 */
public class LinkEntity {

    private String mName;

    public LinkEntity(String name) {
        mName = name;
    }

    @NonNull
    public String getName() {
        if (mName == null) {
            return "";
        }
        return mName;
    }
}
