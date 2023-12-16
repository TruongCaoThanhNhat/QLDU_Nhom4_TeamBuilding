package services;

import db.JDBIConnector;
import models.BoardGame;
import models.Room;

import java.util.Random;


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
                handle.createQuery("select * from room where `KEY` = ?").bind(0, key)
                        .mapToBean(Room.class)
                        .list().get(0));
        result.setHostRoom(UserService.getInstance().getUserById(JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select id_host_room from room where `KEY`=?").bind(0, key).mapTo(Integer.class).one())));
        return result;
    }

    /*
     * - Tạo phòng
     * (1) tạo key
     *
     * (2) tạo phòng
     */

    /*(1) tạo key*/
    public String createKeyRoom() {
        int length = 10;
        String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // Sinh ngẫu nhiên vị trí của ký tự trong characterSet
            int index = random.nextInt(characterSet.length());
            // Lấy ký tự tại vị trí ngẫu nhiên và thêm vào chuỗi
            randomString.append(characterSet.charAt(index));
        }
        return randomString.toString();
    }

    public boolean createGame(String id_host_room, String quantity, String quantity_de, String quantity_tb, String quantity_kho) {
        String keyRoom = createKeyRoom();
        if (createRoom(id_host_room, quantity, keyRoom))
            if (BoardGameService.getInstance().createBoardGame(keyRoom, quantity_de, quantity_tb, quantity_kho))
                if (addTeam(id_host_room, keyRoom))
                    return true;
        return false;
    }

    public boolean addTeam(String id_team, String key_room) {
        int rs;
        String query = "INSERT INTO `score` (`id_board_game`,`id_team`,`playing_time`, `correct_answer`) VALUES (?,?,?,?)";
        rs = JDBIConnector.get().withHandle(handle -> handle.createUpdate(query).bind(0, BoardGameService.getInstance().getIdBoardGame(key_room))
                .bind(1, id_team).bind(2, (String) null).bind(3, (Integer) null).execute());
        return rs != 0;
    }
    public boolean createRoom(String id_host_room, String quantity, String keyRoom) {
        int rs;
        String query = "INSERT INTO `room` (`KEY`,`id_host_room`,`quantity`, `status`) VALUES (?,?,?,?)";
        rs = JDBIConnector.get().withHandle(handle -> handle.createUpdate(query).bind(0, keyRoom)
                .bind(1, id_host_room).bind(2, quantity).bind(3, Room.ROOM_STATUS_UNLOCK).execute());
        return rs != 0;
    }

    public static void main(String[] args) {
        System.out.println(RoomService.getInstance().addTeam("1","PM5rhBhIcT"));
    }
}
