package br.com.condominio.application.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.persistence.Id;

import br.com.condominio.DB.Persistencia;
import br.com.condominio.application.Main;
import br.com.condominio.application.paths.Path;
import br.com.condominio.condominioPO.CondominioPO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class FrameCondominioController implements Initializable {
	public static Stage stage;
	Persistencia pt = new Persistencia();
	@FXML
	private TextField idTextField;

	@FXML
	private TextField nomeTexteField;
	@FXML
	private TextField unidadesTextField;
	@FXML
	private Button pesquisarCondominio;
	@FXML
	private TextField cnpjTextField;

	@FXML
	private Menu incluirMenu;

	@FXML
	private TextField enderecoTexteField;

	@FXML
	private Menu editarMenu;

	@FXML
	private Button buttonCancelar;

	@FXML
	private Button buttonSalvar;

	@FXML
	private TextField subSindicoTextField;

	@FXML
	private TextArea conselhoFiscalTextArea;

	@FXML
	private MenuItem incluirMenuItem;

	@FXML
	private MenuItem editarMenuItem;

	@FXML
	private TextField sindicoTextField;

	@FXML
	void incluir(ActionEvent event) {

		habilitarCampos(true);
		botoesSalvarCancelar(true);

	}

	@FXML
	void editar(ActionEvent event) {
		botoesSalvarCancelar(true);
		idTextField.setEditable(true);
		cnpjTextField.setEditable(true);
		pesquisarCondominio.setVisible(true);

	}

	private void habilitarCampos(boolean on) {
		nomeTexteField.setEditable(on);
		enderecoTexteField.setEditable(on);
		cnpjTextField.setEditable(on);
		sindicoTextField.setEditable(on);
		subSindicoTextField.setEditable(on);
		conselhoFiscalTextArea.setEditable(on);
	}

	private CondominioPO setCondominio(CondominioPO cond) {
		cond.setCnpj(cnpjTextField.getText());
		cond.setConselheirofiscal(conselhoFiscalTextArea.getText());
		cond.setEndereco(enderecoTexteField.getText());
		cond.setNome(nomeTexteField.getText());
		cond.setSindico(sindicoTextField.getText());
		cond.setSubsindico(subSindicoTextField.getText());
		cond.setUnidades(Integer.parseInt(unidadesTextField.getText()));
		return cond;
	}

	private void botoesSalvarCancelar(boolean on) {
		buttonCancelar.setVisible(on);
		buttonSalvar.setVisible(on);
	}

	private void setarCampos(CondominioPO s) {
		idTextField.setText(String.valueOf(s.getId()));
		cnpjTextField.setText(s.getCnpj());
		nomeTexteField.setText(s.getNome());
		enderecoTexteField.setText(s.getEndereco());
		subSindicoTextField.setText(s.getSubsindico());
		sindicoTextField.setText(s.getSindico());
		unidadesTextField.setText(String.valueOf(s.getUnidades()));
		conselhoFiscalTextArea.setText(s.getConselheirofiscal());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		buttonSalvar.setVisible(false);
		buttonCancelar.setVisible(false);
		pesquisarCondominio.setVisible(false);
	}

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

	public static void getTela() throws Exception {
		iniciarTela();

		stage.show();

		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(final WindowEvent arg0) {
				FrameMenuPrincipalController.stage.setOpacity(1);

			}
		});

	}

}
