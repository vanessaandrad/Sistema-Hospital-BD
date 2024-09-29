package Service;

import java.sql.Date;
import java.time.LocalDate;

import DAO.PacienteDAO;
import javafx.collections.ObservableList;
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

	public boolean cadastrarPaciente(String nome, LocalDate data_nascimento, String senha, String cpf, String plano) {
		return pacienteDAO.realizarCadastroPaciente(nome, data_nascimento, senha, cpf, plano);
	}

	public boolean fazerLogin(String cpf, String senha) {
		return pacienteDAO.fazerLogin(cpf, senha);
	}

	public void editarDado(String campoSelecionado, String dadoNovo, LocalDate data_nascimento_nova) {
		pacienteDAO.editarDado(campoSelecionado, dadoNovo, data_nascimento_nova);
	}

	public void cliqueBotaoGerarRelatorioConsultasRealizadas(Date inicio, Date fim, ObservableList<Consulta> lista,
			TableView<Consulta> tableViewRelatorio) {
		pacienteDAO.cliqueBotaoGerarRelatorioConsultasRealizadas(inicio, fim, lista, tableViewRelatorio);
	}

	public void cliqueBotaoGerarRelatorioAgendamentos(Date inicio, Date fim, ObservableList<Consulta> lista,
			TableView<Consulta> tableViewRelatorio) {
		pacienteDAO.cliqueBotaoGerarRelatorioAgendamentos(inicio, fim, lista, tableViewRelatorio);
	}
	/*
	 * public void procurarMedicos(String dado, ListView<String> listViewResultados,
	 * ChoiceBox<String> choiceBoxEscolha) { pacienteDAO.procurarMedicos(dado,
	 * listViewResultados, choiceBoxEscolha); }
	 */
}