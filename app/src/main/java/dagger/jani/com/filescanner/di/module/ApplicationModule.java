package dagger.jani.com.filescanner.di.module;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import dagger.Module;
import dagger.Provides;
import dagger.jani.com.filescanner.di.ApplicationContext;


@Module
public class ApplicationModule {

    public static final String DEMO_PREFS = "demo-prefs";
    private final Application mApplication;

    public ApplicationModule(Application app) {
        mApplication = app;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }


    @Provides
    SharedPreferences provideSharedPrefs() {
        return mApplication.getSharedPreferences(DEMO_PREFS, Context.MODE_PRIVATE);
    }
}