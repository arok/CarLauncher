package me.chuvashev.carlauncher.di.modules;

import autodagger.AutoExpose;
import dagger.Module;
import dagger.Provides;
import me.chuvashev.carlauncher.App;
import me.chuvashev.carlauncher.data.launcher.ApplicationsRepositoryImpl;
import me.chuvashev.carlauncher.domain.launcher.ApplicationsRepository;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 01/03/16
 * Time: 20:52
 */
@Module
@Singleton
public class DataModule {

    @Provides
    @Singleton
    @AutoExpose(App.class)
    public ApplicationsRepository provideApplicationsRepository(ApplicationsRepositoryImpl repository) {
        return repository;
    }

}
