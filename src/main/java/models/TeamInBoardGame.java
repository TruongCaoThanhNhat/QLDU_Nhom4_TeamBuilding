package models;

import java.io.Serializable;

public class TeamInBoardGame implements Serializable {
    private int id;
    private User user;
    private BoardGame boardGame;
    private int playingTime;
    private int correctAnswer;
    private int rank;

    @Override
    public String toString() {
        return "TeamInBoardGame{" +
                "id=" + id +
                ", user=" + user +
                ", boardGame=" + boardGame +
                ", playingTime=" + playingTime +
                ", correctAnswer=" + correctAnswer +
                ", rank=" + rank +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public TeamInBoardGame(int id, User user, BoardGame boardGame, int playingTime, int correctAnswer, int rank) {
        this.id = id;
        this.user = user;
        this.boardGame = boardGame;
        this.playingTime = playingTime;
        this.correctAnswer = correctAnswer;
        this.rank = rank;
    }

    public TeamInBoardGame() {
    }
}
