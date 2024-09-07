package guiControllers;

import DAO.ConsultaDAO;
import Service.ConsultaService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class EscolherConsultaRealizarController {

	private ConsultaService consultaService;

	public EscolherConsultaRealizarController() {
		this.consultaService = new ConsultaService();
	}

	@FXML
	private ChoiceBox<String> choiceBoxConsultas;

	@FXML
	private Button botaoEscolha;

	@FXML
	public void initialize() {
		consultaService.initializeEscolherConsultaRealizar(choiceBoxConsultas);
	}

	public void cliqueBotaoEscolha() {
		String consultaEscolhida = choiceBoxConsultas.getSelectionModel().getSelectedItem();
		String[] parts = consultaEscolhida.split(" - ");

		if (parts.length == 2) {
			String cpf = parts[0].replace("CPF do paciente: ", "");
			String data = parts[1];
			System.out.println("CPF: " + cpf);
			System.out.println("Data: " + data);

			ConsultaDAO.cpfPacienteDaConsulta = cpf;
		}

		System.out.println(ConsultaDAO.idConsultaEscolhida);
		System.out.println(ConsultaDAO.cpfPacienteDaConsulta);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/guiFXML/RealizarConsulta.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Realização de consulta");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}