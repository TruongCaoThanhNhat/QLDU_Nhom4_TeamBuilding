package services;

import db.JDBIConnector;
import org.jdbi.v3.core.argument.Argument;

public class BoardGameService {
    private static BoardGameService instance;

    private BoardGameService() {

    }

    public static BoardGameService getInstance() {
        if (instance == null) {
            instance = new BoardGameService();
        }
        return instance;
    }

    public boolean createBoardGame(String key_room, String quantity_de, String quantity_tb, String quantity_kho) {
        int rs;
        String query = "INSERT INTO `board_game` (`key_room`,`id_team_win`,`quantity_de`, `quantity_tb`,`quantity_kho`) VALUES (?,?,?,?,?)";
        rs = JDBIConnector.get().withHandle(handle -> handle.createUpdate(query).bind(0, key_room)
                .bind(1, (Integer) null).bind(2, quantity_de).bind(3, quantity_tb).bind(4, quantity_kho).execute());
        return rs != 0;
    }

    public boolean setTeamWin(int id_board_game, int id_team) {
        String query = "update board_game set id_team_win = ? WHERE id = ?";
        int rs = JDBIConnector.get().withHandle(handle -> handle.createUpdate(query)
                .bind(0, id_team).bind(1, id_board_game).execute());
        return rs != 0;
    }

    public boolean updateBoardGame(String key_room, String id_team, String playing_time, int correct_answer) {
        int rs;
        String query = "UPDATE `room` SET playing_time = ? and correct_answer = ? WHERE key_room = ? and id_team = ?  ";
        rs = JDBIConnector.get().withHandle(handle -> handle.createUpdate(query).bind(0, playing_time)
                .bind(1, correct_answer).bind(2, key_room).bind(3, id_team).execute());
        return rs != 0;
    }

    public int getIdBoardGame(String key_room) {
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select ID from board_game where `key_room` = ? and id_team_win IS NULL").bind(0, key_room)
                        .mapTo(Integer.class)
                        .first());
    }

    public int getIdBoardGameScore(String key_room) {
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select ID from score where `id_board_game` = ?").bind(0, getIdBoardGame(key_room))
                        .mapTo(Integer.class)
                        .first());
    }
}
