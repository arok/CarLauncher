package me.chuvashev.carlauncher;

import android.app.Application;
import autodagger.AutoComponent;
import me.chuvashev.carlauncher.di.modules.AppModule;

import javax.inject.Singleton;

/**
 * Created with IntelliJ IDEA.
 * User: Sergey Chuvashev
 * Date: 13/02/16
 * Time: 23:39
 */
@Singleton
@AutoComponent(modules = {AppModule.class})
public class App extends Application {

    private static App sApp;

    public static App get() {
        return sApp;
    }

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sApp = this;

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

}
