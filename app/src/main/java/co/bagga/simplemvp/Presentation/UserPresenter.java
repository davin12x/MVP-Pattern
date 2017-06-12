package co.bagga.simplemvp.Presentation;

import co.bagga.simplemvp.View.Activity.UserView;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */

public interface UserPresenter extends LifecyclePresenter {
    void loadUserDetails();
    void setView(UserView userView);
    void saveUser();
}
