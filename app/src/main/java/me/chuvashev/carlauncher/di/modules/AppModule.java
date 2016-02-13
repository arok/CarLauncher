package me.chuvashev.carlauncher.di.modules;

import android.app.Application;
import android.content.Context;
import autodagger.AutoExpose;
import dagger.Module;
import dagger.Provides;
import me.chuvashev.carlauncher.App;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:42
 */
@Module
@Singleton
public class AppModule {

    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    @AutoExpose(App.class)
    public Context provideContext() {
        return mApplication;
    }

}
