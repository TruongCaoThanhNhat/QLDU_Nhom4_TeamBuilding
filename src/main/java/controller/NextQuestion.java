package controller;

import com.mysql.cj.xdevapi.JsonString;
import models.BoardGame;
import models.Question;
import models.Room;
import models.Score;
import services.RoomService;
import services.ScoreService;
import services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NextQuestion", value = "/NextQuestion")
public class NextQuestion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int indexQuestion = Integer.parseInt(request.getParameter("indexQuestion"));
        int countCorrect = Integer.parseInt(request.getParameter("countCorrect"));
        List<Question> questionList = (List<Question>) request.getSession().getAttribute("questionList");
//        System.out.println(questionList.get(indexQuestion));
        String totalTime = request.getParameter("totalTime");
        if (indexQuestion <= questionList.size() -1) {
            String question = questionList.get(indexQuestion).getQuestion();
            String answer1 = questionList.get(indexQuestion).getAnswerList().get(0).getAnswer();
            String answer2 = questionList.get(indexQuestion).getAnswerList().get(1).getAnswer();
            String answer3 = questionList.get(indexQuestion).getAnswerList().get(2).getAnswer();
            String answer4 = questionList.get(indexQuestion).getAnswerList().get(3).getAnswer();
            int correctAnswer = 0;
            for (int i = 0; i < 4; i++) {
                if (questionList.get(indexQuestion).getAnswerList().get(i).isCorrect()) {
                    correctAnswer = i + 1;
                }
            }
            String jsonResponse = "{"
                    + "\"question\":\"" + question + "\","
                    + "\"answer1\":\"" + answer1 + "\","
                    + "\"answer2\":\"" + answer2 + "\","
                    + "\"answer3\":\"" + answer3 + "\","
                    + "\"answer4\":\"" + answer4 + "\","
                    + "\"correctAnswer\":\"" + correctAnswer + "\""
                    + "}";
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(jsonResponse);
        } else {
            Room room = RoomService.getInstance().getRoomByKey(request.getParameter("key"));
//            BoardGame bg = room.getBoardGameList().get(0);
            Score score = new Score();
            score.setId_board_game(1);
//            score.setId_board_game(bg.getId());
            score.setId_team(UserService.getInstance().getUsersInRoom(room.getKey()).get(0).getId());
            score.setPlaying_time(totalTime);
            score.setCorrect_answer(countCorrect);
            ScoreService.getInstance().insertScore(score);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
