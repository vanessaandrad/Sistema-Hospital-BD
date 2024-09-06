package guiControllers;

import Service.MedicoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class EditarMedicoController {

	private MedicoService medicoService;

	public EditarMedicoController() {
		this.medicoService = new MedicoService();
	}

	@FXML
	private RadioButton radioButtonNome;

	@FXML
	private RadioButton radioButtonEspecialidade;

	@FXML
	private RadioButton radioButtonCRM;

	@FXML
	private RadioButton radioButtonPlano;

	@FXML
	private RadioButton radioButtonSenha;

	@FXML
	private TextField textFieldEditar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Label labelMensagem;

	public void editarDado() {
		String dadoNovo = textFieldEditar.getText();
		String campoSelecionado = null;

		if (radioButtonNome.isSelected()) {
			campoSelecionado = "nome";
		} else if (radioButtonEspecialidade.isSelected()) {
			campoSelecionado = "especialidade";
		} else if (radioButtonCRM.isSelected()) {
			campoSelecionado = "crm";
		} else if (radioButtonPlano.isSelected()) {
			campoSelecionado = "plano";
		} else if (radioButtonSenha.isSelected()) {
			campoSelecionado = "senha";
		} else {
			return;
		}

		medicoService.editarDado(campoSelecionado, dadoNovo);
	}
}