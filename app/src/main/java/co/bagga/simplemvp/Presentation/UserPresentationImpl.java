package co.bagga.simplemvp.Presentation;

import android.text.TextUtils;

import co.bagga.simplemvp.Model.User;
import co.bagga.simplemvp.Repository.UserRepository;
import co.bagga.simplemvp.View.Activity.UserView;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */

public class UserPresentationImpl implements UserPresenter {
    private UserView view;
    private UserRepository userRepository;
    private User user;

    public UserPresentationImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void resume() {
        loadUserDetails();
    }

    @Override
    public void pause() {

    }

    @Override
    public void loadUserDetails() {
       int userId = view.getUserId();
       user = userRepository.getUser(userId);
       if (user == null) {
           view.showUserNotFoundMessage();
       } else {
           view.displayFirstName(user.getFirstName());
           view.displayLastName(user.getLastName());
       }
    }

    @Override
    public void setView(UserView userView) {
        this.view = userView;
    }

    @Override
    public void saveUser() {
        if (user != null) {
            if (TextUtils.isEmpty(view.getFirstName()) || TextUtils.isEmpty(view.getLastName())) {
                view.showUserNameIsRequired();
            } else {
                user.setFirstName(view.getFirstName());
                user.setLastName(view.getLastName());
                userRepository.saveUser(user);
                view.showUserSavedMessage();
            }
        }
    }
}
