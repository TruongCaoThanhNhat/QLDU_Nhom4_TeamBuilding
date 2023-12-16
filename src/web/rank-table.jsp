<%@ page import="models.Score" %>
<%@ page import="java.util.List" %>
<%@ page import="services.ScoreService" %>
<%@ page import="services.UserService" %>
<%@ page import="models.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% List<Score> scoreList = (List<Score>) request.getAttribute("scoreList");%>
<html>

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="assets/css/rank.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
</head>

<body>
<div class="container">
    <%--    <div class="item-bxh border bg-bxh">--%>
    <%--        <div class="posi-abso">--%>
    <%--            <img src="assets/img/rank-table/cup1.png" class="wid100 hei100" alt="cup">--%>
    <%--        </div>--%>
    <%--        <div class="mar-lef500 posi-abso">--%>
    <%--            <img src="assets/img/rank-table/cup1.png" class="wid100 hei100" alt="cup">--%>
    <%--        </div>--%>
    <%--        <div class="hei100">--%>
    <%--            <br>--%>
    <%--            <b class="bxh mar-lef20">BẢNG XẾP HẠNG</b>--%>
    <%--            <div>--%>
    <%--                <img src="assets/img/rank-table/cup2.png" class="wid180 hei110 posi-abso" alt="cup">--%>
    <%--                <img src="assets/img/rank-table/banron.webp" class="wid200 hei110" alt="cup1">--%>
    <%--            </div>--%>
    <%--        </div>--%>

    <%--    </div>--%>
    <div class="frame border">
        <div class="item-bxh border bg-bxh">
            <div class="posi-abso">
                <img src="assets/img/rank-table/cup1.png" class="wid100 hei100" alt="cup">
            </div>
            <div class="mar-lef500 posi-abso">
                <img src="assets/img/rank-table/cup1.png" class="wid100 hei100" alt="cup">
            </div>
            <div class="hei100" style="text-align: center;">
                <br>
                <b class="bxh mar-lef20">BẢNG XẾP HẠNG</b>
                <div>
                    <img src="assets/img/rank-table/cup2.png" class="wid180 hei110 posi-abso" alt="cup">
                    <img src="assets/img/rank-table/banron.webp" class="wid200 hei110" alt="cup1">
                </div>
            </div>

        </div>
        <div class="containerItemExit">
                <span class="exit cusor">
                    <span class="itemExit itemExitLe"></span>
                    <span class="itemExit itemExitRi"></span>
                </span>
        </div>
        <div class="containerSetting mar-bxh border bg-bxh scroll">
            <table style="width: 1200px; border-spacing: 20px;" class="mt20">
                <tr>
                    <th>NO</th>
                    <th>TEAM</th>
                    <th>ANSWER</th>
                    <th>TIME</th>
                </tr>
                <% int count = 1;
                    for (Score score : scoreList) {
                        score.setTeam(UserService.getInstance().getUserById(score.getId_team()));
                %>
                <tr class="top" style="border-spacing: 20px">
                    <td><%=count%>
                    </td>
                    <td><%=score.getTeam().getName_team()%>
                    </td>
                    <td><%=score.getCorrect_answer()%>/15
                        <%--                    <%=score.getQuestionList().size()%>--%>
                    </td>
                    <td><%=score.getPlaying_time()%>
                    </td>
                </tr>
                <% count++;
                }%>
                <tr class="mt20">
                    <td>2</td>
                    <td>Lá Vàng</td>
                    <td>15/15</td>
                    <td>120s</td>
                </tr>
            </table>
<%--            <table>--%>
<%--                <tr class="mt20">--%>
<%--                    <th class="pdl-bxh20 mt50 fontbxh"> NO</th>--%>
<%--                    <th class="pdl-bxh200 mt50 fontbxh"> TEAM</th>--%>
<%--                    <th class="pdl-bxh200 mt50 fontbxh"> ANSWER</th>--%>
<%--                    <th class="pdl-bxh200 mt50 fontbxh"> TIME</th>--%>
<%--                </tr>--%>
<%--                <% int count = 1;--%>
<%--                    for (Score score : scoreList) {--%>
<%--                        score.setTeam(UserService.getInstance().getUserById(score.getId_team()));--%>
<%--                %>--%>
<%--                <tr class="divbxh mt20 ml30 border-bxh top">--%>
<%--                    <td class="mt20 fontbxh"><%=count%>--%>
<%--                    </td>--%>
<%--                    <td class="pdl-bxh200 mt20 fontbxh"><%=score.getTeam().getName_team()%>--%>
<%--                    </td>--%>
<%--                    <td class="pdl-bxh200 mt20 fontbxh"><%=score.getCorrect_answer()%>/15--%>
<%--                        &lt;%&ndash;                    <%=score.getQuestionList().size()%>&ndash;%&gt;--%>
<%--                    </td>--%>
<%--                    <td class="pdl-bxh200 mt20 fontbxh"><%=score.getPlaying_time()%>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--                <% count++;--%>
<%--                }%>--%>
<%--                <tr class="divbxh mt20 border-bxh">--%>
<%--                    <td class="mt20 fontbxh">2</td>--%>
<%--                    <td class="pdl-bxh200 mt20 fontbxh">Lá Vàng</td>--%>
<%--                    <td class="pdl-bxh200 mt20 fontbxh">15/15</td>--%>
<%--                    <td class="pdl-bxh200 mt20 fontbxh">120s</td>--%>
<%--                </tr>--%>
<%--            </table>--%>
        </div>
    </div>
</div>
</body>

</html>