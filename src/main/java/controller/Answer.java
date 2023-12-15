package controller;

import models.Level;
import models.Question;
import models.Score;
import models.User;
import services.AnswerService;
import services.QuestionService;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/answer")
public class Answer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User host = UserService.get
        String key_room = "4h2DHT";
        User host = UserService.getInstance().getHost(key_room);
        req.setAttribute("host", host);
        List<User> userList = UserService.getInstance().getUsersInRoom(key_room);
        userList.removeIf(user -> user.getId() == (host.getId()));
        req.setAttribute("userList", userList);
        List<Question> questionList = new ArrayList<>();
        questionList.addAll(QuestionService.getInstance().randomQuestionLevel(key_room, Level.LEVEL_DE, "5"));
        questionList.addAll(QuestionService.getInstance().randomQuestionLevel(key_room, Level.LEVEL_TRUNG_BINH, "5"));
        questionList.addAll(QuestionService.getInstance().randomQuestionLevel(key_room, Level.LEVEL_KHO, "5"));
//        List<Question> questionList = Score.getInstance().getQuestionList();
        for (int i = 0; i < questionList.size(); i++) {
            questionList.get(i).setAnswerList(AnswerService.getInstance().getAnswerListOfQuestion(questionList.get(i).getId()));
        }
        System.out.println(questionList);
//        req.setAttribute("questionList", questionList);
        req.getSession().setAttribute("questionList", questionList);
        req.getRequestDispatcher("answer.jsp").forward(req, resp);
    }
}