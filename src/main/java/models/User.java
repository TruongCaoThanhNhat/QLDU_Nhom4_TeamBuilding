package models;

import java.io.Serializable;

public class User implements Serializable {
    public static int ADMIN = 1;
    public static int USER = 0;
    private int id;
    private String userName;
    private String password;
    private int role;
    private String name_team;
    private int status;

    public User() {
    }

    public User(int id, String userName, String password, int role, String name_team, int status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.name_team = name_team;
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", name_team='" + name_team + '\'' +
                ", status=" + status +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName_team() {
        return name_team;
    }

    public void setName_team(String name_team) {
        this.name_team = name_team;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
