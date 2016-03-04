package me.chuvashev.carlauncher.domain.launcher;

import me.chuvashev.carlauncher.domain.common.Interactor;
import me.chuvashev.carlauncher.di.qualifers.*;
import rx.Observable;
import rx.Scheduler;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:31
 */
public class ApplicationsInteractor extends Interactor<Void, List<AppModel>> {

    private ApplicationsRepository mApplicationsRepository;

    @Inject
    public ApplicationsInteractor(@Worker Scheduler workerScheduler, @Ui Scheduler observeScheduler, ApplicationsRepository applicationsRepository) {
        super(workerScheduler, observeScheduler);
        mApplicationsRepository = applicationsRepository;
    }

    @Override
    protected Observable<List<AppModel>> createObserver(Void parameter) {
        return mApplicationsRepository.getApplications();
    }

}
