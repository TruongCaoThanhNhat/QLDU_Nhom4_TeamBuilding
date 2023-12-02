<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>

  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Màn hình trả lời câu hỏi</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/assets/css/waiting-screen.css">
    <link rel="stylesheet" href="/assets/css/answer.css">
  </head>

  <body>
    <div class="container pt-2 w-100">
      <div class="d-flex justify-content-between ">
        <div class="pl-5" style="height: fit-content;"><img class="w-75 h-75" src="/assets/img/logo.png" alt="">
        </div>
        <div class="d-flex id-room ">
          <span style="color: #B1ADCF; font-size: 64px; font-weight: 400; line-height: normal;"> H2oJ20</span>
          <i style="color: #B1ADCF; font-size: 64px;" class="fa-solid fa-copy"></i>
        </div>
        <div class="pt-4" style="height: fit-content;"> <img class="w-75 h-75" src="/assets/img/waiting-screen/exit.png"
            alt=""></div>
      </div>
      <div class="d-flex justify-content-between w-100" style="height:600px;">
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
        <div class="bg-concept col-8 " style="border-radius: 20px; padding: 0 44px; font-family: 'Jost*', sans-serif;">
          <div class="d-flex flex-column">
            <div class="d-flex justify-content-between align-items-center text-white">
              <div style="font-size: 25px;">Question 1/25</div>
              <div style="font-size: 30px;">58s</div>
            </div>
            <div class="bg-white" style="border-radius: 20px; height: 165px;">
              <p style="font-size: 25px;" class="pt-2 pl-4">Lịch nào dài nhất?</p>
            </div>
            <span style="font-size: 20px;" class="d-flex align-self-end text-white">Dễ</span>
          </div>
          <!-- tra loi -->
          <div class="d-flex flex-column pt-2" style="display: none !important;">
            <div class="row m-0" style=" gap:  12px 44px;font-size: 25px;">
              <button class="answer-item">
                Lịch nghỉ lễ
              </button>
              <button class="answer-item">
                Lịch sử
              </button>
              <button class="answer-item">
                Lịch âm
              </button>
              <button class="answer-item">
                Lịch làm việc
              </button>
            </div>
            <div class="bg-white w-100 mt-4" style="height: 12px; border-radius: 20px;">
              <div class=" w-75 h-100" style="background-color: #8854C0; border-radius: 10px;"></div>
            </div>
          </div>
          <!-- tra loi dung -->
          <div class="d-flex flex-column pt-2" style="display: none !important;">
            <div class="row m-0" style=" gap:  12px 44px;font-size: 25px;">
              <button class="answer-item">
                Lịch nghỉ lễ
              </button>
              <button class="answer-item" style="background-color: #4AE45A;">
                Lịch sử
              </button>
              <button class="answer-item">
                Lịch âm
              </button>
              <button class="answer-item">
                Lịch làm việc
              </button>
            </div>

            <div class="d-flex flex-column justify-content-between align-items-center" style="margin-top: 32px; gap:32px; padding-bottom: 32px">
              <button
                      style="background-color: #F5F061; padding: 8px 16px; border-radius: 10px; font-size: 25px; height: fit-content; border: none;">Tiếp
                tục</button>
              <img style="height: 80px;" class="mt-2" src="/assets/img/waiting-screen/congratulate.png" alt="">
            </div>
          </div>
          <!-- tra loi sai -->
          <div class="d-flex flex-column pt-2">
            <div class="row m-0" style=" gap:  12px 44px;font-size: 25px;">
              <button class="answer-item" style="background-color: #E82424;">
                Lịch nghỉ lễ
              </button>
              <button class="answer-item" style="background-color: #4AE45A;">
                Lịch sử
              </button>
              <button class="answer-item">
                Lịch âm
              </button>
              <button class="answer-item">
                Lịch làm việc
              </button>
            </div>
            <div class="d-flex flex-column justify-content-between align-items-center"  style="margin-top: 32px; gap:32px; padding-bottom: 32px">
              <button
                      style="background-color: #F5F061; padding: 8px 16px; border-radius: 10px; font-size: 25px; height: fit-content; border: none;">Tiếp
                tục</button>
              <img style="height: 80px;" class="mt-2" src="/assets/img/waiting-screen/regret.png" alt="">
            </div>
          </div>
          <!-- khong tra loi  -->
          <div class="d-flex flex-column pt-2" style="display: none !important;">
            <div class="row m-0" style=" gap:  12px 44px;font-size: 25px;">
              <button class="answer-item" style="background-color: #E82424;">
                Lịch nghỉ lễ
              </button>
              <button class="answer-item" style="background-color: #4AE45A;">
                Lịch sử
              </button>
              <button class="answer-item">
                Lịch âm
              </button>
              <button class="answer-item">
                Lịch làm việc
              </button>
            </div>
            <div class="d-flex flex-column justify-content-between align-items-center" style="margin-top: 32px; gap:32px; padding-bottom: 32px">
              <button
                      style="background-color: #F5F061; padding: 8px 16px; border-radius: 10px; font-size: 25px; height: fit-content; border: none;">Tiếp
                tục</button>
              <img style="height: 80px;" class="mt-2" src="/assets/img/waiting-screen/out-of-time.png.png" alt="">
            </div>
          </div>
        </div>
      </div>
    </div>

  </body>

  </html>