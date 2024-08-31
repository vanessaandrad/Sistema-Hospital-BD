package Service;

import DAO.ConsultaDAO;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ConsultaService {
	private ConsultaDAO consultaDAO;

	public ConsultaService() {
		this.consultaDAO = new ConsultaDAO();
	}

	public void initialize(ComboBox<String> comboBoxMedicosDisponiveis, DatePicker datePickerDatas) {
		consultaDAO.initialize(comboBoxMedicosDisponiveis, datePickerDatas);
	}

	public boolean medicoDisponivel(String nomeMedico, java.sql.Date dataEscolhida) {
		return consultaDAO.medicoDisponivel(nomeMedico, dataEscolhida);
	}

	public boolean cliqueBotaoAgendamento(ComboBox<String> comboBoxMedicosDisponiveis, DatePicker datePickerDatas) {
		return consultaDAO.cliqueBotaoAgendamento(comboBoxMedicosDisponiveis, datePickerDatas);
	}
}