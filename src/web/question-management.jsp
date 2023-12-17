<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý câu hỏi</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
          integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <style>

    </style>
</head>

<body>
<div style="display: flex;">
    <!-- Sidebar -->
    <ul class="left">
        <li class="left-item"><img style="width: 40%; height: 80%;" src="/assets/img/logo.png" alt=""></li>
        <li class="left-item"><a style="color: #8854C0;" href="#">Quản lý câu hỏi</a></li>
        <li class="left-item"><a href="#">Quản lý user</a></li>
        <li class="left-item"><a href="#">Đăng xuất</a></li>
    </ul>

    <!-- Main Content -->
    <div class="right">
        <div style="height: 56px; background-color: #4B4454; width: 100%; display: flex; justify-content: space-between; align-items: center; padding: 0 70px;">
            <h1>Quản lý câu hỏi</h1>
            <div style="display: flex; gap: 12px; justify-content: center; align-items: center;">
                <img style="border-radius: 50%; height: 44px; width: 44px;"
                     src="/assets/img/waiting-screen/gacon.JPG" alt="">
                <span style="color: white; font-size: 22px;">Minh Nhật</span>
            </div>
        </div>

        <!-- Hiển thị danh sách câu hỏi -->
        <table class="table-question" style="width: 100%; font-family: 'Jost*', sans-serif; font-size: 22px;">
            <thead>
            <tr>
                <th class="stt-col">STT</th>
                <th class="question-col">Câu hỏi</th>
                <th class="answers-col">Danh sách đáp án</th>
                <th class="correct-col">Đáp án đúng</th>
                <th class="edit-col"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="question" items="${questions}">
                <tr>
                    <td class="stt-col">${question.id}</td>
                    <td class="question-col">${question.question}</td>
                    <td class="answers-col">
                        <ul style="display: flex; flex-direction: column;list-style: none;">
                            <c:forEach var="answer" items="${question.answerList}">
                                <li>${answer.answer} ${answer.correct ? '(Đúng)' : ''}</li>
                            </c:forEach>
                        </ul>
                    </td>
                    <td class="correct-col">${question.correctAnswer}</td>
                    <td class="edit-col">
                        <a href="#" onclick="editQuestion(${question.id})"><i class="fas fa-pencil-alt"></i></a>
                        <a href="#" onclick="deleteQuestion(${question.id})"><i class="fas fa-trash-alt"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- Form thêm câu hỏi -->
        <div style="margin-top: 8px; display: flex; gap: 20px; justify-content: end;">
            <button class="button-add" onclick="showAddQuestionForm()">Thêm 1 câu hỏi</button>
            <button class="button-add">Thêm file câu hỏi</button>
        </div>
        <div id="addQuestionForm" style="display: none;">
            <h2>Thêm câu hỏi</h2>
            <form action="${pageContext.request.contextPath}/question" method="post">
                <input type="hidden" name="action" value="add">
                Câu hỏi: <input type="text" name="question" required><br>
                Level: <input type="text" name="id_level" required><br>
                <label>Đáp án 1: <input type="text" name="answer1" required></label>
                <label>Đáp án 2: <input type="text" name="answer2" required></label>
                <label>Đáp án 3: <input type="text" name="answer3" required></label>
                <label>Đáp án 4: <input type="text" name="answer4" required></label>
                <label>Đáp án đúng: <input type="text" name="correctAnswer" required></label>
                <input type="submit" value="Thêm câu hỏi">
            </form>
        </div>

        <!-- Form sửa câu hỏi -->
        <div id="editQuestionForm" style="display: none;">
            <h2>Sửa câu hỏi</h2>
            <form action="${pageContext.request.contextPath}/question" method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" id="editQuestionId">
                Câu hỏi: <input type="text" name="question" id="editQuestionText" required><br>
                Level: <input type="text" name="id_level" id="editQuestionLevel" required><br>
                <label>Đáp án 1: <input type="text" name="answer1" required></label>
                <label>Đáp án 2: <input type="text" name="answer2" required></label>
                <label>Đáp án 3: <input type="text" name="answer3" required></label>
                <label>Đáp án 4: <input type="text" name="answer4" required></label>
                <label>Đáp án đúng: <input type="text" name="correctAnswer" required></label>
                <input type="submit" value="Lưu câu hỏi">
                <button type="button" onclick="hideEditQuestionForm()">Hủy bỏ</button>
            </form>
        </div>

        <!-- Script xử lý xóa và sửa câu hỏi -->
        <script>
            function deleteQuestion(questionId) {
                if (confirm("Bạn có chắc chắn muốn xóa câu hỏi này không?")) {
                    window.location.href = "${pageContext.request.contextPath}/question?action=delete&id=" + questionId;
                }
            }

            function showAddQuestionForm() {
                var addQuestionForm = document.getElementById("addQuestionForm");
                addQuestionForm.style.display = "block";
            }

            function editQuestion(questionId) {
                // Gọi AJAX để lấy thông tin câu hỏi từ server
                // Hiển thị form sửa câu hỏi với thông tin đã lấy được
                var questionText = "Câu hỏi mẫu"; // Thay bằng thông tin câu hỏi thực tế
                var questionLevel = "1"; // Thay bằng thông tin câu hỏi thực tế

                document.getElementById("editQuestionId").value = questionId;
                document.getElementById("editQuestionText").value = questionText;
                document.getElementById("editQuestionLevel").value = questionLevel;

                var editQuestionForm = document.getElementById("editQuestionForm");
                editQuestionForm.style.display = "block";
            }

            function hideEditQuestionForm() {
                var editQuestionForm = document.getElementById("editQuestionForm");
                editQuestionForm.style.display = "none";
            }
        </script>
    </div>
</div>
</body>

</html>