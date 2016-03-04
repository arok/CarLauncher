package me.chuvashev.carlauncher.domain.launcher;

import rx.Observable;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:32
 */
public interface ApplicationsRepository {

    Observable<List<AppModel>> getApplications();

}
