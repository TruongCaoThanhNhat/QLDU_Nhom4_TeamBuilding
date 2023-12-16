<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Unity</title>
    <link rel="stylesheet" href="/assets/css/home.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">

</head>
<% String mess = (String) request.getAttribute("mess") != null ? (String) request.getAttribute("mess") : "";
//    String messEmty = (String) request.getAttribute("messEmty") != null ? (String) request.getAttribute("messEmty") : "";
//    String checkUser = (String) request.getAttribute("checkUser") != null ? (String) request.getAttribute("checkUser") : "";
// giữ lại thông tin khi sai
//    String username = (String) request.getParameter("username") != null ? (String) request.getParameter("username") : "";
//    String email = (String) request.getParameter("email") != null ? (String) request.getParameter("email") : "";
%>

<body>
<main>
    <div class="register row" style="height: 650px;">
        <div class="icon-back">
            <i class="fa-regular fa-circle-left"></i>
            <a href="index.jsp">Quay lại</a>
        </div>
        <div><img src="/public/logo.png" alt=""></div>
        <form action="/register" class="form-register" method="post">
            <div class="field" >
                <input type="text" name="username" id="username" placeholder="Nhập username">
<%--                <input type="email" name="email" id="email" placeholder="Nhập email">--%>
                <input type="password" name="password" id="password" placeholder="Nhập mật khẩu">

                <input type="password" name="repassword" id="repassword" placeholder="Nhập lại mật khẩu">
                <p class="error"><%= mess%></p>
            </div>
            <button class="btn-register" type="submit">Đăng ký</button>
            <div class="form-text">
                <p class="text-content"> <span>Bạn đã có tài khoản, </span>
                    <a href="login.jsp">Đăng nhập</a></p>
                <!-- <a href="">Quên mật khẩu</a> -->
            </div>
        </form>
    </div>
</main>
</body>
</html>