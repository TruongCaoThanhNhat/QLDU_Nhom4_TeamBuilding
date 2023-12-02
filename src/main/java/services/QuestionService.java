package services;

import db.JDBIConnector;
import models.Answer;
import models.Level;
import models.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuestionService {
    private static QuestionService instance;

    private QuestionService() {

    }

    public static QuestionService getInstance() {
        if (instance == null) {
            instance = new QuestionService();
        }
        return instance;
    }

    public List<Question> getQuestionsByLevel(int idLevel) {
        List<Question> questions = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from question where id_level=?").bind(0, idLevel).mapToBean(Question.class).list());
        Level level = LevelService.getInstance().getLevel(idLevel);
        for (Question q : questions) {
            q.setLevel(level);
            q.setAnswerList(AnswerService.getInstance().getAnswerListOfQuestion(q.getId()));
        }
        return questions;
    }

    public Question getQuestion(int id) {
        Question result = JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select * from question where id=?").bind(0, id).mapToBean(Question.class).one());
        result.setLevel(LevelService.getInstance().getLevel(JDBIConnector.get().withHandle(handle ->
                handle.createQuery("select id_level from question where id=?").bind(0, id).mapTo(Integer.class).one())));
        result.setAnswerList(AnswerService.getInstance().getAnswerListOfQuestion(id));
        return result;
    }

    public List<Question> randomQuestionsByLevel(int quantity, int level) {
        List<Question> questions = getQuestionsByLevel(level);
        List<Question> result = new ArrayList<>();
        Random random = new Random();
        int value = 0;
        for (int i = 0; i < quantity; i++) {
            value = random.nextInt(questions.size()) + 1;
            result.add(questions.get(value));
            System.out.println(questions.get(value));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().randomQuestionsByLevel(5, 1));
    }
}
