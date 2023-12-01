package models;

import java.io.Serializable;

public class Answer implements Serializable {
    private int id;
    private String answer;
    private boolean correct;

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Answer(int id, String answer, boolean correct) {
        this.id = id;
        this.answer = answer;
        this.correct = correct;
    }

    public Answer() {
    }
}
