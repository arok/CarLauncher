package me.chuvashev.carlauncher.domain.launcher;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 22:53
 */
public class AppModelTest {

    @Test
    public void testNonNullGetters() {
        AppModel appModel = new AppModel(null, null, null);

        Assert.assertNotNull(appModel.getName());
        Assert.assertNotNull(appModel.getPackageName());
        Assert.assertNotNull(appModel.getLaunchActivityName());
    }

}