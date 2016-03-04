package me.chuvashev.carlauncher.data.launcher;

import me.chuvashev.carlauncher.domain.launcher.AppModel;
import me.chuvashev.carlauncher.domain.launcher.ApplicationsRepository;
import rx.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 14/02/16
 * Time: 00:22
 */
@Singleton
public class ApplicationsRepositoryImpl implements ApplicationsRepository {

    private ApplicationsExternalStorage mExternalStorage;
    private ApplicationsMemoryStorage mMemoryStorage;

    @Inject
    public ApplicationsRepositoryImpl(ApplicationsExternalStorage externalStorage, ApplicationsMemoryStorage memoryStorage) {
        mExternalStorage = externalStorage;
        mMemoryStorage = memoryStorage;
    }

    @Override
    public Observable<List<AppModel>> getApplications() {
        return Observable.concat(mMemoryStorage.get(),
                mExternalStorage.get().doOnNext(this::saveToMemoryCache)).first();
    }

    private void saveToMemoryCache(List<AppModel> appModels) {
        mMemoryStorage.put(appModels).subscribe();
    }

}
