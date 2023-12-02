<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
        integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/src/web/assets/css/admin.css">
</head>

<body>
    <div style="display: flex;">
        <ul class="left">
            <li class="left-item"><img style="width: 40%; height: 80%;" src="/assets/img/logo.png" alt="">
            </li>
            <li class="left-item"><a style="color: #8854C0;" href="question-management.jsp">Quản lý câu hỏi</a></li>
            <li class="left-item"><a href="user-management.jsp">Quản lý user</a></li>
            <li class="left-item"><a href="">Đăng xuất</a></li>
        </ul>
        <div class="right">
            <div
                style="height: 56px; background-color: #4B4454; width: 100%; display: flex; justify-content: space-between; align-items: center; padding: 0 70px;">
                <h1>Quản lý câu hỏi</h1>
                <div style="display: flex; gap: 12px; justify-content: center; align-items: center;">
                    <img style="border-radius: 50%; height: 44px; width: 44px;"
                        src="/assets/img/waiting-screen/gacon.JPG" alt="">
                    <span style="color: white; font-size: 22px;">Minh Nhật</span>
                </div>
            </div>
            <div style="margin-top: 8px; display: flex; gap: 20px; justify-content: end;">
                <button class="button-add">Thêm 1 câu hỏi</button>
                <button class="button-add">Thêm file câu hỏi</button>
            </div>
            <table class="table-question" style="width: 100%; font-family: 'Jost*', sans-serif; font-size: 22px; ">
                <tr>
                    <th class="stt-col">STT</th>
                    <th class="question-col">Câu hỏi</th>
                    <th class="answers-col">Danh sách đáp án</th>
                    <th class="correct-col">Đáp án đúng</th>
                    <th class="edit-col"></th>
                </tr>
                <tr>
                    <td class=" stt-col">1</td>
                    <td class="question-col">Lịch nào dài nhất</td>
                    <td class="answers-col">
                        <ul style="display: flex; flex-direction: column;list-style: none;">
                            <li>A. Lịch nghỉ lễ</li>
                            <li>B. Lịch sử</li>
                            <li>C. Lịch âm</li>
                            <li>D. Lịch làm việc</li>
                        </ul>
                    </td>
                    <td class="correct-col">B</td>
                    <td class="edit-col">
                        <i class="fa-solid fa-pen"></i>
                        <i class="fa-solid fa-trash-can"></i>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>

</html>