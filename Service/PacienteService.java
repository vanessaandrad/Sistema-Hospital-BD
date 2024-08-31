package Service;

import DAO.PacienteDAO;

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
}