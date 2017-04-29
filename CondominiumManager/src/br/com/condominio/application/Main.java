package br.com.condominio.application;

import br.com.condominio.application.controllers.FrameMenuPrincipalController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FrameMenuPrincipalController.getTela();
		
	}

	public static void main(String[] args) {
		launch(args);

	}
}
