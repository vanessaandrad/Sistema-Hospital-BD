package Service;

import DAO.ConsultaDAO;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
	
	public void initializeEscolherConsultaAvaliar(ChoiceBox<String> choiceBoxConsultas) {
		consultaDAO.initializeEscolherConsultaAvaliar(choiceBoxConsultas);
	}
	
	public void initializeEscolherConsultaRealizar(ChoiceBox<String> choiceBoxConsultasRealizar) {
		consultaDAO.initializeEscolherConsultaRealizar(choiceBoxConsultasRealizar);
	}
	
	public void initializeRealizarConsulta(TextField textFieldPreco) {
		consultaDAO.initializeRealizarConsulta(textFieldPreco);
	}
	
	public boolean cliqueBotaoFinalizarConsulta(TextField textFieldPreco, String sintomas, String tratamento,
			String medicamentos, String exames) {
		return consultaDAO.cliqueBotaoFinalizarConsulta(textFieldPreco, sintomas, tratamento, medicamentos, exames);
	}
}