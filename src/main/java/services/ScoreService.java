package services;

import db.JDBIConnector;
import models.Score;

import java.util.List;

public class ScoreService {
    private static ScoreService instance;

    private ScoreService() {

    }

    public static ScoreService getInstance() {
        if (instance == null) {
            instance = new ScoreService();
        }
        return instance;
    }

    public List<Score> getBXH(String key_room) {
        return JDBIConnector.get().withHandle(handle -> handle.createQuery("SELECT score.* from score join board_game on score.id_board_game = board_game.ID WHERE board_game.key_room = ? ORDER BY correct_answer DESC, playing_time").bind(0, key_room).mapToBean(Score.class).list());
    }

    public static void main(String[] args) {
        for (Score s : getInstance().getBXH("eAuBux0Q0x"))
            System.out.println(s.toString());
    }
}
