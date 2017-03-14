package rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import main.java.domain.Kweet;
import main.java.domain.Tag;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import java.util.List;

/**
 * Created by Kevin
 */
public class TagRestTest extends TestCase {
    ObjectMapper mapper;

    public void setUp() throws Exception {
        super.setUp();

        mapper = new ObjectMapper();

        HttpUriRequest request = new HttpPost("http://localhost:8080/Kwetter/api/tag/post/haye");
        HttpClientBuilder.create().build().execute(request);
    }

    public void tearDown() throws Exception {

    }

    public void testGetAllTags() throws Exception {
        HttpUriRequest request = new HttpGet("http://localhost:8080/Kwetter/api/tag/");

        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        List<Tag> tags = mapper.readValue(response.getEntity().getContent(), mapper.getTypeFactory().constructCollectionType(List.class, Tag.class));
        assertTrue(tags.size()>0);
    }

    public void testGetKweetsByTag() throws Exception {

    }

    public void testAddNewTag() throws Exception {

    }

    public void testDeleteTag() throws Exception {

    }

}