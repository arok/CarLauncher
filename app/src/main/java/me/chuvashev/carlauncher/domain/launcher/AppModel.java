package me.chuvashev.carlauncher.domain.launcher;

import android.support.annotation.NonNull;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:29
 */
public class AppModel {

    private String mName;
    private String mPackageName;
    private String mLaunchActivityName;

    public AppModel(String name, String packageName, String launchActivityName) {
        mName = name;
        mPackageName = packageName;
        mLaunchActivityName = launchActivityName;
    }

    @NonNull
    public String getPackageName() {
        if (mPackageName == null) {
            return "";
        }
        return mPackageName;
    }

    @NonNull
    public String getLaunchActivityName() {
        if (mLaunchActivityName == null) {
            return "";
        }
        return mLaunchActivityName;
    }

    @NonNull
    public String getName() {
        if (mName == null) {
            return "";
        }
        return mName;
    }

}
