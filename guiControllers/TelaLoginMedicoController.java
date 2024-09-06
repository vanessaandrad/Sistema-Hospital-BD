package guiControllers;

import Service.MedicoService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaLoginMedicoController {

	private MedicoService medicoService;

	public TelaLoginMedicoController() {
		this.medicoService = new MedicoService();
	}

	@FXML
	private TextField textFieldUsuario;

	@FXML
	private TextField textFieldSenha;

	@FXML
	private Button botaoLogin;

	@FXML
	private Label labelCliqueCadastro;

	public static String crmLogado;

	@FXML
	public void fazerLogin() {
		String crm = textFieldUsuario.getText();
		String senha = textFieldSenha.getText();

		boolean sucesso = medicoService.fazerLogin(crm, senha);
		if (sucesso == true) {
			abrirMenuMedico();
		} else {
		}
	}

	@FXML
	public void cliqueBotaoCadastrarMedico() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/guiFXML/CadastroMedicos.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Cadastro de médicos");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	public void abrirMenuMedico() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/guiFXML/MenuMedico.fxml"));
			Parent root = loader.load();
			Stage stage = new Stage();
			stage.setTitle("Menu do médico");
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getcrmLogado() {
		return crmLogado;
	}
}