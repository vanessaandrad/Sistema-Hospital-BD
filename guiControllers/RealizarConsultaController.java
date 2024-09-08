package guiControllers;

import Service.ConsultaService;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RealizarConsultaController {

	private ConsultaService consultaService;

	public RealizarConsultaController() {
		this.consultaService = new ConsultaService();
	}

	@FXML
	private TextArea textAreaSintomas;

	@FXML
	private TextArea textAreaTratamento;

	@FXML
	private TextArea textAreaMedicamentos;

	@FXML
	private TextArea textAreaExames;

	@FXML
	private TextField textFieldPreco;

	@FXML
	private Button botaoFinalizarConsulta;

	@FXML
	public void initialize() {
		consultaService.initializeRealizarConsulta(textFieldPreco);
	}

	public void cliqueBotaoFinalizarConsulta() {
		String sintomas = textAreaSintomas.getText();
		String tratamento = textAreaTratamento.getText();
		String medicamentos = textAreaMedicamentos.getText();
		String exames = textAreaExames.getText();

		boolean sucesso = consultaService.cliqueBotaoFinalizarConsulta(textFieldPreco, sintomas, tratamento,
				medicamentos, exames);

		if (sucesso == true) {
			clearFields();
			Alerts.showAlert("", "Consulta realizada com sucesso", "", AlertType.INFORMATION);
		} else {
			clearFields();
			Alerts.showAlert("ERRO!", "Não foi possível finalizar a consulta!", "Tente novamente!", AlertType.ERROR);
		}
	}

	private void clearFields() {
		textAreaSintomas.setText(null);
		textAreaTratamento.setText(null);
		textAreaMedicamentos.setText(null);
		textAreaExames.setText(null);
		textFieldPreco.setText("");
	}
}