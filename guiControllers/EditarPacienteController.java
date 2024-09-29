package guiControllers;

import java.time.LocalDate;

import Service.PacienteService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class EditarPacienteController {

	private PacienteService pacienteService;

	public EditarPacienteController() {
		this.pacienteService = new PacienteService();
	}

	@FXML
	private RadioButton radioButtonNome;

	@FXML
	private RadioButton radioButtonIdade;

	@FXML
	private RadioButton radioButtonCPF;

	@FXML
	private RadioButton radioButtonPlano;

	@FXML
	private RadioButton radioButtonSenha;
	
	@FXML
	private DatePicker DatePickerEditar;

	@FXML
	private TextField textFieldEditar;

	@FXML
	private Button botaoEditar;

	@FXML
	private Label labelMensagem;

	public void editarDado() {
		String dadoNovo = textFieldEditar.getText();
		LocalDate data_nascimento_nova = DatePickerEditar.getValue();
		String campoSelecionado = null;

		if (radioButtonNome.isSelected()) {
			campoSelecionado = "nome";
		} else if (radioButtonIdade.isSelected()) {
			campoSelecionado = "data_nascimento";
		} else if (radioButtonCPF.isSelected()) {
			campoSelecionado = "cpf";
		} else if (radioButtonPlano.isSelected()) {
			campoSelecionado = "plano";
		} else if (radioButtonSenha.isSelected()) {
			campoSelecionado = "senha";
		} else {
			return;
		}
		
		pacienteService.editarDado(campoSelecionado, dadoNovo, data_nascimento_nova);
	}
}