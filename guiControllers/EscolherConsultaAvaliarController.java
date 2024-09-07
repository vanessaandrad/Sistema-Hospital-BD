package guiControllers;

import Service.ConsultaService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class EscolherConsultaAvaliarController {

	private ConsultaService consultaService;

	public EscolherConsultaAvaliarController() {
		this.consultaService = new ConsultaService();
	}

	@FXML
	private ChoiceBox<String> choiceBoxConsultas;

	@FXML
	private Button botaoEscolha;

	public static int idConsultaEscolhida;

	private String StringIdConsultaEscolhida;;

	@FXML
	public void initialize() {
		consultaService.initializeEscolherConsultaAvaliar(choiceBoxConsultas);
	}

	public void cliqueBotaoEscolha() {
		// aqui não iremos colocar para o consultaDAO, pois não estamos acessando os
		// dados

		String consultaEscolhida = choiceBoxConsultas.getValue();
		String[] parte = consultaEscolhida.split(": ");

		if (parte.length >= 2) {
			String[] partes = parte[1].split(" ");
			if (partes.length > 0) {
				StringIdConsultaEscolhida = partes[0];
			}
		}
		idConsultaEscolhida = Integer.parseInt(StringIdConsultaEscolhida);
		System.out.println("CONSULTA FOI ESCOLHIDA C SUCESSO");
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/guiFXML/AvaliarMedico.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Avaliação do médico");

			Scene scene = new Scene(root);
			stage.setScene(scene);

			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}