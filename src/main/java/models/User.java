package models;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String userName;
    private String password;
    private int role;
    private String nameTeam;
    private int status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", nameTeam='" + nameTeam + '\'' +
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

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(int id, String userName, String password, int role, String nameTeam, int status) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.nameTeam = nameTeam;
        this.status = status;
    }

    public User() {
    }
}
