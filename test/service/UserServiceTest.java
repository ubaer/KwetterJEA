package service;

import junit.framework.TestCase;
import main.java.domain.User;
import main.java.service.UserService;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

import javax.validation.constraints.AssertTrue;
import java.util.ArrayList;

/**
 * Created by Kevin on 14-3-2017.
 */
public class UserServiceTest extends TestCase {
    UserService userService = Mockito.mock(UserService.class);

    public void setUp() throws Exception {
        super.setUp();

    }

    public void testChangeUsername() throws Exception {
        User testChangeUsername = new User("firstName");
        Mockito.when(userService.changeUsername(testChangeUsername,"firstName")).thenReturn(false);
        Mockito.when(userService.changeUsername(testChangeUsername,"secondName")).thenReturn(true);

        assertFalse(userService.changeUsername(testChangeUsername, "firstName"));
        assertTrue(userService.changeUsername(testChangeUsername, "secondName"));
    }

    public void testFindById() throws Exception {
        User testFindById = new User("testFindById");
        Mockito.when(userService.findByName("testFindById")).thenReturn(testFindById);

        User foundUser = userService.findByName("testFindById");
        assertEquals(testFindById, foundUser);
    }

    public void testFindByName() throws Exception {
        User testFindByName = new User("testFindByName");
        Mockito.when(userService.findByName("testFindByName")).thenReturn(testFindByName);

        User foundUser = userService.findByName("testFindByName");
        assertEquals(testFindByName, foundUser);
    }

    public void testGetAllUsers() throws Exception {

    }

}