package br.com.condominio.application.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.condominio.DB.Persistencia;
import br.com.condominio.condominioPO.CondominioPO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CondominioManagerMenuPrincipalController implements Initializable {
	Persistencia pt = new Persistencia();
	
	@FXML
	private TextField unidadesTextField;

	@FXML
	private Button editarButton;

	@FXML
	private Button salvarButton;

	@FXML
	private TextField idTextField;

	@FXML
	private PasswordField senhaTextField;

	@FXML
	private TextField cnpjPesquisaField;

	@FXML
	private TextField nomeTexteField;

	@FXML
	private Pane infoCondominioFrame;

	@FXML
	private TextField cnpjTextField;

	@FXML
	private VBox menuFuncionalidades;

	@FXML
	private Button excluirButton;
	@FXML
	private Button pesquisar;
	@FXML
	private TextField enderecoTexteField;

	@FXML
	private Button incluirButton;

	@FXML
	private Pane loginFrame;

	@FXML
	private Pane tabelaCondominiosFrame;

	@FXML
	private Button cancelarButton;

	@FXML
	private TextField LoginTextField;

	@FXML
	private TextField subSindicoTextField;

	@FXML
	private TextArea conselhoFiscalTextArea;

	@FXML
	private Pane initialFrame;

	@FXML
	private TextField sindicoTextField;

	@FXML
	void editarButton(ActionEvent event) {
		habilitarPesquisa(false);
		habilitarCamposCondominio(true);
		habilitarBotoesCrud(false);
		salvarButton.setText("Editar");
		habilitarBotoesSalvarCancelar(true);

	}

	@FXML
	void excluirButton(ActionEvent event) {
		habilitarPesquisa(false);

	}

	@FXML
	void salvarButton(ActionEvent event) {
		if (salvarButton.getText() == "Salvar") {
			pt.Save(criarCondominio());
			canclelarButton(null);

		} else if (salvarButton.getText() == "Editar") {

			canclelarButton(null);
		} else {

		}
	}

	@FXML
	void canclelarButton(ActionEvent event) {
		habilitarCamposCondominio(false);
		habilitarBotoesCrud(true);
		salvarButton.setText("Salvar");
		habilitarBotoesSalvarCancelar(false);
		habilitarPesquisa(true);
	}

	@FXML
	void incluitButton(ActionEvent event) {
		salvarButton.setText("Salvar");
		habilitarPesquisa(false);
		habilitarCamposCondominio(true);
		habilitarBotoesCrud(false);
		habilitarBotoesSalvarCancelar(true);
		apagarCampos();

	}

	@FXML
	void login(ActionEvent event) {
		setFrame(false, loginFrame);
		setFrame(true, initialFrame);
	}

	@FXML
	void pesquisar(ActionEvent event) {
		setarCondominio();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setFrame(true, loginFrame);

	}

	private void setFrame(boolean ative, Pane frame) {
		if (ative) {
			frame.setOpacity(1);
			frame.setVisible(ative);
		} else {
			frame.setOpacity(1);
			frame.setVisible(ative);

		}
	}

	private void habilitarCamposCondominio(boolean ative) {
		cnpjTextField.setEditable(ative);
		nomeTexteField.setEditable(ative);
		enderecoTexteField.setEditable(ative);
		sindicoTextField.setEditable(ative);
		subSindicoTextField.setEditable(ative);
		unidadesTextField.setEditable(ative);
		conselhoFiscalTextArea.setEditable(ative);
	}

	private void habilitarBotoesCrud(boolean ative) {
		incluirButton.setVisible(ative);
		excluirButton.setVisible(ative);
		editarButton.setVisible(ative);
	}

	private void habilitarBotoesSalvarCancelar(boolean ative) {
		salvarButton.setVisible(ative);
		cancelarButton.setVisible(ative);
	}

	private void setarCondominio() {
		CondominioPO s = new CondominioPO();
		
		s = (CondominioPO) pt.GetObj(s, Long.parseLong(idTextField.getText()));
		idTextField.setText(String.valueOf(s.getId()));
		cnpjTextField.setText(s.getCnpj());
		nomeTexteField.setText(s.getNome());
		enderecoTexteField.setText(s.getEndereco());
		sindicoTextField.setText(s.getSindico());
		subSindicoTextField.setText(s.getSubsindico());
		unidadesTextField.setText(String.valueOf(s.getUnidades()));
		conselhoFiscalTextArea.setText(s.getConselheirofiscal());

	}

	private CondominioPO criarCondominio() {
		CondominioPO s = new CondominioPO();
		s.setCnpj(cnpjTextField.getText());
		s.setConselheirofiscal(conselhoFiscalTextArea.getText());
		s.setEndereco(enderecoTexteField.getText());
		s.setNome(nomeTexteField.getText());
		s.setSindico(sindicoTextField.getText());
		s.setSubsindico(subSindicoTextField.getText());
		s.setUnidades(Integer.parseInt(unidadesTextField.getText()));
		return s;
	}

	private void apagarCampos() {
		idTextField.setText("");
		cnpjTextField.setText("");
		nomeTexteField.setText("");
		enderecoTexteField.setText("");
		sindicoTextField.setText("");
		subSindicoTextField.setText("");
		unidadesTextField.setText("");
		conselhoFiscalTextArea.setText("");
	}

	private void habilitarPesquisa(boolean ative) {
		cnpjPesquisaField.setVisible(ative);
		idTextField.setVisible(ative);
	}

}
