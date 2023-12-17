package services;

import db.JDBIConnector;
import models.Score;

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

    public void insertScore(Score score) {
        JDBIConnector.get().withHandle(handle ->
                handle.createUpdate("insert into score(id_board_game, id_team, playing_time, correct_answer) values (?,?,?,?)")
                        .bind(0, score.getId_board_game())
                        .bind(1, score.getId_team())
                        .bind(2, score.getPlaying_time()).bind(3, score.getCorrect_answer()).execute());
    }

    public static void main(String[] args) {
        Score s  = new Score();
        s.setId_team(1);
        s.setId_board_game(1);
        s.setPlaying_time("60");
        s.setCorrect_answer(5);
        getInstance().insertScore(s);
    }
}
