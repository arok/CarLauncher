package me.chuvashev.carlauncher.data.launcher;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import me.chuvashev.carlauncher.domain.launcher.AppModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import rx.observers.TestSubscriber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 21:15
 */
public class ApplicationsExternalStorageTest {

    public static final String MOCK_NAME_1 = "MOCK NAME 1";
    public static final String MOCK_NAME_2 = "MOCK NAME 2";
    public static final String MOCK_PACKAGE1 = "mock.package1";
    public static final String MOCK_PACKAGE2 = "mock.package2";
    public static final String MOCK_PACKAGE_NAME1 = "mock.package.name1";
    public static final String MOCK_PACKAGE_NAME2 = "mock.package.name2";

    @Mock PackageManager mPackageManager;
    @Mock ApplicationInfo mApplicationInfo1;
    @Mock ApplicationInfo mApplicationInfo2;
    @Mock Intent mMockIntent1;
    @Mock Intent mMockIntent2;
    @Mock ComponentName mComponentName1;
    @Mock ComponentName mComponentName2;

    ApplicationsExternalStorage mStorage;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mStorage = new ApplicationsExternalStorage(mPackageManager);
    }

    @Test
    public void test_GetEmmitTwoElements() throws Exception {
        final ArrayList<ApplicationInfo> applicationInfos = new ArrayList<>();

        mApplicationInfo1.name = MOCK_NAME_1;
        mApplicationInfo1.packageName = MOCK_PACKAGE1;
        applicationInfos.add(mApplicationInfo1);

        mApplicationInfo2.name = MOCK_NAME_2;
        mApplicationInfo2.packageName = MOCK_PACKAGE2;
        applicationInfos.add(mApplicationInfo2);

        doReturn(MOCK_PACKAGE1).when(mComponentName1).getPackageName();
        doReturn(MOCK_PACKAGE_NAME1).when(mComponentName1).getClassName();
        doReturn(mComponentName1).when(mMockIntent1).getComponent();

        doReturn(MOCK_PACKAGE2).when(mComponentName2).getPackageName();
        doReturn(MOCK_PACKAGE_NAME2).when(mComponentName2).getClassName();
        doReturn(mComponentName2).when(mMockIntent2).getComponent();

        doReturn(applicationInfos).when(mPackageManager).getInstalledApplications(0);
        doReturn(mMockIntent1).when(mPackageManager).getLaunchIntentForPackage(MOCK_PACKAGE1);
        doReturn(mMockIntent2).when(mPackageManager).getLaunchIntentForPackage(MOCK_PACKAGE2);

        final TestSubscriber<List<AppModel>> testSubscriber = new TestSubscriber<>();
        mStorage.get().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertCompleted();

        final List<AppModel> modelList = testSubscriber.getOnNextEvents().get(0);

        assertEquals(modelList.size(), 2);

        assertEquals(modelList.get(0).getName(), MOCK_NAME_1);
        assertEquals(modelList.get(0).getPackageName(), MOCK_PACKAGE1);
        assertEquals(modelList.get(0).getLaunchActivityName(), MOCK_PACKAGE_NAME1);

        assertEquals(modelList.get(1).getName(), MOCK_NAME_2);
        assertEquals(modelList.get(1).getPackageName(), MOCK_PACKAGE2);
        assertEquals(modelList.get(1).getLaunchActivityName(), MOCK_PACKAGE_NAME2);
    }

    @Test
    public void test_PutHasEmptyOutput() throws Exception {
        final TestSubscriber<Void> testSubscriber = new TestSubscriber<>();
        mStorage.put(Collections.emptyList()).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertNoValues();
        testSubscriber.assertCompleted();
    }

}