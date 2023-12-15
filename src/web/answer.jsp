<%@ page import="java.util.List" %>
<%@ page import="models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Question" %>
<%@ page import="services.LevelService" %>
<%@ page import="models.Answer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Màn hình trả lời câu hỏi</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
          integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <link rel="stylesheet" href="/assets/css/waiting-screen.css">
    <link rel="stylesheet" href="/assets/css/answer.css">
</head>

<body style=" height: 100%; display: flex; align-items: center;">
<div class="container w-100">
    <div class="d-flex justify-content-between ">
        <div class="pl-5" style="height: fit-content;"><img class="w-75 h-75" src="/assets/img/logo.png" alt="">
        </div>
        <div class="d-flex id-room ">
            <span style="color: #B1ADCF; font-size: 64px; font-weight: 400; line-height: normal;"> H2oJ20</span>
            <i style="color: #B1ADCF; font-size: 64px;" class="fa-solid fa-copy"></i>
        </div>
        <div class="pt-4" style="height: fit-content;"><img class="w-75 h-75" src="/assets/img/waiting-screen/exit.png"
                                                            alt=""></div>
    </div>
    <% List<User> userList = (List<User>) request.getAttribute("userList");
        User host = (User) request.getAttribute("host");
        userList.remove(host);%>
    <div class="d-flex justify-content-between w-100" style="height:600px;">
        <div class="bg-concept col-3 p-0" style="border-radius: 20px;">
            <div class="user-item">
                <img class="img-user-item" src="/assets/img/waiting-screen/chiVy.jpg" alt="">
                <div>
                    <div class="name-user-item"><%=host.getName_team()%>
                    </div>
                    <div class="role-user-item" style="color: #4B4454;">
                        <i class=" fa-solid fa-crown"></i>
                        <span style="font-weight: 400;
                                ">Host</span>
                    </div>
                </div>
            </div>
            <% for (int i = 0; i < userList.size(); i++) {
                List<String> url = new ArrayList<>();
                url.add("/assets/img/waiting-screen/meoden.JPG");
                url.add("/assets/img/waiting-screen/cudem.JPG");
                url.add("/assets/img/waiting-screen/daibang.JPG");
                url.add("/assets/img/waiting-screen/gacon.JPG");
                url.add("/assets/img/waiting-screen/chiVy.jpg");
                url.add("/assets/img/waiting-screen/meoden.JPG");
                url.add("/assets/img/waiting-screen/cudem.JPG");
                url.add("/assets/img/waiting-screen/daibang.JPG");
                url.add("/assets/img/waiting-screen/gacon.JPG");
            %>
            <div class="user-item">
                <img class="img-user-item" src=<%=url.get(i)%> alt="">
                <div>
                    <div class="name-user-item"><%=userList.get(i).getName_team()%>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        <%
            List<Question> questionList = (List<Question>) session.getAttribute("questionList");
//            int playingTime = 0;
        %>
        <div class="bg-concept col-8 " style="border-radius: 20px; padding: 0 44px; font-family: 'Jost*', sans-serif;">
            <div class="d-flex flex-column">
                <div class="d-flex justify-content-between align-items-center text-white">
                    <div style="font-size: 25px;">Question <span
                            class="index-question">1</span> <%="/" + questionList.size()%>
                    </div>
                    <div style="font-size: 30px;"><span id="total-time">0</span>s
                    </div>
                </div>
                <div class="bg-white" style="border-radius: 20px; height: 165px;">
                    <p style="font-size: 25px;" class="pt-2 pl-4 question"><%=questionList.get(0).getQuestion()%>
                    </p>
                </div>
                <span style="font-size: 20px;"
                      class="d-flex align-self-end text-white"><%=LevelService.getInstance().getLevel(questionList.get(0).getId_level()).getName()%></span>
            </div>
            <!-- tra loi -->
            <div class="d-flex flex-column pt-2" style="">
                <div class="row m-0" style=" gap:  12px 44px;font-size: 25px;">
                    <%if (questionList.get(0).getAnswerList().size() != 0) {%>
                    <button onclick="checkAnswer(this)"
                            class="answer-item answer-item-1 <%=questionList.get(0).getAnswerList().get(0).isCorrect()%>">
                        <%=questionList.get(0).getAnswerList().get(0).getAnswer()%>
                    </button>
                    <button onclick="checkAnswer(this)"
                            class="answer-item answer-item-2 <%=questionList.get(0).getAnswerList().get(1).isCorrect()%>">
                        <%=questionList.get(0).getAnswerList().get(1).getAnswer()%>
                    </button>
                    <button onclick="checkAnswer(this)"
                            class="answer-item answer-item-3 <%=questionList.get(0).getAnswerList().get(2).isCorrect()%>">
                        <%=questionList.get(0).getAnswerList().get(2).getAnswer()%>
                    </button>
                    <button onclick="checkAnswer(this)"
                            class="answer-item answer-item-4 <%=questionList.get(0).getAnswerList().get(3).isCorrect()%>">
                        <%=questionList.get(0).getAnswerList().get(3).getAnswer()%>
                    </button>
                    <%}%>
                </div>

                <div class="bg-white w-100 mt-4" style="height: 12px; border-radius: 20px;">
                    <div class="time-down h-100" style="background-color: #8854C0; border-radius: 10px; width: 100%"></div>
                </div>

                <div class="d-flex flex-column justify-content-between align-items-center"
                     style="margin-top: 32px; gap:32px; padding-bottom: 32px">
                    <button onclick="nextQuestion()" class="d-none button-continue"
                            style="background-color: #F5F061; padding: 8px 16px; border-radius: 10px; font-size: 25px; height: fit-content; border: none;">
                        Tiếp
                        tục
                    </button>
                    <img style="height: 80px;" class="mt-2  d-none congratulation"
                         src="/assets/img/waiting-screen/congratulate.png" alt="">
                    <img style="height: 80px;" class="mt-2  d-none out-of-time"
                         src="/assets/img/waiting-screen/out-of-time.png.png" alt="">
                    <img style="height: 80px;" class="mt-2  d-none regret"
                         src="/assets/img/waiting-screen/regret.png.png.png" alt="">

                </div>
            </div>
        </div>
    </div>
</div>
<script src="js/answer.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"
        integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>

</html>