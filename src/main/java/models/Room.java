package models;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    private int id;
    private User hostRoom;
    private String key;
    private String status;
    private List<BoardGame> boardGameList;
    private List<User> userList;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", hostRoom=" + hostRoom +
                ", key='" + key + '\'' +
                ", status='" + status + '\'' +
                ", boardGameList=" + boardGameList +
                ", userList=" + userList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getHostRoom() {
        return hostRoom;
    }

    public void setHostRoom(User hostRoom) {
        this.hostRoom = hostRoom;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BoardGame> getBoardGameList() {
        return boardGameList;
    }

    public void setBoardGameList(List<BoardGame> boardGameList) {
        this.boardGameList = boardGameList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Room(int id, User hostRoom, String key, String status, List<BoardGame> boardGameList, List<User> userList) {
        this.id = id;
        this.hostRoom = hostRoom;
        this.key = key;
        this.status = status;
        this.boardGameList = boardGameList;
        this.userList = userList;
    }

    public Room() {
    }
}
