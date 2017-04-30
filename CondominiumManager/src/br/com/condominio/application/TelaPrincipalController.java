package br.com.condominio.application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.com.condominio.DB.Persistencia;
import br.com.condominio.condominioPO.CondominioPO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable {
	Persistencia pt = new Persistencia();
	static Stage stage;

	@FXML
	private TextField idTextField;

	@FXML
	private ToolBar salvarCancelarTool;

	@FXML
	private Button salvarButton;

	@FXML
	private Button exibirButton;

	@FXML
	private TextField cnpjTextField;

	@FXML
	private VBox menuFuncionalidades;

	@FXML
	private Button contasButton;

	@FXML
	private Button excluirButton;

	@FXML
	private Button incluirButton;

	@FXML
	private Button relatoriosButton;

	@FXML
	private TableView<CondominioPO> tabelaCondominios;
	@FXML
	private TableColumn<?, ?> idColuna;
	@FXML
	private TableColumn<?, ?> cnpjColuna;
	@FXML
	private TableColumn<?, ?> nomeColuna;
	@FXML
	private Button cancelarButton;

	@FXML
	private Button boletosButton;

	@FXML
	private TextField idPesquisaField;

	@FXML
	private ToolBar crudTool;

	@FXML
	private TextField sindicoTextField;

	@FXML
	private Button editarButton;

	@FXML
	private TextField unidadesTextField;

	@FXML
	private PasswordField senhaTextField;

	@FXML
	private TextField cnpjPesquisaField;

	@FXML
	private TextField nomeTexteField;

	@FXML
	private Pane infoCondominioFrame;

	@FXML
	private TextField enderecoTexteField;

	@FXML
	private Pane loginFrame;

	@FXML
	private Pane tabelaCondominioFrame;

	@FXML
	private Button pesquisar;

	@FXML
	private Button CondominosButton;

	@FXML
	private TextField LoginTextField;

	@FXML
	private TextField subSindicoTextField;

	@FXML
	private TextArea conselhoFiscalTextArea;

	@FXML
	void login(ActionEvent event) {
		getFrameLogin(false);
		getFrameInicial(true);
	}

	@FXML
	void salvar(ActionEvent event) {
		if (salvarButton.getText().equals("Incluir")) {
			pt.Save(criarCondominio());
			getFrameIncluir(false);
			getFrameInicial(true);
		} else if (salvarButton.getText().equals("Editar")) {
			CondominioPO s = new CondominioPO();
			s = (CondominioPO) pt.GetObj(s, Long.parseLong(idTextField.getText()));
			pt.Update(editar(s));
			getFrameIncluir(false);
			getFrameInicial(true);
		}
	}

	@FXML
	void cancelar(ActionEvent event) {
		getFrameIncluir(false);
		getFrameInicial(true);
	}

	@FXML
	void editar(ActionEvent event) {
		getEditarCondominio(true);
	}

	@FXML
	void incluir(ActionEvent event) {
		getFrameIncluir(true);
		popularTabela();
	}

	@FXML
	void exibir(ActionEvent event) {

		CondominioPO s = tabelaCondominios.getSelectionModel().getSelectedItem();
		if (s != null) {
			getFrameInicial(false);
			getExibirCondominio(true);

			setarCondominio(s);
		} else {
			Alert erro = erro();
			erro.setContentText("Escolha um condominio na Tabela");
			erro.show();
		}

	}

	@FXML
	void pesquisar(ActionEvent event) {
		boolean encontrou = false;
		ArrayList<CondominioPO> condominios = pt.getlistaCondominios();
		for (CondominioPO condominio : condominios) {
			if (!idPesquisaField.getText().isEmpty()) {
				if (condominio.getId() == Long.parseLong(idPesquisaField.getText())) {
					tabelaCondominios.getSelectionModel().select(condominio);
					encontrou = true;
				}
			} else if (!cnpjPesquisaField.getText().isEmpty()) {
				if (condominio.getCnpj().equals(cnpjPesquisaField.getText())) {
					tabelaCondominios.getSelectionModel().select(condominio);
					encontrou = true;
				}
			}

		}
		if (cnpjPesquisaField.getText().equals("") && idPesquisaField.getText().equals("")) {
			Alert erro = erro();
			erro.setContentText("Digite algo no ID ou no CNPJ");
			erro.show();
		} else {
			Alert erro = erro();
			erro.setContentText("Condominio Não encontrado");
			erro.show();
		}

	}

	@FXML
	void excluir(ActionEvent event) {
		CondominioPO s = tabelaCondominios.getSelectionModel().getSelectedItem();
		pt.Delete(s);
		popularTabela();

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getFrameLogin(true);
	}

	public static void inicializarTela() throws Exception {
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/br/com/condominio/application/TelaPrincipal.fxml"));
		AnchorPane layout = loader.load();
		Scene scene = new Scene(layout);
		stage.setScene(scene);
		TelaPrincipalController.stage = stage;
	}

	public static void getTela() throws Exception {
		inicializarTela();
		stage.show();
	}

	private void setFrame(boolean ative, Pane frame) {
		if (ative) {
			frame.setVisible(ative);
		} else {
			frame.setVisible(ative);
		}
	}

	private void habilitarEditarCamposCondominio(boolean ative) {
		cnpjTextField.setEditable(ative);
		nomeTexteField.setEditable(ative);
		enderecoTexteField.setEditable(ative);
		sindicoTextField.setEditable(ative);
		subSindicoTextField.setEditable(ative);
		unidadesTextField.setEditable(ative);
		conselhoFiscalTextArea.setEditable(ative);
	}

	private void habilitarCamposCondominio(boolean ative) {
		cnpjTextField.setDisable(ative);
		nomeTexteField.setDisable(ative);
		enderecoTexteField.setDisable(ative);
		sindicoTextField.setDisable(ative);
		subSindicoTextField.setDisable(ative);
		unidadesTextField.setDisable(ative);
		conselhoFiscalTextArea.setDisable(ative);
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

	private void setarCondominio(CondominioPO s) {
		idTextField.setText(String.valueOf(s.getId()));
		cnpjTextField.setText(s.getCnpj());
		nomeTexteField.setText(s.getNome());
		enderecoTexteField.setText(s.getEndereco());
		sindicoTextField.setText(s.getSindico());
		subSindicoTextField.setText(s.getSubsindico());
		unidadesTextField.setText(String.valueOf(s.getUnidades()));
		conselhoFiscalTextArea.setText(s.getConselheirofiscal());

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

	private void getFrameIncluir(boolean ative) {
		setFrame(!ative, tabelaCondominioFrame);
		setFrame(ative, infoCondominioFrame);
		editarButton.setVisible(!ative);
		salvarButton.setText("Incluir");
		habilitarCamposCondominio(!ative);
		habilitarEditarCamposCondominio(ative);
		apagarCampos();
	}

	private void getFrameInicial(boolean ative) {
		setFrame(ative, tabelaCondominioFrame);
		setFrame(ative, menuFuncionalidades);
		popularTabela();

	}

	private void getFrameLogin(boolean ative) {
		setFrame(ative, loginFrame);
	}

	private void getExibirCondominio(boolean ative) {
		setFrame(ative, infoCondominioFrame);
		habilitarEditarCamposCondominio(!ative);
		habilitarCamposCondominio(ative);
		salvarButton.setVisible(!ative);
		cancelarButton.setText("Voltar");
	}

	private void getEditarCondominio(boolean ative) {
		setFrame(!ative, tabelaCondominioFrame);
		setFrame(ative, infoCondominioFrame);
		editarButton.setVisible(!ative);
		salvarButton.setText("Editar");
		salvarButton.setVisible(true);
		cancelarButton.setText("Cancelar");
		habilitarCamposCondominio(!ative);
		habilitarEditarCamposCondominio(ative);

	}

	private void popularTabela() {
		ArrayList<CondominioPO> condominios = pt.getlistaCondominios();
		idColuna.setCellValueFactory(new PropertyValueFactory<>("id"));
		cnpjColuna.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
		nomeColuna.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tabelaCondominios.setItems(FXCollections.observableArrayList(condominios));
	}

	private CondominioPO criarCondominio() {

		CondominioPO s = new CondominioPO();
		nomeTexteField.getText();
		cnpjTextField.getText();
		enderecoTexteField.getText();
		sindicoTextField.getText();
		subSindicoTextField.getText();
		unidadesTextField.getText();
		conselhoFiscalTextArea.getText();

		s.setNome(nomeTexteField.getText());
		s.setCnpj(cnpjTextField.getText());
		s.setConselheirofiscal(conselhoFiscalTextArea.getText());
		s.setEndereco(enderecoTexteField.getText());
		s.setSindico(sindicoTextField.getText());
		s.setSubsindico(subSindicoTextField.getText());
		s.setUnidades(Integer.parseInt(unidadesTextField.getText()));

		return s;

	}

	public CondominioPO editar(CondominioPO s) {
		s.setNome(nomeTexteField.getText());
		s.setCnpj(cnpjTextField.getText());
		s.setConselheirofiscal(conselhoFiscalTextArea.getText());
		s.setEndereco(enderecoTexteField.getText());
		s.setSindico(sindicoTextField.getText());
		s.setSubsindico(subSindicoTextField.getText());
		s.setUnidades(Integer.parseInt(unidadesTextField.getText()));

		return s;
	}

	private Alert erro() {
		Alert alerta = new Alert(AlertType.ERROR);
		return alerta;
	}

}
