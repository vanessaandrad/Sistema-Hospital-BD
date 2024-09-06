package guiControllers;

import Service.ConsultaService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class AvaliarMedicoController {
	
	private ConsultaService consultaService;

	public AvaliarMedicoController() {
		this.consultaService = new ConsultaService();
	}
	
	@FXML
	private Label labelPessimo;

	@FXML
	private Label labelRuim;

	@FXML
	private Label labelRegular;

	@FXML
	private Label labelBom;

	@FXML
	private Label labelMuitoBom;

	@FXML
	private Label labelPerfeito;

	@FXML
	private Button buttonPessimo;

	@FXML
	private Button buttonRuim;

	@FXML
	private Button buttonRegular;

	@FXML
	private Button buttonBom;

	@FXML
	private Button buttonMuitoBom;

	@FXML
	private Button buttonPerfeito;

	@FXML
	private TextArea textAreaTextoAvaliacao;

	@FXML
	private Button botaoEnviarAvaliacao;

	@FXML
	private Label labelMensagem;

	private static double estrelas;

	public void mousePessimo() {
		labelPessimo.setText("PÉSSIMO");
	}

	public void mouseRuim() {
		labelRuim.setText("RUIM");
	}

	public void mouseRegular() {
		labelRegular.setText("REGULAR");
	}

	public void mouseBom() {
		labelBom.setText("BOM");
	}

	public void mouseMuitoBom() {
		labelMuitoBom.setText("MUITO BOM");
	}

	public void mousePerfeito() {
		labelPerfeito.setText("PERFEITO");
	}

	public void limparLabel() {
		labelPessimo.setText("");
		labelRuim.setText("");
		labelRegular.setText("");
		labelBom.setText("");
		labelMuitoBom.setText("");
		labelPerfeito.setText("");
	}

	public void setarEstrelasParaZero() {
		estrelas = 0;
	}

	public void setarEstrelasParaUm() {
		estrelas = 1;
	}

	public void setarEstrelasParaDois() {
		estrelas = 2;
	}

	public void setarEstrelasParaTres() {
		estrelas = 3;
	}

	public void setarEstrelasParaQuatro() {
		estrelas = 4;
	}

	public void setarEstrelasParaCinco() {
		estrelas = 5;
	}

	public void realizarAvaliacao() {
		String textoAvaliacao = textAreaTextoAvaliacao.getText();
		
		boolean sucesso = consultaService.avaliarConsulta(textoAvaliacao, estrelas);
		if(sucesso == true) {
			textAreaTextoAvaliacao.setText("");
			labelMensagem.setText("Avaliação enviada com sucesso! Obrigado :)");
		}else {
			textAreaTextoAvaliacao.setText("");
			labelMensagem.setText("Faha ao realizar avaliação. Tente novamente :(");
		}
	}
}