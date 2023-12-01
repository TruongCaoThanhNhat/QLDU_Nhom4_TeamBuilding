package models;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private int id;
    private String question;
    private Level level;
    private List<Answer> answerList;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", level=" + level +
                ", answerList=" + answerList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }

    public Question(int id, String question, Level level, List<Answer> answerList) {
        this.id = id;
        this.question = question;
        this.level = level;
        this.answerList = answerList;
    }

    public Question() {
    }
}
