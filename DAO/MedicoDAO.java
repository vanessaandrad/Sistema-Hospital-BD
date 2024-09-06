package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import gui.util.Alerts;
import guiControllers.TelaLoginMedicoController;
import javafx.scene.control.Alert.AlertType;

public class MedicoDAO {

	public boolean verificarCrmExiste(String crmDigitado) {
		if (crmDigitado == null || crmDigitado.trim().isEmpty()) {
			System.out.println("CRM inválido: vazio ou nulo."); // Log para verificar CRM inválido
			return false;
		}

		String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM medicoscadastrados WHERE crm = ?";

		System.out.println("Verificando CRM: " + crmDigitado);

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setString(1, crmDigitado);
			ResultSet resultSet = preparedStatement.executeQuery();

			boolean crmExiste = resultSet.next();
			System.out.println("CRM existe: " + crmExiste);
			return crmExiste;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean realizarCadastroMedico(String nome, String especialidade, String planoAtendido, String senha,
			String crm) {

		String url = "jdbc:mysql://localhost:3306/hospital";
		String username = "root";
		String password = "86779791";

		if (verificarCrmExiste(crm) == true) {
			Alerts.showAlert("ERRO!", "CRM JÁ CADASTRADO!", "Tente novamente!", AlertType.ERROR);
			return false;
		}

		String insertQuery = "INSERT INTO medicoscadastrados (nome, especialidade, plano_atendido, senha, crm)"
				+ " VALUES (?, ?, ?, ?, ?)";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, especialidade);
			preparedStatement.setString(3, planoAtendido);
			preparedStatement.setString(4, senha);
			preparedStatement.setString(5, crm);

			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException | NumberFormatException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean fazerLogin(String crm, String senha) {
		String url = "jdbc:mysql://localhost:3306/hospital";
		String username = "root";
		String password = "86779791";

		String selectQuery = "SELECT * FROM medicoscadastrados WHERE senha = ? AND crm = ?";

		try (Connection connection = DriverManager.getConnection(url, username, password);
				PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

			preparedStatement.setString(1, senha);
			preparedStatement.setString(2, crm);

			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					TelaLoginMedicoController.crmLogado = crm;
					return true;
				} else {
					Alerts.showAlert("Login inválido", null, "Usuário não encontrado", AlertType.ERROR);
					return false;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Alerts.showAlert("Erro", null, "Erro ao realizar o login", AlertType.ERROR);
			return false;
		}
	}
}