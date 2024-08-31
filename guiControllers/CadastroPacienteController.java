package guiControllers;

import Service.PacienteService;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroPacienteController {

	private PacienteService pacienteService;

	public CadastroPacienteController() {
		this.pacienteService = new PacienteService();
	}

	@FXML
	private TextField textFieldNome;

	@FXML
	private TextField textFieldIdade;

	@FXML
	private CheckBox checkBoxPlano;

	@FXML
	private TextField textFieldPlano;

	@FXML
	private TextField textFieldSenha;

	@FXML
	private TextField textFieldCPF;

	@FXML
	private Button botaoRealizarCadastroC;

	@FXML
	private Label labelMensagem;

	@FXML
	public void initialize() {
		textFieldPlano.setDisable(true);

		checkBoxPlano.setOnAction(event -> {
			textFieldPlano.setDisable(!checkBoxPlano.isSelected());
			if (!checkBoxPlano.isSelected()) {
				textFieldPlano.clear();
			}
		});
	}

	@FXML
	public void realizarCadastroPaciente() {

		String nome = textFieldNome.getText();
		String idade = textFieldIdade.getText();
		String senha = textFieldSenha.getText();
		String cpf = textFieldCPF.getText();
		String plano = checkBoxPlano.isSelected() ? textFieldPlano.getText() : null;

		if (pacienteService.verificarCpfExiste(cpf)) {
			Alerts.showAlert("ERRO!", "CPF JÁ EXISTENTE!", "Tente novamente!", AlertType.ERROR);
			return;
		}

		boolean cadastroRealizado = pacienteService.cadastrarPaciente(nome, idade, senha, cpf, plano);

		if (cadastroRealizado == true) {
			labelMensagem.setText("Cadastro realizado com sucesso!");
			clearFields();
		} else {
			labelMensagem.setText("Erro ao cadastrar!");
			clearFields();
		}
	}

	private void clearFields() {
		textFieldNome.clear();
		textFieldIdade.clear();
		textFieldPlano.clear();
		textFieldSenha.clear();
		textFieldCPF.clear();
	}
}