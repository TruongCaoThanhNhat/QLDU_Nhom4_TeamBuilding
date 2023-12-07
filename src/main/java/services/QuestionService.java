package services;

import db.JDBIConnector;
import models.Answer;
import models.Level;
import models.Question;
import org.jdbi.v3.core.argument.Argument;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jdbi.v3.core.internal.IterableLike.toList;

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

    public List<Question> randomQuestionLevel(String key_room, int level, String quantity) {
        List<Question> listQuestion = JDBIConnector.get()
                .withHandle(handle -> handle
                        .createQuery("SELECT * FROM question where id_level = ? ORDER BY RAND() LIMIT " + quantity + ";")
                        .bind(0, level)
                        .mapToBean(Question.class).list());
        String query = "INSERT INTO `team_answer` (`id_board_game_score`,`id_question`,`is_correct`) VALUES (?, ?, ?)";
//        String query = "INSERT INTO `team_answer` VALUES (:id_board_game_score,:id_question,:is_correct)";
//        Stream<Question> personStream = listQuestion.stream();
//        JDBIConnector.get().withHandle(handle -> handle.createUpdate(query).bind("id_board_game_score", BoardGameService.getInstance().getIdBoardGameScore(key_room))
//                .bindList("id_question",personStream.map(p -> p.getId()).collect(Collectors.toList())).bind("is_correct", (Integer) null).execute());
        int idBoardGameScore = BoardGameService.getInstance().getIdBoardGameScore(key_room);
        for (Question question : listQuestion) {
            JDBIConnector.get().withHandle(handle -> handle.createUpdate(query)
                    .bind(0, idBoardGameScore)
                    .bind(1, question.getId())
                    .bind(2, (Integer) null)
                    .execute());
        }
        return listQuestion;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().randomQuestionLevel("eAuBux0Q0x", 1, "5"));
    }
}
