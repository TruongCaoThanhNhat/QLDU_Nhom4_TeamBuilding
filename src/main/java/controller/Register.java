package controller;

import org.mindrot.jbcrypt.BCrypt;
import services.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register", value = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String repass = request.getParameter("repassword");

        if (userName == "" && password == "" && repass == "") {
            request.setAttribute("mess", "Không được để trống");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        else if (password.length() < 8) {
                request.setAttribute("mess", "Mật khẩu phải có ít nhất 8 ký tự");
                request.getRequestDispatcher("register.jsp").forward(request, response);
            }


        if(userName != "" && password != "" && repass != "" && password.equals(repass)){
            try {
                AccountService acc = new AccountService();
                if(!acc.checkUserExist(userName)){
                    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                    acc.addUser(userName, hashedPassword, 0, "", 0);
                    response.sendRedirect("login.jsp");
                }
                else {
                    request.setAttribute("mess", "User đã tồn tại");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }



            } catch (SQLException e) {
                e.printStackTrace();  // Log the exception for debugging purposes
                request.setAttribute("mess", "Không thành công");
            }
        }
        else {
            request.setAttribute("mess", "Mật khẩu không khớp");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}