package co.bagga.simplemvp;

import javax.inject.Singleton;

import co.bagga.simplemvp.Presentation.UserPresentationImpl;
import co.bagga.simplemvp.Presentation.UserPresenter;
import co.bagga.simplemvp.Repository.InMemoryUserRepository;
import co.bagga.simplemvp.Repository.UserRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Lalit Bagga on 2017-06-11.
 */

@Module
public class AppModule {

    @Provides @Singleton
    public UserRepository provideUserRepo() {
        return new InMemoryUserRepository();
    }

    @Provides
    public UserPresenter provideUserPresenter(UserRepository userRepository) {
        return new UserPresentationImpl(userRepository);
    }
}
