package guiControllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Service.MedicoService;
import gui.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.entities.Consulta;

public class GerarRelatorioMedicoController {

	private MedicoService medicoService;

	public GerarRelatorioMedicoController() {
		this.medicoService = new MedicoService();
	}

	@FXML
	private ChoiceBox<String> choiceBoxEscolha;

	@FXML
	private Button botaoGerarRelatorio;

	@FXML
	private DatePicker datePickerInicio;

	@FXML
	private DatePicker datePickerFinal;

	@FXML
	private TableView<Consulta> tableViewRelatorio;

	@FXML
	private TableColumn<Consulta, Integer> colunaID;

	@FXML
	private TableColumn<Consulta, String> colunaCPF;

	@FXML
	private TableColumn<Consulta, Date> ColunaData;

	ObservableList<Consulta> lista = FXCollections.observableArrayList();

	@FXML
	public void initialize() {
		List<String> opcoes = new ArrayList<>();
		opcoes.add("Consultas");
		opcoes.add("Agendamentos");
		choiceBoxEscolha.getItems().addAll(opcoes);

		colunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		ColunaData.setCellValueFactory(new PropertyValueFactory<>("data"));

		tableViewRelatorio.setItems(lista);
	}

	@FXML
	public void cliqueBotaoGerarRelatorio() {
		lista.clear();
		LocalDate periodoInicio = datePickerInicio.getValue();
		LocalDate periodoFinal = datePickerFinal.getValue();
		Date inicio = java.sql.Date.valueOf(periodoInicio);
		Date fim = java.sql.Date.valueOf(periodoFinal);

		if (choiceBoxEscolha.getValue().equals("Consultas")) {
			medicoService.cliqueBotaoGerarRelatorioConsultasRealizadas(inicio, fim, lista, tableViewRelatorio);
		} else if (choiceBoxEscolha.getValue().equals("Agendamentos")) {
			medicoService.cliqueBotaoGerarRelatorioAgendamentos(inicio, fim, lista, tableViewRelatorio);
		} else if (choiceBoxEscolha.getValue().equals(null)) {
			Alerts.showAlert("ERRO!", "Selecione uma opção válida", "Tente novamente!", AlertType.ERROR);
		}
	}
}