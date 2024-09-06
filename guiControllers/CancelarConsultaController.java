package guiControllers;

import Service.ConsultaService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class CancelarConsultaController {

	private ConsultaService consultaService;

	public CancelarConsultaController() {
		this.consultaService = new ConsultaService();
	}

	@FXML
	private ComboBox<String> comboBoxConsultasMarcadas;

	@FXML
	private Button botaoCancelamento;

	@FXML
	private Label labelMensagem;

	@FXML
	public void initialize() {
		consultaService.initializeCancelarConsulta(comboBoxConsultasMarcadas);
	}

	public void cliqueBotaoCancelar() {
		consultaService.cliqueBotaoCancelar(comboBoxConsultasMarcadas);
	}
}