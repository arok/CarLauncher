package me.chuvashev.carlauncher.data.launcher;

import com.google.common.collect.Lists;
import me.chuvashev.carlauncher.domain.launcher.AppModel;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 23:06
 */
class MockData {

    public static final String NAME_1 = "Name1";
    public static final String PACKAGE_NAME_1 = "packageName1";
    public static final String LAUNCH_ACTIVITY_NAME_1 = "launchActivityName1";
    public static final String NAME_2 = "Name2";
    public static final String PACKAGE_NAME_2 = "packageName2";
    public static final String LAUNCH_ACTIVITY_NAME_2 = "launchActivityName2";

    public static final List<AppModel> MODELS = Lists.newArrayList(new AppModel(NAME_1, PACKAGE_NAME_1, LAUNCH_ACTIVITY_NAME_1),
            new AppModel(NAME_2, PACKAGE_NAME_2, LAUNCH_ACTIVITY_NAME_2));

}
