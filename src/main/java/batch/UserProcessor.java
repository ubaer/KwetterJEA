package main.java.batch;

import main.java.domain.User;

import javax.batch.api.chunk.ItemProcessor;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

/**
 * Created by Kevin.
 */
@Dependent
@Named("UserProcessor")
public class UserProcessor implements ItemProcessor{
    @Override
    public Object processItem(Object o) throws Exception {
        InputUser processedUser = (InputUser) o;

        User user = new User();
        user.setUserName(processedUser.username);
        user.setBio(processedUser.bio);
        user.setLocations(processedUser.locations);
        user.setWebsite(processedUser.website);

        return user;
    }
}
