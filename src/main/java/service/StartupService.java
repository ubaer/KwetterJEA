package main.java.service;

import main.java.domain.User;
import main.java.domain.UserGroup;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.ArrayList;

/**
 * Created by Kevin on 28-3-2017.
 */
@Singleton
@Startup
public class StartupService {

    @Inject
    private UserService userService;

    public StartupService() {
    }

    @PostConstruct
    private void intData() {
        try {
            UserGroup regular = new UserGroup("regulars");
            userService.createUserGroup(regular);
            userService.addUser(new User("Peter", "ea72c79594296e45b8c2a296644d988581f58cfac6601d122ed0a8bd7c02e8bf"));
            User peter = userService.findByName("Peter");
            userService.addUserToGroup(peter, regular);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}