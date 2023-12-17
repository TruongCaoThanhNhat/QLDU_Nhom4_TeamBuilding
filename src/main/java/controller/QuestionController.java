package controller;



import models.Question;
import services.QuestionManagementService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QuestionController", urlPatterns = {"/questions"})
public class QuestionController extends HttpServlet {
    private QuestionManagementService questionService;

    @Override
    public void init() throws ServletException {
        super.init();
        questionService = new QuestionManagementService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Question> questions = questionService.getAllQuestions();
        request.setAttribute("questions", questions);
        request.getRequestDispatcher("/WEB-INF/views/questions.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            // Xử lý thêm câu hỏi từ form
            String questionText = request.getParameter("question");
            int levelId = Integer.parseInt(request.getParameter("id_level"));

            // Lấy thông tin đáp án từ form (giả sử có 4 đáp án)
            String answer1 = request.getParameter("answer1");
            String answer2 = request.getParameter("answer2");
            String answer3 = request.getParameter("answer3");
            String answer4 = request.getParameter("answer4");

            // Lấy đáp án đúng từ form
            String correctAnswer = request.getParameter("correctAnswer");

            Question newQuestion = new Question();
            newQuestion.setQuestion(questionText);
            // Thiết lập thông tin khác cho câu hỏi

            questionService.addQuestion(newQuestion);
        } else if ("update".equals(action)) {
            // Xử lý cập nhật câu hỏi từ form
            int questionId = Integer.parseInt(request.getParameter("id"));
            String questionText = request.getParameter("question");
            int levelId = Integer.parseInt(request.getParameter("id_level"));

            // Lấy thông tin đáp án từ form (giả sử có 4 đáp án)
            String answer1 = request.getParameter("answer1");
            String answer2 = request.getParameter("answer2");
            String answer3 = request.getParameter("answer3");
            String answer4 = request.getParameter("answer4");

            // Lấy đáp án đúng từ form
            String correctAnswer = request.getParameter("correctAnswer");

            Question updatedQuestion = new Question();
            updatedQuestion.setId(questionId);
            updatedQuestion.setQuestion(questionText);
            // Thiết lập thông tin khác cho câu hỏi cần cập nhật

            questionService.updateQuestion(updatedQuestion);
        } else if ("delete".equals(action)) {
            // Xử lý xóa câu hỏi
            int questionId = Integer.parseInt(request.getParameter("id"));
            questionService.deleteQuestion(questionId);
        }

      
        response.sendRedirect(request.getContextPath() + "/questions");
    }
}