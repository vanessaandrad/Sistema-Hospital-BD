package Service;

import java.sql.Date;

import DAO.MedicoDAO;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import model.entities.Consulta;

public class MedicoService {
	private MedicoDAO medicoDAO;

	public MedicoService() {
		this.medicoDAO = new MedicoDAO();
	}

	public boolean verificarCrmExiste(String crmDigitado) {
		return medicoDAO.verificarCrmExiste(crmDigitado);
	}

	public boolean realizarCadastroMedico(String nome, String especialidade, String planoAtendido, String senha,
			String crm) {
		return medicoDAO.realizarCadastroMedico(nome, especialidade, planoAtendido, senha, crm);
	}

	public boolean fazerLogin(String crm, String senha) {
		return medicoDAO.fazerLogin(crm, senha);
	}

	public void editarDado(String campoSelecionado, String dadoNovo) {
		medicoDAO.editarDado(campoSelecionado, dadoNovo);
	}

	public void cliqueBotaoGerarRelatorioConsultasRealizadas(Date inicio, Date fim, ObservableList<Consulta> lista,
			TableView<Consulta> tableViewRelatorio) {
		medicoDAO.cliqueBotaoGerarRelatorioConsultasRealizadas(inicio, fim, lista, tableViewRelatorio);
	}

	public void cliqueBotaoGerarRelatorioAgendamentos(Date inicio, Date fim, ObservableList<Consulta> lista,
			TableView<Consulta> tableViewRelatorio) {
		medicoDAO.cliqueBotaoGerarRelatorioAgendamentos(inicio, fim, lista, tableViewRelatorio);
	}
}