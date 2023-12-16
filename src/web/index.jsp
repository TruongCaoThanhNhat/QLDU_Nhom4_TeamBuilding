<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Unity</title>
    <link rel="stylesheet" href="/assets/css/home.css" />
    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
    />
    <!--  -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<% String mess = (String) request.getAttribute("mess") != null ? (String) request.getAttribute("mess") : "";
%>
<main>
    <div class="main-warpper">
        <div class="main-content">
            <div class="logo">
                <img src="/assets/logo.png" alt="" />
            </div>
            <div class="avatar">
                <div class="avatar__img"></div>
                <span class="avatar__edit">
              <i class="fa-solid fa-pencil"></i>
            </span>
            </div>

            <div class="form-name">
                <form action="/log-room" class="mx-auto" method="post">
                    <div class="mx-auto">
                        <!-- <label for="" class="d-inline-block">Biệt danh</label> -->

                        <div class="form-name__input">
                            <input type="text" name="nameteam" id="nameteam" placeholder="Quyết thắng" />
                            <!-- Thêm ô ẩn để lưu giá trị mã phòng -->
                            <input type="hidden" name="hiddenNameTeam" id="hiddenNameTeam" />
                            <span class="form-name__edit">
                    <i class="fa-solid fa-pencil"></i>
                  </span>
                        </div>
                    </div>
                    <div class="btn d-flex mt-4">
                        <div>
                            <button class="btn-create mr-5" type="submit">Tạo phòng</button>
                        </div>
                        <div class="btn__room">
                            <button class="btn-enter d-block" onclick="enterRoom">Vào phòng</button>
                            <span class="mt-2 d-block">
                    <input type="text" name="roomCode" id="roomCode" placeholder="Nhập mã phòng" />
                  </span>
                            <!-- Thêm ô ẩn để lưu giá trị mã phòng -->
                            <input type="hidden" name="hiddenRoomCode" id="hiddenRoomCode" />
                            <span class="error" style="color: white"><%= mess%></span>
                        </div>
                    </div>
                </form>
            </div>

            <!-- <div class="btn d-flex mt-4">
                    <div>
                        <button class="btn-create mr-5">Tạo phòng</button>
                    </div>
                    <div class="btn__room">
                        <button class="btn-enter d-block">Vào phòng</button>
                       <span class="mt-2 d-block">
                         <input type="text" placeholder="Nhập mã phòng">
                       </span>
                    </div>
                </div> -->
            <div class="account mt-4 d-flex">
                <%
                    User user = (session != null) ? (User)  session.getAttribute("auth") : null;

                    if (user != null) {
                %>
                <!-- Nếu người dùng đã đăng nhập, hiển thị nút đăng xuất -->
                <div>
                    <a href="/logout">Đăng xuất</a>
                </div>
                <%
                } else {
                %>
                <!-- Nếu chưa đăng nhập, hiển thị nút đăng ký và đăng nhập -->
                <div>
                    <a href="/register.jsp">Đăng ký ngay</a>
                </div>
                <div>
                    <a href="/login.jsp">Đăng nhập</a>
                </div>
                <%
                    }
                %>
            </div>
        </div>
    </div>
</main>
</body>
<script>
    function enterRoom() {
        // Lấy giá trị từ ô nhập liệu
        var roomCodeValue = document.getElementById('roomCode').value;
        var nameTeam = document.getElementById('nameteam').value;
        // Gán giá trị vào ô ẩn
        console.log(roomCodeValue)
        document.getElementById('hiddenRoomCode').value = roomCodeValue;
        document.getElementById('hiddenNameTeam').value = nameTeam;
        // Gửi form
        document.getElementById('mainForm').submit();
    }
</script>
</html>
