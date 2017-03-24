package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import main.java.domain.Kweet;
import main.java.domain.User;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.List;

/**
 * Created by Kevin.
 */
public class KweetRestTest extends TestCase {
    ObjectMapper mapper;

    public void setUp() throws Exception {
        super.setUp();

        mapper = new ObjectMapper();

        HttpUriRequest request = new HttpPost("http://localhost:8080/Kwetter/api/user/post/createuser/PeterPan");
        HttpClientBuilder.create().build().execute(request);
        request = new HttpPost("http://localhost:8080/Kwetter/api/kweet/PeterPan/KweetForUnitTest");
        HttpClientBuilder.create().build().execute(request);
    }

    public void tearDown() throws Exception {

    }

    public void testGetAllKweets() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/Kwetter/api/kweet/");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        List<Kweet> kweets = mapper.readValue(response.getEntity().getContent(), mapper.getTypeFactory().constructCollectionType(List.class, Kweet.class));
        assertTrue(kweets.size()>0);
    }

    public void testGetAllKweetsByUser() throws Exception {

    }

    public void testGetKweet() throws Exception {

    }

    public void testGetUserTimeline() throws Exception {

    }

    public void testGetUserRecentKweets() throws Exception {

    }

    public void testAddKweet() throws Exception {

    }

    public void testDeleteKweet() throws Exception {

    }

}