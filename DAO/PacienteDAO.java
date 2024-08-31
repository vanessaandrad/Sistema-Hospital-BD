package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gui.util.Alerts;
import guiControllers.TelaLoginPacienteController;
import javafx.scene.control.Alert.AlertType;

public class PacienteDAO {

	public boolean cpfExiste(String cpfDigitado) {
		String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM pacientes WHERE cpf = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setString(1, cpfDigitado);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				return resultSet.next();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean realizarCadastroPaciente(String nome, String idade, String senha, String cpf, String plano) {

		String url = "jdbc:mysql://localhost:3306/hospital";
		String username = "root";
		String password = "86779791";

		if (cpfExiste(cpf) == true) {
			Alerts.showAlert("ERRO!", "CPF JÁ EXISTENTE!", "Tente novamente!", AlertType.ERROR);
			return false;
		}
		String insertQuery = "INSERT INTO pacientes (cpf, nome, idade, senha, plano) VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setString(1, cpf);
			preparedStatement.setString(2, nome);
			preparedStatement.setString(3, idade);
			preparedStatement.setString(4, senha);
			preparedStatement.setString(5, plano);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean fazerLogin(String cpf, String senha) {
		String url = "jdbc:mysql://localhost:3306/hospital";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM pacientes WHERE cpf = ? AND senha = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setString(1, cpf);
			preparedStatement.setString(2, senha);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					TelaLoginPacienteController.cpfLogado = cpf;
					TelaLoginPacienteController.planoLogado = resultSet.getString("plano");
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Alerts.showAlert("Login inválido", null, "Tente novamente!", AlertType.ERROR);
		return false;
	}
}