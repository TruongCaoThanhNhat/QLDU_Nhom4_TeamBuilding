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
        return JDBIConnector.get().withHandle(handle -> {
           return handle.createQuery("select * from `user` where id in (select id_team from score s join board_game b on s.id_board_game = b.id where key_room = ?) and `status` = 1")
                   .bind(0, roomKey).mapToBean(User.class).list();
        });
    }
    public User getHost(String roomKey){
        return JDBIConnector.get().withHandle(handle -> {
            return handle.createQuery("select * from `user` where id = (select id_host_room from room where `KEY`=?)").bind(0, roomKey).mapToBean(User.class).one();
        });
    }
    public static void main(String[] args) {
        System.out.println(getInstance().getHost("4h2DHT"));
    }
}
