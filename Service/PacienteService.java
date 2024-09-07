package Service;

import java.sql.Date;

import DAO.PacienteDAO;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import model.entities.Consulta;

public class PacienteService {
	private PacienteDAO pacienteDAO;

	public PacienteService() {
		this.pacienteDAO = new PacienteDAO();
	}

	public boolean verificarCpfExiste(String cpf) {
		return pacienteDAO.cpfExiste(cpf);
	}

	public boolean cadastrarPaciente(String nome, String idade, String senha, String cpf, String plano) {
		return pacienteDAO.realizarCadastroPaciente(nome, idade, senha, cpf, plano);
	}

	public boolean fazerLogin(String cpf, String senha) {
		return pacienteDAO.fazerLogin(cpf, senha);
	}

	public void editarDado(String campoSelecionado, String dadoNovo) {
		pacienteDAO.editarDado(campoSelecionado, dadoNovo);
	}

	public void cliqueBotaoGerarRelatorioConsultasRealizadas(Date inicio, Date fim, ObservableList<Consulta> lista,
			TableView<Consulta> tableViewRelatorio) {
		pacienteDAO.cliqueBotaoGerarRelatorioConsultasRealizadas(inicio, fim, lista, tableViewRelatorio);
	}

	public void cliqueBotaoGerarRelatorioAgendamentos(Date inicio, Date fim, ObservableList<Consulta> lista,
			TableView<Consulta> tableViewRelatorio) {
		pacienteDAO.cliqueBotaoGerarRelatorioAgendamentos(inicio, fim, lista, tableViewRelatorio);
	}
	
	public void procurarMedicos(String dado, ListView<String> listViewResultados, ChoiceBox<String> choiceBoxEscolha) {
		pacienteDAO.procurarMedicos(dado, listViewResultados, choiceBoxEscolha);
	}
}