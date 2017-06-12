package co.bagga.simplemvp.Repository;

import co.bagga.simplemvp.Model.User;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */

public class InMemoryUserRepository implements UserRepository {

    private User user;

    @Override
    public User getUser(int id) {
        if (user == null) {
            user = new User();
            user.setId(id);
            user.setFirstName("Lalit");
            user.setLastName("Bagga");
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        if (this.user == null) {
            this.user = getUser(0);
            this.user.setId(user.getId());
            this.user.setFirstName(user.getFirstName());
            this.user.setLastName(user.getLastName());
        }
    }
}
