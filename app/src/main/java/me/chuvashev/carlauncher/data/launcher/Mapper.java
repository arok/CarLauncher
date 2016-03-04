package me.chuvashev.carlauncher.data.launcher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import me.chuvashev.carlauncher.domain.launcher.AppModel;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 21:07
 */
public class Mapper {

    public static AppModel map(ApplicationInfo applicationInfo, Intent launchIntent) {
        final ComponentName component = launchIntent.getComponent();
        return new AppModel(applicationInfo.name, component.getPackageName(), component.getClassName());
    }

}
