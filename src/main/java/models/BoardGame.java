package models;

import java.io.Serializable;
import java.util.List;

public class BoardGame implements Serializable {
    private int id;
    private String key_room;
    private int id_team;
    private String playing_time;
    private int correct_answer;
    private List<Question> questionList;

    public BoardGame() {
    }

    public BoardGame(int id, String key_room, int id_team, String playing_time, int correct_answer) {
        this.id = id;
        this.key_room = key_room;
        this.id_team = id_team;
        this.playing_time = playing_time;
        this.correct_answer = correct_answer;
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", key_room='" + key_room + '\'' +
                ", id_team=" + id_team +
                ", playing_time='" + playing_time + '\'' +
                ", correct_answer=" + correct_answer +
                ", questionList=" + questionList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey_room() {
        return key_room;
    }

    public void setKey_room(String key_room) {
        this.key_room = key_room;
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
