package services;

import db.JDBIConnector;
import models.Room;

public class RoomService {
    private static RoomService instance;

    private RoomService() {

    }

    public static RoomService getInstance() {
        if (instance == null) {
            instance = new RoomService();
        }
        return instance;
    }

    public Room getRoomByKey(String key) {
        Room result;
        result = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from room where `key` = ?").bind(0, key)
                        .mapToBean(Room.class)
                        .list().get(0));
//        result.setHostRoom();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getRoomByKey("4ydh2T"));
    }
}
