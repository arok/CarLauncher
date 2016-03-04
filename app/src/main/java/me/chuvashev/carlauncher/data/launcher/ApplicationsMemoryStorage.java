package me.chuvashev.carlauncher.data.launcher;

import me.chuvashev.carlauncher.domain.launcher.AppModel;
import rx.Observable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 22:19
 */
public class ApplicationsMemoryStorage implements ApplicationsStorage {

    private List<AppModel> mAppModels;

    @Inject
    public ApplicationsMemoryStorage() {
    }

    @Override
    public Observable<List<AppModel>> get() {
        if (mAppModels != null) {
            return Observable.just(mAppModels);
        }
        return Observable.empty();
    }

    @Override
    public Observable<Void> put(List<AppModel> appModels) {
        mAppModels = appModels;
        return Observable.empty();
    }

}
