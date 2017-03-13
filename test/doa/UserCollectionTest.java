package doa;

import junit.framework.TestCase;
import main.dao.UserCollection;
import main.dao.UserDao;
import main.domain.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kevin.
 */
public class UserCollectionTest extends TestCase {
    UserDao userDao = new UserCollection();

    //Users
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;

    public void setUp() throws Exception {
        super.setUp();
        user1 = new User(0, "profilePic.png","Peter Appel","biografie van deze persoon","Wereldstad","www.tvj.com");
        user2 = new User(1, "profilePic.jpg", "Pusedo meno", "Bio boyz", "Groningen", "website.com");
        user3 = new User(2, "profilePic.gif", "Anna Frenk", "Bio boyz", "Limburg", "meh.com");
        user4 = new User(3, "profilePic.pdf", "Boer Brugmans", "Bio boyz", "Utrecht", "poewpow.com");
        user5 = new User(4, "profilePic.heh", "Lolleke Kekkers", "Bio boyz", "Zeeland", "Wellzijn.com");
    }

    public void tearDown() throws Exception {

    }

    public void testAddUser() throws Exception {
        assertEquals(0, userDao.getAllUsers().size());

        userDao.addUser(user1);

        assertEquals(1, userDao.getAllUsers().size());
    }

    public void testRemoveUser() throws Exception {
        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);
        assertEquals(3, userDao.getAllUsers().size());
        assertTrue(userDao.getAllUsers().contains(user1));

        userDao.removeUser(user1);
        assertEquals(2, userDao.getAllUsers().size());
        assertFalse(userDao.getAllUsers().contains(user1));
    }

    public void testChangeUsername() throws Exception {
        userDao.addUser(user1);
        userDao.changeUsername(user1, "Peter R de vries");

        assertEquals("Peter R de vries", user1.getName());
    }

    public void testChangeTakenUsername() throws Exception{
        userDao.addUser(user1);
        userDao.addUser(user2);

        boolean namechangeSuccesfull = userDao.changeUsername(user1, "Pusedo meno");

        assertFalse(namechangeSuccesfull);
        assertNotSame("Pusedo meno", user1.getName());
    }

    public void testFindById() throws Exception {
        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);

        User foundUser = userDao.findById(user1.getId());

        assertEquals(foundUser, user1);
    }

    public void testFindByName() throws Exception {
        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);

        User foundUser = userDao.findByName(user1.getName());

        assertEquals(foundUser, user1);
    }

    public void testGetAllUsers() throws Exception {
        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);
        userDao.addUser(user4);
        userDao.addUser(user5);
        ArrayList<User> allUsers = new ArrayList<>();
        allUsers.addAll(Arrays.asList(user1, user2, user3, user4, user5));

        ArrayList<User> foundUser = userDao.getAllUsers();

        assertEquals(allUsers, foundUser);
    }

}