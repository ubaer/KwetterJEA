package rest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import main.java.domain.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.List;

/**
 * Created by Kevin
 */
public class UserRestTest extends TestCase {
    ObjectMapper mapper;

    public void setUp() throws Exception {
        super.setUp();

        mapper = new ObjectMapper();

        HttpUriRequest request = new HttpPost("http://localhost:8080/Kwetter/api/user/PeterPan");
        HttpClientBuilder.create().build().execute(request);
    }

    public void tearDown() throws Exception {

    }
    public void testGetAllUsers() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/Kwetter/api/user/");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        List<User> users = mapper.readValue(response.getEntity().getContent(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        assertTrue(users.size()>0);
    }

    public void testGetUserById() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/Kwetter/api/user/id/1");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        User user = mapper.readValue(response.getEntity().getContent(),  User.class);
        assertNotNull(user);
    }

    public void testGetUserByName() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/Kwetter/api/user/PeterPan");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        User user = mapper.readValue(response.getEntity().getContent(),  User.class);
        assertEquals("PeterPan", user.getUserName());
    }

    public void testChangeUsername() throws Exception {

    }

    public void testDeleteUser()throws Exception{
        HttpUriRequest request = new HttpPost("http://localhost:8080/Kwetter/api/user/TestDeleteUser");
        HttpClientBuilder.create().build().execute(request);

        request = new HttpGet("http://localhost:8080/Kwetter/api/user/TestDeleteUser");
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        User user = mapper.readValue(response.getEntity().getContent(),  User.class);

        assertNotNull(user);

        request = new HttpDelete("http://localhost:8080/Kwetter/api/user/TestDeleteUser");
        HttpClientBuilder.create().build().execute(request);

        request = new HttpGet("http://localhost:8080/Kwetter/api/user/TestDeleteUser");
        response = HttpClientBuilder.create().build().execute(request);

        Throwable exception = null;
        try{
            mapper.readValue(response.getEntity().getContent(), User.class);
        }
        catch (JsonParseException e){
            exception = e;
        }

        assertTrue(exception instanceof JsonParseException);
    }
}