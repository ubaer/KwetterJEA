package main.rest;

/**
 * Created by Kevin.
 */

import main.domain.Kweet;
import main.domain.Tag;
import main.service.TagService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("tag")
@Produces(MediaType.APPLICATION_JSON)
public class TagRest {
    @Inject
    TagService tagService;

    @GET
    public ArrayList<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @GET
    @Path("{tagName}")
    public ArrayList<Kweet> getKweetsByTag(@PathParam("tagName")String tagName){
        Tag foundTag = tagService.getTagByName(tagName);
        if(foundTag != null){
            return tagService.getAllKweetsByTag(foundTag);
        }
         else {
            return new ArrayList<>();
        }
    }

    @POST
    @Path("post/{tagName}")
    public void addNewTag(@PathParam("tagName")String tagName){
        Tag tag = new Tag(tagName);
        tagService.addTag(tag);
    }

    @POST
    @Path("delete/{tagName}")
    public void deleteTag(@PathParam("tagName")String tagName){
        Tag tag = tagService.getTagByName(tagName);
        if(tag != null){
            tagService.removeTag(tag);
        }
    }
}
