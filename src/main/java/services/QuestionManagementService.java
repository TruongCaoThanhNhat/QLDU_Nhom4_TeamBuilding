package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import db.Db;
import models.Question;

public class QuestionManagementService {
	private static final String GET_ALL_QUESTIONS = "SELECT * FROM question";
	private static final String GET_QUESTION_BY_ID = "SELECT * FROM question WHERE ID=?";
	private static final String ADD_QUESTION = "INSERT INTO question (question, id_level) VALUES (?, ?)";
	private static final String UPDATE_QUESTION = "UPDATE question SET question=?, id_level=? WHERE ID=?";
	private static final String DELETE_QUESTION = "DELETE FROM question WHERE ID=?";

	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<>();
		try (Connection connection = new Db().getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_ALL_QUESTIONS);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				Question question = new Question(resultSet.getInt("ID"), resultSet.getString("question")

				);
				questions.add(question);
			}

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception appropriately
		}
		return questions;
	}


	

	public void addQuestion(Question question) {
		try (Connection connection = new Db().getConnection();
				PreparedStatement statement = connection.prepareStatement(ADD_QUESTION)) {

			statement.setString(1, question.getQuestion());
			statement.setInt(2, question.getId_level());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception appropriately
		}
	}

	public void updateQuestion(Question question) {
		try (Connection connection = new Db().getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_QUESTION)) {

			statement.setString(1, question.getQuestion());
			statement.setInt(2, question.getId_level());
			statement.setInt(3, question.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception appropriately
		}
	}

	public void deleteQuestion(int id) {
		try (Connection connection = new Db().getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_QUESTION)) {

			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace(); // Handle or log the exception appropriately
		}
	}

}
