<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Unity</title>
    <link rel="stylesheet" href="/assets/css/home.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
    />
    <!--  -->
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css"/>
</head>
<body>
<main>
    <div class="main-warpper">
        <div class="main-content">
            <div class="logo">
                <img src="/assets/img/logo.png" alt=""/>
            </div>
            <div class="avatar">
                <div class="avatar__img"></div>
                <span class="avatar__edit">
              <i class="fa-solid fa-pencil"></i>
            </span>
            </div>

            <div class="form-name">
                <form action="" class="mx-auto">
                    <div class="mx-auto">
                        <!-- <label for="" class="d-inline-block">Biệt danh</label> -->

                        <div class="form-name__input">
                            <input type="text" placeholder="Quyết thắng"/>
                            <span class="form-name__edit">
                    <i class="fa-solid fa-pencil"></i>
                  </span>
                        </div>
                    </div>
                    <%--                    <div class="btn d-flex mt-4">--%>
                    <%--                        <div>--%>
                    <%--                            <button onclick="myfuncion()" class="btn-create mr-5">Tạo phòng</button>--%>
                    <%--                        </div>--%>
                    <%--                        <div class="btn__room">--%>
                    <%--                            <button class="btn-enter d-block">Vào phòng</button>--%>
                    <%--                            <span class="mt-2 d-block">--%>
                    <%--                        <input type="text" placeholder="Nhập mã phòng"/>--%>
                    <%--                            </span>--%>
                    <%--                        </div>--%>
                    <%--                    </div>--%>
                </form>
            </div>

            <div class="btn d-flex mt-4">
                <div>
                    <button id="myBtn" class="btn-create mr-5">Tạo phòng</button>
                </div>
                <div class="btn__room">
                    <button class="btn-enter d-block">Vào phòng</button>
                    <span class="mt-2 d-block">
                         <input type="text" placeholder="Nhập mã phòng">
                       </span>
                </div>
            </div>
            <div class="account mt-4 d-flex">
                <div><a href="">Đăng ký ngay</a></div>
                <div><a href="">Đăng nhập</a></div>
            </div>
        </div>
    </div>
</main>
<div id="modal" class="modal">
    <div class="frame border">
        <div class="containerItem border mar-7">
            <div class="item border">
                <b class="b">CÀI ĐẶT</b>
            </div>
            <div class="containerItemExit" style="cursor: pointer" id="close">
                <span class="exit">
                    <span class="itemExit itemExitLe"></span>
                    <span class="itemExit itemExitRi"></span>
                </span>
            </div>
        </div>
        <jsp:include page="setting.jsp"></jsp:include>
    </div>
</div>
<script>
    var modal = document.getElementById("modal");
    var close = document.getElementById("close");
    close.onclick = function () {
        modal.style.display = "none";
    }
    var btn = document.getElementById("myBtn");
    btn.onclick = function () {
        modal.style.display = "block";
    }

    window.onclick = function (event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    }
</script>
</body>
</html>
