package main.java.batch;

import main.java.domain.User;
import main.java.service.UserService;

import javax.batch.api.chunk.ItemWriter;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kevin.
 */
@Dependent
@Named("UserWriter")
public class UserWriter implements ItemWriter {
    @Inject
    private UserService userService;

    @Override
    public void open(Serializable serializable) throws Exception {

    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public void writeItems(List list) throws Exception {
        System.out.println("Writing items");

        for (Object item : list) {
            User user = (User) item;
            userService.addUser(user);
            /*
            InputUser user = (InputUser) item;
            userService.addUser(new User(user.username, user.bio, user.locations, user.website));*/
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
