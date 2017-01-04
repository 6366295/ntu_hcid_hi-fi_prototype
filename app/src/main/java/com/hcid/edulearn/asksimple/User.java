package com.hcid.edulearn.asksimple;

<<<<<<< HEAD
/**
 * User class
 *
 * Created by mike on 12/27/16.
 */

=======
>>>>>>> refs/remotes/origin/master
public class User {

    int id;
    String name;
    String user_id;
    String password;
    String type;

    public User() {

    }

    public User(int id, String name, String user_id, String password, String type) {
        this.id = id;
        this.name = name;
        this.user_id = user_id;
        this.password = password;
        this.type = type;
    }

    public User(String name, String user_id, String password, String type) {
        this.name = name;
        this.user_id = user_id;
        this.password = password;
        this.type = type;
    }

    public int getID() {
        return this.id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserID() {
        return this.user_id;
    }

    public void setUserID(String user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
