package main.java.rest;

/**
 * Created by Kevin.
 */
import main.java.domain.Kweet;
import main.java.domain.Tag;
import main.java.service.TagService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Path("tag")
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class TagRest {
    @Inject
    TagService tagService;

    @GET
    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @GET
    @Path("{tagName}")
    public Tag getTag(@PathParam("tagName")String tagName){
        Tag foundTag = tagService.getTagByName(tagName);
        return foundTag;
    }

    @GET
    @Path("{tagName}/kweets")
    public List<Kweet> getKweetsByTag(@PathParam("tagName")String tagName){
        Tag foundTag = tagService.getTagByName(tagName);
        if(foundTag != null){
            return foundTag.getKweets();
        }
        else {
            return new ArrayList<>();
        }
    }
    @POST
    @Path("{tagName}")
    public void addNewTag(@PathParam("tagName")String tagName){
        Tag tag = new Tag(tagName);
        tagService.addTag(tag);
    }

    @DELETE
    @Path("{tagName}")
    public void deleteTag(@PathParam("tagName")String tagName){
        Tag tag = tagService.getTagByName(tagName);
        if(tag != null){
            tagService.removeTag(tag);
        }
    }
}
