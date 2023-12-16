package controller;

import models.Level;
import models.Question;
import models.Score;
import services.QuestionService;
import services.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/room")
public class Room extends HttpServlet {
    @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_host_room = "1";
        String key_room = "eAuBux0Q0x";
//      String key_room = req.getParameter("key_room").toString(); // session

        String quantity = req.getParameter("quantity");
//        String quantity_de = req.getParameter("quantity_de").toString();
//        String quantity_tb = req.getParameter("quantity_tb").toString();
//        String quantity_kho = req.getParameter("quantity_kho").toString();
        String quantity_de = "5";
        String quantity_tb = "5";
        String quantity_kho = "5";
        String action = req.getParameter("action");
        switch (action) {
            case "create_room":
                if (RoomService.getInstance().createGame(id_host_room, quantity, quantity_de, quantity_tb, quantity_kho)) {
                    resp.sendRedirect("/waiting-screen.jsp");
                }
                break;
            case "start_game":
                List<Question> list = new ArrayList<>();
                list.addAll(QuestionService.getInstance().randomQuestionLevel(key_room, Level.LEVEL_DE, quantity_de));
                list.addAll(QuestionService.getInstance().randomQuestionLevel(key_room, Level.LEVEL_TRUNG_BINH, quantity_tb));
                list.addAll(QuestionService.getInstance().randomQuestionLevel(key_room, Level.LEVEL_KHO, quantity_kho));
                Score.getInstance().setQuestionList(list);
                System.out.println(list.size());
                if (list.size() > 0)
                    resp.sendRedirect("/answer.jsp");
                break;
            case "bxh":
                List<Score> scoreList = ScoreService.getInstance().getBXH(key_room);
                req.setAttribute("scoreList", scoreList);
                req.getRequestDispatcher("/rank-table.jsp").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
