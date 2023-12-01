package models;

import java.io.Serializable;
import java.util.List;

public class BoardGame implements Serializable {
    private int id;
    private List<Question> questionList;

    @Override
    public String toString() {
        return "BoardGame{" +
                "id=" + id +
                ", questionList=" + questionList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public BoardGame() {
    }

    public BoardGame(int id, List<Question> questionList) {
        this.id = id;
        this.questionList = questionList;
    }
}
