package main.java.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin.
 */
@Entity
public class UserGroup implements Serializable {

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @XmlTransient
    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user){
        if(users == null){
            users = new ArrayList<>();
        }
        users.add(user);
    }

    @XmlTransient
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Id
    private String groupName;

    @ManyToMany
    @JoinTable(name="USER_GROUP",
            joinColumns = @JoinColumn(name = "groupName",
                    referencedColumnName = "groupName"),
            inverseJoinColumns = @JoinColumn(name = "userName",
                    referencedColumnName = "userName"),
            uniqueConstraints = @UniqueConstraint(columnNames = {
                    "groupName",
                    "userName"
            }))
    @XmlTransient
    private List<User> users;

    public UserGroup() {

    }

}
