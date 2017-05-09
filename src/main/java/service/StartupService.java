package main.java.service;

import main.java.domain.User;
import main.java.domain.UserGroup;
import main.java.jms.JMSDispatcher;
import com.rabbitmq.client.*;

import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.message.GZipEncoder;
import org.glassfish.jersey.server.ResourceConfig;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobSecurityException;
import javax.batch.operations.JobStartException;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.crypto.Data;

/**
 * Created by Kevin on.
 */
@Singleton
@Startup
public class StartupService {

    @Inject
    private UserService userService;

    private long execID;
    private JobOperator jobOperator;

    public StartupService() {
    }

    @PostConstruct
    private void intData() {

        JMSDispatcher.getInstance();
        System.out.println("startup Initiated");
/*
        UserGroup regular = new UserGroup();
        regular.setGroupName("regulars");
        userService.createUserGroup(regular);
        userService.addUser(new User("Peter", "ea72c79594296e45b8c2a296644d988581f58cfac6601d122ed0a8bd7c02e8bf"));
        User peter = userService.findByName("Peter");
        userService.addUserToGroup(peter, regular);


        /*
        jobOperator = BatchRuntime.getJobOperator();
        try {
            execID = jobOperator.start("userimport", null);
            System.out.println("import done");
        } catch (JobStartException | JobSecurityException e) {
            e.printStackTrace();
        }
        */
    }
}
