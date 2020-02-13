package aed.hibernate.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import aed.hibernate.bbdd.HibernateConsulta;
import aed.hibernate.bean.ResidenciaBean;
import aed.hibernate.bean.ResidenciaObservacionBean;
import aed.hibernate.entity.Residencia;
import aed.hibernate.entity.ResidenciaObservacion;
import aed.hibernate.entity.Universidad;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.BooleanStringConverter;
import javafx.util.converter.NumberStringConverter;

public class ResidenciaController implements Initializable {

	@FXML
	private VBox residenciaVBox;

	@FXML
	private TableView<ResidenciaBean> residenciaTable;

	@FXML
	private TableColumn<ResidenciaBean, Number> codResidenciaColumn;

	@FXML
	private TableColumn<ResidenciaBean, String> nomResidenciaColumn;

	@FXML
	private TableColumn<ResidenciaBean, String> codUniversidadColumn;

	@FXML
	private TableColumn<ResidenciaBean, Number> precioMensualColumn;

	@FXML
	private TableColumn<ResidenciaBean, String> comedorColumn;

	@FXML
	private TableColumn<ResidenciaBean, String> observacionColumn;

	@FXML
	private TextField codResidenciaText;

	@FXML
	private TextField nomResidenciaText;

	@FXML
	private TextField codUniversidadText;

	@FXML
	private TextField precioMensualText;

	@FXML
	private TextField comedorText;

	@FXML
	private TextArea observacionArea;

	@FXML
	private Button agregarButton;

	@FXML
	private Button modificarButton;

	@FXML
	private Button eliminarButton;

	@FXML
	private Button verMasButton;

	@FXML
	private Button limpiarButton;

	private ListProperty<ResidenciaBean> residenciasBeanList = new SimpleListProperty<ResidenciaBean>(FXCollections.observableArrayList());
	private ResidenciaBean residencia = new ResidenciaBean();
	private HibernateConsulta hibernateConsulta = new HibernateConsulta();

	public ResidenciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ResidenciaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		residenciasBeanList = MainController.getResidenciasBeanList();

		residenciasBeanList.bindBidirectional(residenciaTable.itemsProperty());

		codResidenciaColumn.setCellValueFactory(v -> v.getValue().codResidenciaProperty());
		nomResidenciaColumn.setCellValueFactory(v -> v.getValue().nomResidenciaProperty());
		codUniversidadColumn.setCellValueFactory(v -> v.getValue().codUniversidadProperty());
		precioMensualColumn.setCellValueFactory(v -> v.getValue().precioMensualProperty());
		comedorColumn.setCellValueFactory(v -> v.getValue().comedorProperty());
		// observacionColumn.setCellValueFactory(v ->
		// v.getValue().residenciasObservacionesProperty());
		observacionColumn.setCellValueFactory(v -> v.getValue().residenciasObservacionesProperty());

		codResidenciaText.textProperty().bindBidirectional(residencia.codResidenciaProperty(),
				new NumberStringConverter());
		nomResidenciaText.textProperty().bindBidirectional(residencia.nomResidenciaProperty());
		codUniversidadText.textProperty().bindBidirectional(residencia.codUniversidadProperty());
		precioMensualText.textProperty().bindBidirectional(residencia.precioMensualProperty(),
				new NumberStringConverter());
		comedorText.textProperty().bindBidirectional(residencia.comedorProperty());
		observacionArea.textProperty().bindBidirectional(residencia.residenciasObservacionesProperty());
		limpiarCampos();
	}

	public VBox getView() {
		return residenciaVBox;
	}

	@FXML
	void onAgregarAction(ActionEvent event) {
		Residencia res = new Residencia();
		res.setNomResidencia(nomResidenciaText.getText());
		res.setUniversidades(new Universidad(codUniversidadText.getText()));
		res.setPrecioMensual(Short.parseShort(precioMensualText.getText()));
		boolean comedor = false;
		if (comedorText.getText().equals("1") || comedorText.getText().equals("true")) {
			comedor = true;
		}
		res.setComedor(comedor);
		
		if (observacionArea.getLength() > 1) {
			hibernateConsulta.aniadirResidenciaConObservacion(res, new ResidenciaObservacion(res.getCodResidencia(), observacionArea.getText()));
		} else {
			hibernateConsulta.aniadirResidencia(res);
		}


		onActualizarTabla();
		limpiarCampos();
	}

	@FXML
	void onEliminarAction(ActionEvent event) {
		ResidenciaBean residenciaSeleccionada = residenciaTable.getSelectionModel().getSelectedItem();
		hibernateConsulta.eliminarResidencia(residenciaSeleccionada.getResidencia());
		onActualizarTabla();
		limpiarCampos();
	}

	@FXML
	void onModificarAction(ActionEvent event) {
		ResidenciaBean residenciaSeleccionada = residenciaTable.getSelectionModel().getSelectedItem();
		residenciaSeleccionada.getResidencia().setCodResidencia(Integer.parseInt(codResidenciaText.getText()));
		residenciaSeleccionada.getResidencia().setNomResidencia(nomResidenciaText.getText());
		residenciaSeleccionada.getResidencia().setUniversidades(new Universidad(codUniversidadText.getText()));
		residenciaSeleccionada.getResidencia().setPrecioMensual(Short.parseShort(precioMensualText.getText()));
		boolean comedor = false;
		if (comedorText.getText().equals("1") || comedorText.getText().equals("true")) {
			comedor = true;
		}
		residenciaSeleccionada.getResidencia().setComedor(comedor);

		if (observacionArea.getLength() > 0) {
			if (residenciaSeleccionada.getResidencia().getResidenciasobservaciones() != null) {
				residenciaSeleccionada.getResidencia().getResidenciasobservaciones().setObservacion(observacionArea.getText());
				hibernateConsulta.modificarResidenciaObservacion(residenciaSeleccionada.getResidencia(), residenciaSeleccionada.getResidencia().getResidenciasobservaciones());
			} else if (residenciaSeleccionada.getResidencia().getResidenciasobservaciones() == null) {
				ResidenciaObservacion residenciaObservacion = new ResidenciaObservacion(observacionArea.getText());
				residenciaSeleccionada.getResidencia().setResidenciasobservaciones(residenciaObservacion);
				residenciaObservacion.setResidencias(residenciaSeleccionada.getResidencia());
				hibernateConsulta.modificarResidenciaObservacion(residenciaSeleccionada.getResidencia(), residenciaObservacion);
			}
		} else if (observacionArea.getLength() < 1 && residenciaSeleccionada.getResidencia().getResidenciasobservaciones() != null) {
			hibernateConsulta.eliminarResidenciaObservacion(residenciaSeleccionada.getResidencia(), residenciaSeleccionada.getResidencia().getResidenciasobservaciones());
		} else if (observacionArea.getLength() < 1 && residenciaSeleccionada.getResidencia().getResidenciasobservaciones() == null) {
			hibernateConsulta.modificarResidencia(residenciaSeleccionada.getResidencia());
		}

		onActualizarTabla();
		limpiarCampos();
	}

	@FXML
	void onResidenciaSelected(MouseEvent event) {
		ResidenciaBean residenciaSeleccionada = residenciaTable.getSelectionModel().getSelectedItem();
		System.out.println(residenciaSeleccionada);
		if (residenciaSeleccionada != null) {
			residencia.setCodResidencia(residenciaSeleccionada.getCodResidencia());
			residencia.setCodUniversidad(residenciaSeleccionada.getCodUniversidad());
			residencia.setNomResidencia(residenciaSeleccionada.getNomResidencia());
			residencia.setComedor(residenciaSeleccionada.getComedor());
			residencia.setPrecioMensual(residenciaSeleccionada.getPrecioMensual());
			residencia.setResidenciasObservaciones(residenciaSeleccionada.getResidenciasObservaciones());
		}
	}

	@FXML
	void onLimpiarAction(ActionEvent event) {
		limpiarCampos();
	}
	
    @FXML
    void onVerMasAction(ActionEvent event) {

		if (!residenciaTable.getSelectionModel().isEmpty()) {
			ResidenciaBean residencia = residenciaTable.getSelectionModel().getSelectedItem();
			try {
				VerMasDialogController dialog = new VerMasDialogController();
				dialog.cargarResidencia(residencia.getResidencia());
				dialog.showAndWait();
			} catch (IOException e) {
				e.printStackTrace();
//				Alert alert = new Alert(AlertType.WARNING);
//				alert.setTitle("No se ha podido cargar la vista \"DatosResidencias\"");
//				alert.setHeaderText("No se ha podido cargar la vista \"DatosResidencias\"");
//				alert.showAndWait();
			}
		} else {
//			Alert alert = new Alert(AlertType.WARNING);
//			alert.setTitle("Debes seleccionar una residencia");
//			alert.setHeaderText("Debes seleccionar una residencia");
//			alert.showAndWait();
		}
    	
    }

	void onActualizarTabla() {
		List<Residencia> residencia = hibernateConsulta.cargarTablaResidencias();
		residenciasBeanList.clear();
		for (Residencia resid : residencia) {
			residenciasBeanList.add(new ResidenciaBean(resid));
		}
	}

	void limpiarCampos() {
		codResidenciaText.setText("");
		nomResidenciaText.setText("");
		codUniversidadText.setText("");
		precioMensualText.setText("");
		comedorText.setText("");
		observacionArea.setText("");

	}

}
