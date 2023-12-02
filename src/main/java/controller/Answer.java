package controller;

import models.User;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/answer")
public class Answer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        User host = UserService.get
//        List<User> userList = UserService.getInstance().getUsersInRoom("4ydh2T");
//        req.setAttribute("userList", userList);
//        req.getRequestDispatcher("answer.jsp").forward(req, resp);
    }
}