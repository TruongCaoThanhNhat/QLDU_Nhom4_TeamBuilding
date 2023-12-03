<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="assets/css/rank-setting.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" />
</head>

<body>
<%--    <div class="frame border">--%>
<%--        <div class="containerItem border">--%>
<%--            <div class="item border">--%>
<%--                <br>--%>
<%--                <b class="b">PHÒNG</b>--%>
<%--            </div>--%>
<%--            <div class="containerItemExit" onclick="close()">--%>
<%--                <span class="exit">--%>
<%--                    <span class="itemExit itemExitLe"></span>--%>
<%--                    <span class="itemExit itemExitRi"></span>--%>
<%--                </span>--%>
<%--            </div>--%>
<%--        </div>--%>

        <div class="containerSetting">
            <div>
                <div class="containerSettingLeft">
                    <p class="font">Câu hỏi: </p>
                    <div class="conSeLeft">
                        <p class="font">Dễ</p>
                        <p class="font">Trung bình</p>
                        <p class="font">Khó</p>
                    </div>
                    <div class="conSeRight">
                        <p>
                            <select class="mar-left dropdown" id="numbers">
                                <option value=""></option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                        </p>
                        <p>
                            <select class="mar-left dropdown" id="numbers">
                                <option value=""></option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                        </p>
                        <p>
                            <select class="mar-left dropdown" id="numbers">
                                <option value=""></option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                            </select>
                        </p>
                    </div>
                </div>
                <div class="containerSettingRight">
                    <label class="font" for="numbers">Số đội chơi: </label>
                    <select class="mar-left dropdown" id="numbers">
                        <option value=""></option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </div>
            </div>
            <div class="containerSettingBottom">
                <div class="containerSettingBottomLe">
                    <p class="font format">Mã phòng: <span class="fontID">H2OJ20</span> <i
                            class=" fontSize25 fas fa-copy"></i>
                    </p>
                </div>
                <div class="containerSettingBottomRi">
                    <p class="font formatOK borderOK">OK</p>
                </div>
            </div>
        </div>
<%--    </div>--%>
</body>

</html>