package models;

import java.io.Serializable;

public class TeamAnswer implements Serializable {
    private int id;
    private int id_board_game;
    private int id_question;
    private int id_team;
    private boolean is_correct;
    private Question question;
    private User user;
    private BoardGame boardGame;

    public TeamAnswer() {
    }

    public TeamAnswer(int id, int id_board_game, int id_question, int id_team, boolean is_correct) {
        this.id = id;
        this.id_board_game = id_board_game;
        this.id_question = id_question;
        this.id_team = id_team;
        this.is_correct = is_correct;
    }

    @Override
    public String toString() {
        return "TeamAnswer{" +
                "id=" + id +
                ", id_board_game=" + id_board_game +
                ", id_question=" + id_question +
                ", id_team=" + id_team +
                ", is_correct=" + is_correct +
                ", question=" + question +
                ", user=" + user +
                ", boardGame=" + boardGame +
                '}';
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

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getId_team() {
        return id_team;
    }

    public void setId_team(int id_team) {
        this.id_team = id_team;
    }

    public boolean isIs_correct() {
        return is_correct;
    }

    public void setIs_correct(boolean is_correct) {
        this.is_correct = is_correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BoardGame getBoardGame() {
        return boardGame;
    }

    public void setBoardGame(BoardGame boardGame) {
        this.boardGame = boardGame;
    }
}
