package co.bagga.simplemvp;

import javax.inject.Singleton;

import co.bagga.simplemvp.View.Activity.MainActivity;
import dagger.Component;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */
@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity target);
}
