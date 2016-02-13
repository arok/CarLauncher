package me.chuvashev.carlauncher.di.modules;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import me.chuvashev.carlauncher.di.qualifers.*;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:45
 */
@Module
public class DomainModule {

    @Provides
    @Worker
    public Scheduler provideWorkerScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Ui
    public Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }

}
