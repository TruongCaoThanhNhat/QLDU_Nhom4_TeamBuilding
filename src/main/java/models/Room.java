package models;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable {
    private String key;
    private int id_host_room;
    private int quantity;
    private String status;
    private User hostRoom;
    private List<BoardGame> boardGameList;
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




}
