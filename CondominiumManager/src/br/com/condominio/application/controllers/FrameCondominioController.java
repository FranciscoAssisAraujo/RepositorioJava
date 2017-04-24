package br.com.condominio.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.condominio.application.Main;
import br.com.condominio.application.paths.Path;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FrameCondominioController implements Initializable {
	public static Stage stage;
	public static Stage controlStage;

	@FXML
	private TextField idTextField;

	@FXML
	private TextField nomeTexteField;

	@FXML
	private TextField cnpjTextField;

	@FXML
	private TextField subSindicoTextField;

	@FXML
	private TextArea conselhoFiscalTextArea;

	@FXML
	private TextField enderecoTexteField;

	@FXML
	private TextField sindicoTextField;

	public static void iniciarTela() throws Exception {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Path.frameCondominio));
		AnchorPane layout = loader.load();
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		stage.centerOnScreen();
		FrameCondominioController.stage = stage;

	}

	public static void getTela(Stage cstage) throws Exception {
		iniciarTela();

		stage.show();
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(final WindowEvent arg0) {
				MenuPrincipalController.stage.setOpacity(1);

			}
		});

		controlStage = cstage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
