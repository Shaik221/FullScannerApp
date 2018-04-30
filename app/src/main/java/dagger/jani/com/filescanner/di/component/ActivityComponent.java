package dagger.jani.com.filescanner.di.component;

import dagger.Component;
import dagger.jani.com.filescanner.ui.main.MainActivity;
import dagger.jani.com.filescanner.di.PerActivity;
import dagger.jani.com.filescanner.di.module.ActivityModule;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}