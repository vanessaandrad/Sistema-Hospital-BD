package guiControllers;

import Service.MedicoService;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroMedicoController {
	private MedicoService medicoService;

	public CadastroMedicoController() {
		this.medicoService = new MedicoService();
	}

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldEspecialidade;

	@FXML
	private TextField textFieldPlanoAtendido;

	@FXML
	private TextField textFieldSenha;

	@FXML
	private TextField textFieldCRM;

	@FXML
	private Button botaoRealizarCadastro;

	@FXML
	private Label labelMensagem;

	@FXML
	public void realizarCadastro() {
		String nome = textFieldNome.getText();
		String especialidade = textFieldEspecialidade.getText();
		String planoAtendido = textFieldPlanoAtendido.getText();
		String senha = textFieldSenha.getText();
		String crm = textFieldCRM.getText();

		if(nome.isEmpty() || especialidade.isEmpty() || planoAtendido.isEmpty() || senha.isEmpty() || crm.isEmpty()) {
			return;
		}
		boolean cadastroRealizado = medicoService.realizarCadastroMedico(nome, especialidade, planoAtendido, senha,
				crm);

		if (cadastroRealizado == true) {
			labelMensagem.setText("Cadastro realizado com sucesso!");
			clearFields();
			System.out.println("Cadastro realizado com sucesso."); // Log para sucesso no cadastro
		} else {
			labelMensagem.setText("Erro ao cadastrar!");
			Alerts.showAlert("ERRO!", "CRM JÁ CADASTRADO!", "Tente novamente!", AlertType.ERROR);
			clearFields();
			System.out.println("Erro ao cadastrar."); // Log para falha no cadastro
		}
	}

	@FXML
	private void clearFields() {
		textFieldNome.clear();
		textFieldEspecialidade.clear();
		textFieldPlanoAtendido.clear();
		textFieldSenha.clear();
		textFieldCRM.clear();
	}
}