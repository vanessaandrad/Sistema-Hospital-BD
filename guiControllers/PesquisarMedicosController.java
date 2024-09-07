package guiControllers;

import Service.PacienteService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PesquisarMedicosController {

	private PacienteService pacienteService;

	public PesquisarMedicosController() {
		this.pacienteService = new PacienteService();
	}

	@FXML
	private ChoiceBox<String> choiceBoxEscolha;

	@FXML
	private TextField textFieldDado;

	@FXML
	private Button botaoPesquisar;

	@FXML
	private ListView<String> listViewResultados;

	@FXML
	public void initialize() {
		choiceBoxEscolha.getItems().setAll("Nome", "Especialidade");
	}

	public void procurarMedicos() {
		String dado = textFieldDado.getText();
		pacienteService.procurarMedicos(dado, listViewResultados, choiceBoxEscolha);
	}
}