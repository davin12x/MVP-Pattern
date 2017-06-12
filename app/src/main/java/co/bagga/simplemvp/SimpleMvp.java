package co.bagga.simplemvp;

import android.app.Application;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */

public class SimpleMvp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
