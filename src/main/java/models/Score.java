package models;

import services.QuestionService;

import java.io.Serializable;
import java.util.List;

public class Score implements Serializable {
    private int id;
    private int id_board_game;
    private int id_team;
    private String playing_time;
    private int correct_answer;
    public static List<Question> questionList = null;
    private static Score instance;
    User team;
    public Score() {
    }

    public static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    public Score(int id, int id_board_game, int id_team, String playing_time, int correct_answer) {
        this.id = id;
        this.id_board_game = id_board_game;
        this.id_team = id_team;
        this.playing_time = playing_time;
        this.correct_answer = correct_answer;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", key_room='" + id_board_game + '\'' +
                ", id_team=" + id_team +
                ", playing_time='" + playing_time + '\'' +
                ", correct_answer=" + correct_answer +
                ", questionList=" + questionList +
                '}';
    }
public User getTeam() {
        return team;
    }

    public void setTeam(User team) {
        this.team = team;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_board_game() {
        return id_board_game;
    }

    public void setId_board_game(int id_board_game) {
        this.id_board_game = id_board_game;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public String getPlaying_time() {
        return playing_time;
    }

    public void setPlaying_time(String playing_time) {
        this.playing_time = playing_time;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }
}
