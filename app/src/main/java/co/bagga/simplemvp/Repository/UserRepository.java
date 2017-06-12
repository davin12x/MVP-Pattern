package co.bagga.simplemvp.Repository;

import co.bagga.simplemvp.Model.User;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */

public interface UserRepository {
    User getUser(int id);
    void saveUser(User user);
}
