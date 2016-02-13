package me.chuvashev.carlauncher.domain.common;

import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscription;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:06
 */
public abstract class Interactor<ParameterType, ResultType> {

    private Scheduler mWorkerScheduler;
    private Scheduler mObserveScheduler;
    private Subscription mSubscription;

    protected Interactor(Scheduler workerScheduler, Scheduler observeScheduler) {
        mWorkerScheduler = workerScheduler;
        mObserveScheduler = observeScheduler;
    }

    protected abstract Observable<ResultType> createObserver(ParameterType parameter);

    public void subscribe(ParameterType parameter, Observer<ResultType> observer) {
        mSubscription = createObserver(parameter)
                .subscribeOn(mWorkerScheduler)
                .observeOn(mObserveScheduler)
                .subscribe(observer);
    }

    public void unsubscribe() {
        if (mSubscription != null) {
            mSubscription.unsubscribe();
        }
    }

}
