package dagger.jani.com.filescanner;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import dagger.jani.com.filescanner.di.component.DaggerApplicationComponent;
import dagger.jani.com.filescanner.data.DataManager;
import dagger.jani.com.filescanner.di.component.ApplicationComponent;
import dagger.jani.com.filescanner.di.module.ApplicationModule;


public class FileApplication extends Application {


    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;


    public static FileApplication get(Context context) {
        return (FileApplication) context.getApplicationContext();
    }
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent(){
        return applicationComponent;
    }
}
