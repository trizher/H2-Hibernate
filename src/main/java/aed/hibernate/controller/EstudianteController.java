package aed.hibernate.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import aed.hibernate.bbdd.HibernateConsulta;
import aed.hibernate.bean.EstanciaBean;
import aed.hibernate.bean.EstudianteBean;
import aed.hibernate.entity.Estancia;
import aed.hibernate.entity.Estudiante;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

public class EstudianteController implements Initializable{
	
    @FXML
    private VBox estudianteVBox;

    @FXML
    private TableView<EstudianteBean> estudianteTable;

    @FXML
    private TableColumn<EstudianteBean, Number> codEstudianteColumn;

    @FXML
    private TableColumn<EstudianteBean, String> dniColumn;

    @FXML
    private TableColumn<EstudianteBean, String> nomEstudianteColumn;

    @FXML
    private TableColumn<EstudianteBean, String> telefonoEstudianteColumn;

    @FXML
    private TextField codEstudianteText;

    @FXML
    private TextField dniText;

    @FXML
    private TextField nomEstudianteText;

    @FXML
    private TextField telefonoEstudianteText;

    @FXML
    private Button agregarButton;

    @FXML
    private Button modificarButton;

	private static ListProperty<EstudianteBean> estudiantesBeanList = new SimpleListProperty<EstudianteBean>(FXCollections.observableArrayList());
	private EstudianteBean estudiante = new EstudianteBean();
	private HibernateConsulta hibernateConsulta = new HibernateConsulta();


  
    public EstudianteController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EstudianteView.fxml"));
		loader.setController(this);
		loader.load();
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estudiantesBeanList = MainController.getEstudiantesBeanList();
		

		estudiantesBeanList.bindBidirectional(estudianteTable.itemsProperty());

		codEstudianteColumn.setCellValueFactory(v -> v.getValue().codEstudianteProperty());
		dniColumn.setCellValueFactory(v -> v.getValue().dniProperty());
		nomEstudianteColumn.setCellValueFactory(v -> v.getValue().nomEstudianteProperty());
		telefonoEstudianteColumn.setCellValueFactory(v -> v.getValue().telefonoEstudianteProperty());
		
		codEstudianteText.textProperty().bindBidirectional(estudiante.codEstudianteProperty(), new NumberStringConverter());
		dniText.textProperty().bindBidirectional(estudiante.dniProperty());
		nomEstudianteText.textProperty().bindBidirectional(estudiante.nomEstudianteProperty());
		telefonoEstudianteText.textProperty().bindBidirectional(estudiante.telefonoEstudianteProperty());

		limpiarCampos();
	}
	
	public VBox getView() {
		return estudianteVBox;
	}

	@FXML
    void onAgregarAction(ActionEvent event) {
		Estudiante est = new Estudiante();
		est.setCodEstudiante(Integer.parseInt(codEstudianteText.getText()));
		est.setDni(dniText.getText());
		est.setNomEstudiante(nomEstudianteText.getText());
		est.setTelefonoEstudiante(telefonoEstudianteText.getText());
		
		hibernateConsulta.aniadirEstudiante(est);
		onActualizarTabla();
		limpiarCampos();
    }

    @FXML
    void onSeleccionarEstudiante(MouseEvent event) {
    	EstudianteBean estudianteSeleccionado = estudianteTable.getSelectionModel().getSelectedItem();
    	if (estudianteSeleccionado != null) {
			estudiante.setCodEstudiante(estudianteSeleccionado.getCodEstudiante());
			estudiante.setDni(estudianteSeleccionado.getDni());
			estudiante.setNomEstudiante(estudianteSeleccionado.getNomEstudiante());
			estudiante.setTelefonoEstudiante(estudianteSeleccionado.getTelefonoEstudiante());
		}
    }
    
    @FXML
    void onLimpiarAction(ActionEvent event) {
    	limpiarCampos();
    }
    
	void onActualizarTabla() {
		List<Estudiante> est = hibernateConsulta.cargarTablaEstudiantes();
		estudiantesBeanList.clear();
		for (Estudiante estud : est) {
			estudiantesBeanList.add(new EstudianteBean(estud));
		}
	}

	void limpiarCampos() {
		codEstudianteText.setText("");
		dniText.setText("");
		nomEstudianteText.setText("");
		telefonoEstudianteText.setText("");

	}


}
