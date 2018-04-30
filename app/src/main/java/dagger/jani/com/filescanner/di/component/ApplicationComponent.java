package dagger.jani.com.filescanner.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import dagger.jani.com.filescanner.FileApplication;
import dagger.jani.com.filescanner.data.DataManager;
import dagger.jani.com.filescanner.data.SharedPrefsHelper;
import dagger.jani.com.filescanner.di.ApplicationContext;
import dagger.jani.com.filescanner.di.module.ApplicationModule;


@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(FileApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

}