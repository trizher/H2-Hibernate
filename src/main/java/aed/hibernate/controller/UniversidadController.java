package aed.hibernate.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.Session;

import aed.hibernate.bbdd.HibernateConsulta;
import aed.hibernate.bbdd.HibernateUtil;
import aed.hibernate.bean.EstudianteBean;
import aed.hibernate.bean.UniversidadBean;
import aed.hibernate.entity.Estudiante;
import aed.hibernate.entity.Universidad;
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

public class UniversidadController implements Initializable{
	
	@FXML
    private VBox universidadVBox;

    @FXML
    private TableView<UniversidadBean> universidadTable;

    @FXML
    private TableColumn<UniversidadBean, String> codUniversidadColumn;

    @FXML
    private TableColumn<UniversidadBean, String> nomUniversidadColumn;

    @FXML
    private TextField codUniversidadText;

    @FXML
    private TextField nomUniversidadText;

    @FXML
    private Button agregarButton;

	private static ListProperty<UniversidadBean> universidadesBeanList = new SimpleListProperty<UniversidadBean>(FXCollections.observableArrayList());
	private HibernateConsulta hibernateConsulta = new HibernateConsulta();
	private UniversidadBean universidad = new UniversidadBean();
  
    public UniversidadController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UniversidadView.fxml"));
		loader.setController(this);
		loader.load();
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		universidadesBeanList = MainController.getUniversidadesBeanList();
		

		universidadesBeanList.bindBidirectional(universidadTable.itemsProperty());

		codUniversidadColumn.setCellValueFactory(v -> v.getValue().codUniversidadProperty());
		nomUniversidadColumn.setCellValueFactory(v -> v.getValue().nomUniversidadProperty());
	
		codUniversidadText.textProperty().bindBidirectional(universidad.codUniversidadProperty());
		nomUniversidadText.textProperty().bindBidirectional(universidad.nomUniversidadProperty());
		
		limpiarCampos();
	}
	
	public VBox getView() {
		return universidadVBox;
	}
	
	@FXML
    void onAgregarAction(ActionEvent event) {
		Universidad uni = new Universidad();
		
		uni.setCodUniversidad(codUniversidadText.getText());
		uni.setNomUniversidad(nomUniversidadText.getText());
		
		hibernateConsulta.aniadirUniversidad(uni);
		onActualizarTabla();
		limpiarCampos();
    }


    @FXML
    void onSeleccionarUniversidad(MouseEvent event) {
    	UniversidadBean universidadSeleccionada = universidadTable.getSelectionModel().getSelectedItem();
    	if(universidadSeleccionada != null) {
    		universidad.setCodUniversidad(universidadSeleccionada.getCodUniversidad());
    		universidad.setNomUniversidad(universidadSeleccionada.getNomUniversidad());
    	}

    }
    
    @FXML
    void onLimpiarAction(ActionEvent event) {
    	limpiarCampos();
    }
    
	void onActualizarTabla() {
		List<Universidad> uni = hibernateConsulta.cargarTablaUniversidades();
		universidadesBeanList.clear();
		for (Universidad univ : uni) {
			universidadesBeanList.add(new UniversidadBean(univ));
		}
	}

	void limpiarCampos() {
		codUniversidadText.setText("");
		nomUniversidadText.setText("");

	}
}
