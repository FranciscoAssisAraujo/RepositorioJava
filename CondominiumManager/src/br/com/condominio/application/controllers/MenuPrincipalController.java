
package br.com.condominio.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.condominio.application.Main;
import br.com.condominio.application.paths.Path;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuPrincipalController implements Initializable {
	public static Stage stage;

	@FXML
	void openFrame(ActionEvent event) throws Exception {
		MenuPrincipalController.stage.setOpacity(0);
		FrameCondominioController.getTela();

	}

	

	public static void inicializarTela() throws Exception {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource(Path.menuPrincipal));
		AnchorPane layout = loader.load();
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		MenuPrincipalController.stage = stage;
	}

	public static void getTela() throws Exception {
		inicializarTela();
		stage.show();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
}
