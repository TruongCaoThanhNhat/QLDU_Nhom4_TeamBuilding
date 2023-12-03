<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Unity</title>
    <link rel="stylesheet" href="assets/css/nhat.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
</head>
<body>
    <main>
        <div class="register row" style="height: 650px;">
            <div class="icon-back">
                <i class="fa-regular fa-circle-left"></i>
                <a href="login.html">Quay lại</a>
            </div>
            <div><img src="public/logo.png" alt=""></div>
            <form action="" class="form-register" >
                <div class="field" >
                    <input type="text" name="username" id="username" placeholder="Nhập username">
                    <input type="email" name="email" id="email" placeholder="Nhập email">
                    <input type="password" name="username" id="username" placeholder="Nhập mật khẩu">
                    <input type="password" name="username" id="username" placeholder="Nhập lại mật khẩu">
                </div>
                <button class="btn-register">Đăng ký</button>
                <div class="form-text">
                   <p class="text-content"> <span>Bạn đã có tài khoản, </span>
                    <a href="">Đăng nhập</a></p>
                    <!-- <a href="">Quên mật khẩu</a> -->
                </div>
            </form>
        </div>
    </main>
</body>
</html>