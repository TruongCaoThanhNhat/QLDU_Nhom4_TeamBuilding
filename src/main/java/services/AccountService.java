package services;

import db.DBConnect;
import db.JDBIConnector;
import models.Room;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement st=null;
    public void addUser(String userName, String password,int role,String nameTeam,int status) throws SQLException {
        try {
            connection  =  DBConnect.getInstance().get().getConnection();
            String query = "INSERT INTO users (user_name, `password`,`role`,name_team,`status`) VALUES (?, ?, ?,?,?)";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setInt(3, role);
            preparedStatement.setString(4, nameTeam);
            preparedStatement.setInt(5, status);

            preparedStatement.executeUpdate();
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    public void updateUserNameTeam(int id, String nameTeam) throws SQLException {
        try {
            connection = DBConnect.getInstance().get().getConnection();
            String query = "UPDATE users SET  name_team = ? WHERE ID = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nameTeam);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } finally {
            // Đảm bảo đóng tài nguyên sau khi sử dụng
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public User checkLogin(String userName, String password) throws SQLException {
        Connection connection = DBConnect.getInstance().get().getConnection();

        String query = "SELECT * FROM users WHERE user_name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, userName);

        ResultSet rs = preparedStatement.executeQuery();

        User user = null;

        while (rs.next()) {
            String storedPassword = rs.getString("password");
            if (storedPassword.equalsIgnoreCase(password)) {
                user = new User();
                user.setUserName(rs.getString("user_name"));
                System.out.println(user.getPassword());
                user.setPassword(storedPassword); // Store hashed password

                // Break the loop after finding a matching user
                break;
            }
        }

        connection.close(); // Close the connection

        return user;
    }
    public User getUserByName(String username) {
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from `users` where user_name= ?").bind(0, username).mapToBean(User.class).list().get(0));
//        if (users.size() != 1) return null;
//        return users.get(0);
    }
    public User getUserById(int id) {
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from `users` where id= ?").bind(0, id).mapToBean(User.class).list().get(0));
//        if (users.size() != 1) return null;
//        return users.get(0);
    }
    public boolean checkUserExist(String userName) throws SQLException {
        connection  =  DBConnect.getInstance().get().getConnection();
         String query = "SELECT * FROM users WHERE user_name = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, userName);
        ResultSet rs = preparedStatement.executeQuery();
        if (!rs.next()) return false;
        return true;
    }

    public Room getRoomByKey(String key) throws SQLException {
        Room room = null;
        Connection connection = DBConnect.getInstance().get().getConnection();
        String selectQuery = "SELECT * FROM room WHERE `KEY` = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, key);

        ResultSet rs = preparedStatement.executeQuery();


        while (rs.next()) {
            String keyRoom= rs.getString("KEY");
            if (keyRoom.equalsIgnoreCase(key)) {
                room = new Room();
                room.setKey(rs.getString("KEY"));
                room.setId_host_room(rs.getInt("id_host_room"));
                // Break the loop after finding a matching user
                break;
            }
        }

        connection.close(); // Close the connection

        return room;
    }
    public boolean doesRoomExist(String key) throws SQLException {
        boolean roomExists = false;
        Connection connection = DBConnect.getInstance().get().getConnection();
        String selectQuery = "SELECT * FROM room WHERE `KEY` = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, key);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    // Nếu có bản ghi trong ResultSet, có nghĩa là phòng tồn tại
                    roomExists = true;
                }
            }
        } finally {
            connection.close(); // Đảm bảo đóng kết nối
        }

        return roomExists;
    }

    public List<User> getAllUserByKeyRoom(String keyRoom) throws SQLException {
        connection  =  DBConnect.getInstance().get().getConnection();
        List<User> userList = new ArrayList<>();
        String query = "SELECT * FROM room_user WHERE room_key = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, keyRoom);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User();
            int userID = rs.getInt("user_id");
            user = getUserById(userID);
            userList.add(user);
            System.out.println(user);
        }
        return userList;
    }

    public boolean addTeam(String id_team, String key_room) {
        int rs=0;
        String query = "INSERT INTO `score` (`id_board_game`,`id_team`,`playing_time`, `correct_answer`) VALUES (?,?,?,?)";

        if(BoardGameService.getInstance().getIdBoardGame(key_room)!=0){
            rs = JDBIConnector.get().withHandle(handle -> handle.createUpdate(query).bind(0, BoardGameService.getInstance().getIdBoardGame(key_room))
                    .bind(1, id_team).bind(2, (String) null).bind(3, (Integer) null).execute());
        }
        return rs != 0;
    }
    public List<User> getAllUserByRoom(String keyRoom) throws SQLException {
        connection  =  DBConnect.getInstance().get().getConnection();
        List<User> userList = new ArrayList<>();
        String query = "SELECT score.id_team FROM `score`\n" +
                "        JOIN board_game ON score.id_board_game = board_game.ID\n" +
                "        JOIN room ON room.`KEY` = board_game.key_room\n" +
                "        WHERE key_room = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, keyRoom);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User();
            int userID = rs.getInt("id_team");
            user = getUserById(userID);
            userList.add(user);
            System.out.println(user);
        }
        return userList;
    }
    public void addUserBoardScore(String keyRoom) throws SQLException {
        connection  =  DBConnect.getInstance().get().getConnection();
        List<User> userList = new ArrayList<>();
        String query = "SELECT score.id_team FROM `score`\n" +
                "        JOIN board_game ON score.id_board_game = board_game.ID\n" +
                "        JOIN room ON room.`KEY` = board_game.key_room\n" +
                "        WHERE key_room = ?";
        preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, keyRoom);
        ResultSet rs = preparedStatement.executeQuery();
        User user = null;
        while (rs.next()) {
            user = new User();
            int userID = rs.getInt("id_team");
            user = getUserById(userID);
            userList.add(user);
            System.out.println(user);
        }
    }
    public static void main(String[] args) throws SQLException {

//        Statement statement = DBConnect.getInstance().get();
//        if(statement==null) {
//            System.out.println("ko có ket noi");
//        } else {
//            System.out.println("thanh cong");
//        }
        AccountService acc= new AccountService();
//        System.out.println( acc.checkUserExist("thanhnhat12"));
//        System.out.println(acc.getUserByName("thanhnhat123"));
        System.out.println( acc.getAllUserByRoom("abc"));
//        System.out.println( acc.getRoomByKey("abc"));
//
//        try {
//            acc.addUser("nhat","1234",2,"teama",0);
////            acc.checkLogin("thanhnhat","12");
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//Room rom = acc.getRoomByKey("1");
//        boolean rom1 = acc.doesRoomExist("1");
//        System.out.println(rom1);
    }
}

//- vao phòn thì load len