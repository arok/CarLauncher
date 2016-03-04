package me.chuvashev.carlauncher.data.launcher;

import me.chuvashev.carlauncher.domain.launcher.AppModel;
import org.junit.Before;
import org.junit.Test;
import rx.observers.TestSubscriber;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 23:01
 */
public class ApplicationsMemoryStorageTest {

    ApplicationsMemoryStorage mStorage;
    private TestSubscriber<List<AppModel>> mTestSubscriber;

    @Before
    public void setUp() throws Exception {
        mStorage = new ApplicationsMemoryStorage();
        mTestSubscriber = new TestSubscriber<>();
    }

    @Test
    public void testGetEmpty() throws Exception {
        mStorage.get().subscribe(mTestSubscriber);

        mTestSubscriber.assertNoErrors();
        mTestSubscriber.assertNoValues();
        mTestSubscriber.assertCompleted();
    }

    @Test
    public void testPut() throws Exception {
        final TestSubscriber<Void> testSubscriber = new TestSubscriber<>();

        mStorage.put(MockData.MODELS).subscribe(testSubscriber);

        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();
        testSubscriber.assertNoValues();
    }

    @Test
    public void testGetShouldReturnValues() {
        mStorage.put(MockData.MODELS).subscribe();

        mStorage.get().subscribe(mTestSubscriber);

        mTestSubscriber.assertNoErrors();
        mTestSubscriber.assertCompleted();
        mTestSubscriber.assertValue(MockData.MODELS);
    }

}