<%--
  Created by IntelliJ IDEA.
  User: phuon
  Date: 11/27/2023
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Màn hình chờ</title>
  <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
        integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="/assets/css/waiting-screen.css">
</head>

<body>
<div class="container pt-2 w-100">
  <div class="d-flex justify-content-between ">
    <div class="pl-5" style="height: fit-content;"><img class="w-75 h-75" src="/assets/img/logo.png" alt="">
    </div>
    <div class="pt-4" style="height: fit-content;"> <img class="w-75 h-75"
                                                         src="/assets/img/waiting-screen/exit.png" alt=""></div>
  </div>
  <div class="d-flex justify-content-between w-100" style="height: 650px;">
    <div class="bg-concept col-3 p-0" style="border-radius: 20px;">
      <div class="user-item">
        <img class="img-user-item" src="/assets/img/waiting-screen/chiVy.jpg" alt="">
        <div>
          <div class="name-user-item">Bò sữa</div>
          <div class="role-user-item" style="color: #4B4454;">
            <i class=" fa-solid fa-crown"></i>
            <span style="font-weight: 400;
                            ">Host</span>
          </div>
        </div>
      </div>
    </div>
    <div class="bg-concept col-8" style="border-radius: 20px;">
      <div class="d-flex justify-content-center align-items-center id-room pt-4">
                    <span
                            style="color: white;font-size: 40px; font-weight: 700; font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">Mã
                        phòng:</span>
        <span style="color: #B1ADCF; font-size: 64px; font-weight: 400;"> H2oJ20</span>
        <i style="color: #B1ADCF; font-size: 64px;" class="fa-solid fa-copy"></i>
      </div>
      <div class="d-flex flex-column pt-5 justify-content-center align-items-center">
        <div><img src="/assets/img/waiting-screen/clock.png" alt=""></div>
        <span class="text-uppercase"
              style="color:#B1ADCF ; font-size: 60px; font-weight: 700;">waiting...</span>
      </div>
    </div>
  </div>
</div>
</div>

</body>
</html>