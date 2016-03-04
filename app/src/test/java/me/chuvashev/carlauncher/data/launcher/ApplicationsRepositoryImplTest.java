package me.chuvashev.carlauncher.data.launcher;

import me.chuvashev.carlauncher.domain.launcher.AppModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rx.observers.TestSubscriber;

import java.util.List;

import static me.chuvashev.carlauncher.data.launcher.MockData.MODELS;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 22:04
 */
public class ApplicationsRepositoryImplTest {

    @Mock ApplicationsExternalStorage mExternalStorage;
    ApplicationsMemoryStorage mMemoryStorage;

    ApplicationsRepositoryImpl mRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        mMemoryStorage = new ApplicationsMemoryStorage();
        mRepository = new ApplicationsRepositoryImpl(mExternalStorage, mMemoryStorage);
    }

    @Test
    public void testGetApplicationsFromExternalStorage() throws Exception {
        Mockito.doReturn(rx.Observable.fromCallable(() -> MODELS)).when(mExternalStorage).get();

        final TestSubscriber<List<AppModel>> testSubscriber = new TestSubscriber<>();
        mRepository.getApplications().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(MODELS);
    }

    @Test
    public void testGetApplicationsFromMemoryStorage() throws Exception {
        Mockito.doReturn(rx.Observable.empty()).when(mExternalStorage).get();
        mMemoryStorage.put(MODELS).subscribe();

        final TestSubscriber<List<AppModel>> testSubscriber = new TestSubscriber<>();
        mRepository.getApplications().subscribe(testSubscriber);

        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(MODELS);
    }

    @Test
    public void testPutIntoMemoryStorage() {
        Mockito.doReturn(rx.Observable.fromCallable(() -> MODELS)).when(mExternalStorage).get();

        final TestSubscriber<List<AppModel>> testSubscriber = new TestSubscriber<>();
        mRepository.getApplications().subscribe();

        mMemoryStorage.get().subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertValueCount(1);
        testSubscriber.assertValue(MODELS);
    }

}