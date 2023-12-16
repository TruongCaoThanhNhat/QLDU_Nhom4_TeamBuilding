package controller;

import models.User;
import org.mindrot.jbcrypt.BCrypt;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        AccountService acc = new AccountService();
        User auth = null;
        User user = acc.getUserByName(userName);
        if (userName =="" && password==""){
            request.setAttribute("mess", "Không được để trống");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else if(userName!="" && BCrypt.checkpw(password, user.getPassword())) {
//                auth = acc.checkLogin(userName, password);
                auth = user;

                if (auth != null) {
                    // Đăng nhập thành công, lưu thông tin người dùng vào session
                    HttpSession session = request.getSession(true);
                    session.setAttribute("auth", auth);

                    // Chuyển hướng đến trang index.jsp
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    System.out.println(session.getAttribute("auth"));
                } else {
                    // Đăng nhập không thành công, hiển thị thông báo và chuyển hướng lại trang đăng nhập
                    request.setAttribute("mess", "Đăng nhập không thành công");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}