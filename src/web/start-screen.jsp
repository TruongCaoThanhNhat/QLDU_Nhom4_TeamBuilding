<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html lang="en">

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Màn hình bắt đầu chơi</title>
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
        <div class="pt-4" style="height: fit-content;"> <img class="w-75 h-75" src="/assets/img/waiting-screen/exit.png"
            alt=""></div>
      </div>
      <div class="d-flex justify-content-between w-100" style="height: 600px;">
        <div class="bg-concept col-3 p-0" style="border-radius: 20px;">
          <div class="user-item">
            <img class="img-user-item" src="/assets/img/waiting-screen/chiVy.jpg" alt="">
            <div>
              <div class="name-user-item">Bò sữa</div>

            </div>
          </div>
          <div class="user-item">
            <img class="img-user-item" src="/assets/img/waiting-screen/meoden.JPG" alt="">
            <div>
              <div class="name-user-item">Mèo đen</div>

            </div>
          </div>
          <div class="user-item">
            <img class="img-user-item" src="/assets/img/waiting-screen/cudem.JPG" alt="">
            <div>
              <div class="name-user-item">Cú đêm</div>

            </div>
          </div>
          <div class="user-item">
            <img class="img-user-item" src="/assets/img/waiting-screen/gacon.JPG" alt="">
            <div>
              <div class="name-user-item">Gà con</div>

            </div>
          </div>
          <div class="user-item">
            <img class="img-user-item" src="/assets/img/waiting-screen/daibang.JPG" alt="">
            <div>
              <div class="name-user-item">Đại bàng</div>

            </div>
          </div>
        </div>
        <div class="bg-concept col-8" style="border-radius: 20px;">
          <form method="post" action="<%=request.getContextPath()%>/room?action=start_game">
            <div class="d-flex justify-content-center align-items-center id-room pt-4">
            <span
                    style="color: white;font-size: 40px; font-weight: 700; font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;">Mã
              phòng:</span>
              <span style="color: #B1ADCF; font-size: 64px; font-weight: 400;" name="key_room" >H2oJ20</span>
              <i style="color: #B1ADCF; font-size: 64px;" class="fa-solid fa-copy"></i>
            </div>

          <div class="d-flex flex-column  justify-content-center align-items-center">
            <div><img src="/assets/img/waiting-screen/clock.png" alt=""></div>
            <button
              style="color: #4B4454; background-color: #FD9890; border-radius: 30px; padding: 8px 16px; gap: 12px; border: none; margin-bottom: 32px">
              <i class="fa-solid fa-gamepad" style="font-size: 45px;"></i>
              <span style="font-size: 40px; font-weight: 700;">START</span>
            </button>
          </div>
          </form>
        </div>
      </div>
    </div>
    </div>

  </body>

  </html>