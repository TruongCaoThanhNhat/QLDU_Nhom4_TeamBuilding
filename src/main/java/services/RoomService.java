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
        result.setHostRoom(UserService.getInstance().getUserById(JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select id_host_room from room where `key`=?").bind(0, key).mapTo(Integer.class).one())));
        return result;
    }

    public static void main(String[] args) {
    }
}
