package me.chuvashev.carlauncher.data.launcher;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import me.chuvashev.carlauncher.domain.launcher.AppModel;
import rx.Observable;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 20:54
 */
@Singleton
public class ApplicationsExternalStorage implements ApplicationsStorage {

    private PackageManager mPackageManager;

    @Inject
    public ApplicationsExternalStorage(PackageManager packageManager) {
        mPackageManager = packageManager;
    }

    @Override
    public Observable<List<AppModel>> get() {
        return Observable.fromCallable(this::getAllApplications);
    }

    @Override
    public Observable<Void> put(List<AppModel> appModels) {
        return Observable.empty();
    }

    private List<AppModel> getAllApplications() {
        final ArrayList<AppModel> apps = new ArrayList<>();

        final List<ApplicationInfo> installedApplications = mPackageManager.getInstalledApplications(0);
        ApplicationInfo appInfo;
        Intent intent;
        for (int i = 0, size = installedApplications.size(); i < size; i++) {
            appInfo = installedApplications.get(i);
            intent = mPackageManager.getLaunchIntentForPackage(appInfo.packageName);

            if (intent != null) {
                apps.add(Mapper.map(appInfo, intent));
            }
        }

        return apps;
    }

}
