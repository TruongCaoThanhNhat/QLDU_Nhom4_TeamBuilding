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
        <div class="login row">
            <div class="icon-back">
                <i class="fa-regular fa-circle-left"></i>
                <a href="">Quay lại</a>
            </div>
            <div><img src="public/logo.png" alt=""></div>
            <form action="" class="form-login">
                <div class="field">
                    <input type="text" name="username" id="username" placeholder="Username">
                    <input type="password" name="username" id="username" placeholder="Password">
                </div>
                <button class="btn-login">Đăng nhập</button>
                <div class="form-text">
                   <p class="text-content"> <span>Bạn chưa có tài khoản, </span>
                    <a href="register.html">Đăng ký ngay</a></p>
                    <a href="forgot.html">Quên mật khẩu</a>
                </div>
            </form>
        </div>
    </main>
</body>
</html>