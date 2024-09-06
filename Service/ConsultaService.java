package Service;

import DAO.ConsultaDAO;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class ConsultaService {
	private ConsultaDAO consultaDAO;

	public ConsultaService() {
		this.consultaDAO = new ConsultaDAO();
	}

	public void initializeAgendarConsulta(ComboBox<String> comboBoxMedicosDisponiveis, DatePicker datePickerDatas) {
		consultaDAO.initializeAgendarConsulta(comboBoxMedicosDisponiveis, datePickerDatas);
	}

	public boolean medicoDisponivel(String nomeMedico, java.sql.Date dataEscolhida) {
		return consultaDAO.medicoDisponivel(nomeMedico, dataEscolhida);
	}

	public boolean cliqueBotaoAgendamento(ComboBox<String> comboBoxMedicosDisponiveis, DatePicker datePickerDatas) {
		return consultaDAO.cliqueBotaoAgendamento(comboBoxMedicosDisponiveis, datePickerDatas);
	}

	public boolean avaliarConsulta(String textoAvaliacao, double estrelas) {
		return consultaDAO.avaliarConsulta(textoAvaliacao, estrelas);
	}

	public void initializeCancelarConsulta(ComboBox<String> comboBoxConsultasMarcadas) {
		consultaDAO.initializeCancelarConsulta(comboBoxConsultasMarcadas);
	}

	public String obterCrmMedico(int numeroConsulta) {
		return consultaDAO.obterCrmMedico(numeroConsulta);
	}

	public void cliqueBotaoCancelar(ComboBox<String> comboBoxConsultasMarcadas) {
		consultaDAO.cliqueBotaoCancelar(comboBoxConsultasMarcadas);
	}
}