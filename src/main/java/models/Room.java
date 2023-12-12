package models;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    public static int ACTIVE = 1;       // Phòng chơi đang hoạt động
    public static int PLAYED = 2;       // Phòng chơi đã chơi
    public static int NOT_STARTED = 0;      // Phòng chơi chưa bắt đầu
    private String key;
    private int id_host_room;
    private int quantity;
    private String status;
    private User hostRoom;
    private List<BoardGame> boardGameList;
    private List<User> userList;
    public static final int ROOM_STATUS_UNLOCK = 1;
    public static final int ROOM_STATUS_LOCK = 2;
    public Room() {
    }

    public Room(String key, int id_host_room, int quantity, String status) {
        this.key = key;
        this.id_host_room = id_host_room;
        this.quantity = quantity;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getId_host_room() {
        return id_host_room;
    }

    public void setId_host_room(int id_host_room) {
        this.id_host_room = id_host_room;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getHostRoom() {
        return hostRoom;
    }

    public void setHostRoom(User hostRoom) {
        this.hostRoom = hostRoom;
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


}
