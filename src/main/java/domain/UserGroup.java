package main.java.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Kevin.
 */
@Entity
public class UserGroup implements Serializable {

    @Id
    private String groupName;

    @ManyToMany
    @JoinTable(name="USER_GROUP",
            joinColumns = @JoinColumn(name = "groupName",
                    referencedColumnName = "groupName"),
            inverseJoinColumns = @JoinColumn(name = "userName",
                    referencedColumnName = "userName"))
    private List<User> users;

    public UserGroup() {
    }

    public UserGroup(String groupName) {
        this.groupName = groupName;
    }
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
