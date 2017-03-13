package main.domain;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Kevin
 */
public class User {
    long id;
    String profilePicture;
    String name;
    String bio;
    String locations;
    String website;
    ArrayList<User> followers;
    ArrayList<User> follows;
    ArrayList<Kweet> kweets;

    public User(long id, String profilePicture, String name, String bio, String locations, String website) {
        this.id = id;
        this.profilePicture = profilePicture;
        this.name = name;
        this.bio = bio;
        this.locations = locations;
        this.website = website;

        followers = new ArrayList<User>();
        follows = new ArrayList<User>();
        kweets = new ArrayList<Kweet>();
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getWebsite() {
        return website;
    }

    public long getId(){return id;}

    public void setWebsite(String website) {
        this.website = website;
    }

    public void addFollower(User user){
        if(!followers.contains(user)){
            followers.add(user);
        }
    }

    public void removeFollower(User user){
        if(followers.contains(user)){
            followers.remove(user);
        }
    }

    public void addFollows(User user){
        if(!follows.contains(user)){
            follows.add(user);
        }
    }

    public void removeFollows(User user){
        if(follows.contains(user)){
            follows.remove(user);
        }
    }

    public void addKweet(Kweet kweet){
        if(!kweets.contains(kweet)){
            kweets.add(kweet);
        }
    }

    public void removeKweet(Kweet kweet){
        if(kweets.contains(kweet)){
            kweets.remove(kweet);
        }
    }

    public List<Kweet> getRecentKweets(int amountOfTweets){
        ArrayList<Kweet> sortedKweets = new ArrayList(kweets);
        Collections.sort(sortedKweets,new DateComparator());
        if(amountOfTweets > sortedKweets.size()){
            amountOfTweets = sortedKweets.size();
        }
        return sortedKweets.subList(0,amountOfTweets);
    }

    public List<Kweet> getTimeLine(int amountOfTweets){
        ArrayList<Kweet> allTweets = new ArrayList(kweets);
        for(User u : follows){
            allTweets.addAll(u.kweets);
        }
        Collections.sort(allTweets,new DateComparator());
        if(amountOfTweets > allTweets.size()){
            amountOfTweets = allTweets.size();
        }
        return allTweets.subList(0,amountOfTweets);
    }

    public ArrayList<User> getFollowers(){
        return followers;
    }
    public ArrayList<User> getFollows(){
        return follows;
    }
    public ArrayList<Kweet> getAllKweets(){
        return kweets;
    }
    static class DateComparator implements Comparator<Kweet>{
        public int compare(Kweet o1, Kweet o2)
        {
            if (o1.date == null || o2.date == null)
                return 0;

            if(o1.date.after(o2.date))
                return -1;
            else
                return 1;        }
    }
}
