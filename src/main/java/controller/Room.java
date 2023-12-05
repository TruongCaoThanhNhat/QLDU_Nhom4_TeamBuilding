package controller;

import services.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/room")
public class Room extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id_host_room = "1";
        String quantity = "111";
        if (RoomService.getInstance().createGame(id_host_room, quantity)) {
            resp.sendRedirect("/waiting-screen.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        String id_host_room = req.getAttribute("id_user").toString();
//        String quantity = req.getAttribute("quantity").toString();
//        String id_host_room = "1";
////        String quantity = req.getAttribute("quantity").toString();
//        RoomService.getInstance().createGame(id_host_room, quantity);
//        resp.sendRedirect(req.getContextPath() + "/waiting-screen.jsp");
    }
}
