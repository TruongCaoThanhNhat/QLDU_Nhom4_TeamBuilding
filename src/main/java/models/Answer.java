package models;

import java.io.Serializable;

public class Answer implements Serializable {
    private int id;
    private String answer;
    private boolean correct;
    private int id_question;

    private Question question;

    public Answer() {
    }

    public Answer(int id, String answer, boolean correct, int id_question) {
        this.id = id;
        this.answer = answer;
        this.correct = correct;
        this.id_question = id_question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", answer='" + answer + '\'' +
                ", correct=" + correct +
                ", id_question=" + id_question +
                ", question=" + question +
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

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }
}
