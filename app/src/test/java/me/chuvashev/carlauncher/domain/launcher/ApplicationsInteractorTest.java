package me.chuvashev.carlauncher.domain.launcher;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import rx.Scheduler;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 23:56
 */
public class ApplicationsInteractorTest {

    @Mock ApplicationsRepository mApplicationsRepository;
    @Mock Scheduler mWorkerScheduler;
    @Mock Scheduler mObserveScheduler;

    ApplicationsInteractor mApplicationsInteractor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mApplicationsInteractor = new ApplicationsInteractor(mWorkerScheduler, mObserveScheduler, mApplicationsRepository);
    }

    @Test
    public void testCreateObserver() throws Exception {
        mApplicationsInteractor.createObserver(null);

        Mockito.verify(mApplicationsRepository).getApplications();
        Mockito.verifyNoMoreInteractions(mApplicationsRepository);
        Mockito.verifyZeroInteractions(mWorkerScheduler);
        Mockito.verifyZeroInteractions(mObserveScheduler);
    }
}