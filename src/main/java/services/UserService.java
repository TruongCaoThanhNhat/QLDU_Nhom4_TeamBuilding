package services;

import db.JDBIConnector;
import models.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static UserService instance;

    private UserService() {

    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User getUserById(int id) {
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from `user` where id= ?").bind(0, id).mapToBean(User.class).list().get(0));
//        if (users.size() != 1) return null;
//        return users.get(0);
    }
    public List<User> getUsersInRoom(String roomKey){
        return RoomService.getInstance().getRoomByKey(roomKey).getUserList();
    }
    public User getHost(String roomKey){
        return RoomService.getInstance().getRoomByKey(roomKey).getHostRoom();
    }
    public static void main(String[] args) {
        System.out.println(getInstance().getUsersInRoom("4ydh2T"));
    }
}
