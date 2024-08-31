package guiControllers;

import Service.ConsultaService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class AgendarConsultaController {

	private ConsultaService consultaService;

	public AgendarConsultaController() {
		this.consultaService = new ConsultaService();
	}

	@FXML
	private ComboBox<String> comboBoxMedicosDisponiveis;

	@FXML
	private DatePicker datePickerDatas;

	@FXML
	private Button botaoAgendarConsulta;

	@FXML
	private Label labelMensagem;

	@FXML
	public void initialize() {
		consultaService.initialize(comboBoxMedicosDisponiveis, datePickerDatas);
	}

	public boolean medicoDisponivel(String nomeMedico, java.sql.Date dataEscolhida) {
		boolean sucesso = consultaService.medicoDisponivel(nomeMedico, dataEscolhida);

		if (sucesso == true) {
			return true;
		} else {
			return false;
		}
	}

	public boolean cliqueBotaoAgendamento() {
		boolean sucesso = consultaService.cliqueBotaoAgendamento(comboBoxMedicosDisponiveis, datePickerDatas);

		if (sucesso == true) {
			labelMensagem.setText("Agendamento realizado com sucesso!");
			return true;
		} else {
			labelMensagem.setText("Falha ao agendar consulta. Tente novamente.");
			return false;
		}
	}
}