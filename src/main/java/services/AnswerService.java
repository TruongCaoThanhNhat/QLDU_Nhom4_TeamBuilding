package services;

import db.JDBIConnector;
import models.Answer;

import java.util.List;

public class AnswerService {
    private static AnswerService instance;

    private AnswerService() {

    }

    public static AnswerService getInstance() {
        if (instance == null) {
            instance = new AnswerService();
        }
        return instance;
    }
    public List<Answer> getAnswerListOfQuestion(int idQuestion){
        return JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from answer where id_question = ?").bind(0, idQuestion).mapToBean(Answer.class).list());
    }

    public static void main(String[] args) {
        System.out.println(getInstance().getAnswerListOfQuestion(2));
    }
}
