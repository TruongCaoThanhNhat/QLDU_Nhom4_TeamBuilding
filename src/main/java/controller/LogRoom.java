package controller;

import models.Room;
import models.User;
import services.AccountService;
import services.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LogRoom", value = "/log-room")
public class LogRoom extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        - addteam của nguyên,
        - add vô bảng score
         */
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomCode = request.getParameter("roomCode");
        String nameTeam = request.getParameter("nameteam");

        // Sử dụng JDBC để lấy thông tin phòng từ cơ sở dữ liệu
       AccountService acc = new AccountService();
       Room room = null;
        boolean roomCheck = false;
        try {
            roomCheck = acc.doesRoomExist(roomCode);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (nameTeam==""){
            request.setAttribute("mess", "Nhập tên team");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (roomCode != null && roomCheck && nameTeam!="") {
            // Nếu phòng tồn tại, lưu thông tin phòng vào session và chuyển hướng người dùng đến trang chờ
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("auth");
            try {
                acc.updateUserNameTeam(user.getId(),nameTeam);
                room = acc.getRoomByKey(roomCode);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            if(!acc.addTeam(String.valueOf(user.getId()),roomCode)){
                request.setAttribute("mess", "Phòng không tồn tại");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            session.setAttribute("room", room);
            session.setAttribute("auth",user);


            System.out.println(room);

            // Chuyển hướng đến trang chờ hoặc trang khác
            response.sendRedirect(request.getContextPath() + "/waiting-screen.jsp");
        } else {
            // Nếu mã phòng không đúng, bạn có thể hiển thị thông báo hoặc thực hiện xử lý khác
            request.setAttribute("mess", "Mã phòng không đúng");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}