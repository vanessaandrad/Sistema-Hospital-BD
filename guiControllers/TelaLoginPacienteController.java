package guiControllers;

import Service.PacienteService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginPacienteController {

	private PacienteService pacienteService;

	public TelaLoginPacienteController() {
		this.pacienteService = new PacienteService();
	}

	@FXML
	private TextField textFieldUsuario;

	@FXML
	private TextField textFieldSenha;

	@FXML
	private Button botaoLogin;

	@FXML
	private Label labelCliqueCadastro;

	public static String cpfLogado;

	public static String planoLogado;

	public void fazerLogin() {
		String cpf = textFieldUsuario.getText();
		String senha = textFieldSenha.getText();

		if (pacienteService.fazerLogin(cpf, senha) == true) {
			abrirMenuPaciente();
		} else {
			return;
		}
	}

	public void abrirMenuPaciente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/guiFXML/MenuPaciente.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Menu do paciente");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void cliqueBotaoCadastrarPaciente() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/guiFXML/CadastroCliente.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Cadastro de pacientes");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getcpfLogado() {
		return cpfLogado;
	}

	public static String getPlanoLogado() {
		return planoLogado;
	}
}