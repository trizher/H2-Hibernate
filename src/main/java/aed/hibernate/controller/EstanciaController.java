package aed.hibernate.controller;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import aed.hibernate.bbdd.HibernateConsulta;
import aed.hibernate.bean.EstanciaBean;
import aed.hibernate.entity.Estancia;
import aed.hibernate.entity.Estudiante;
import aed.hibernate.entity.Residencia;
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

public class EstanciaController implements Initializable {

	@FXML
	private VBox estanciaVBox;

	@FXML
	private TableView<EstanciaBean> estanciaTable;

	@FXML
	private TableColumn<EstanciaBean, Number> codEstanciaColumn;

	@FXML
	private TableColumn<EstanciaBean, Number> codEstudianteColumn;

	@FXML
	private TableColumn<EstanciaBean, Number> codResidenciaColumn;

	@FXML
	private TableColumn<EstanciaBean, String> fechaInicioColumn;

	@FXML
	private TableColumn<EstanciaBean, String> fechaFinColumn;

	@FXML
	private TableColumn<EstanciaBean, Number> precioPagadoColumn;

	@FXML
	private TextField codEstanciaText;

	@FXML
	private TextField codEstudianteText;

	@FXML
	private TextField codResidenciaText;

	@FXML
	private TextField fechaInicioText;

	@FXML
	private TextField fechaFinText;

	@FXML
	private TextField precioPagadoText;

	@FXML
	private Button agregarButton;

	@FXML
	private Button modificarButton;

	@FXML
	private Button eliminarButton;

	private ListProperty<EstanciaBean> estanciasBeanList = new SimpleListProperty<EstanciaBean>(
			FXCollections.observableArrayList());
	private EstanciaBean estancia = new EstanciaBean();
	private HibernateConsulta hibernateConsulta = new HibernateConsulta();

	public EstanciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EstanciaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estanciasBeanList = MainController.getEstanciasBeanList();

		estanciasBeanList.bindBidirectional(estanciaTable.itemsProperty());

		codEstanciaColumn.setCellValueFactory(v -> v.getValue().codEstanciaProperty());
		codEstudianteColumn.setCellValueFactory(v -> v.getValue().estudianteProperty());
		codResidenciaColumn.setCellValueFactory(v -> v.getValue().residenciasProperty());
		fechaInicioColumn.setCellValueFactory(v -> v.getValue().fechaInicioProperty());
		fechaFinColumn.setCellValueFactory(v -> v.getValue().fechaFinProperty());
		precioPagadoColumn.setCellValueFactory(v -> v.getValue().precioPagadoProperty());

		codEstanciaText.textProperty().bindBidirectional(estancia.codEstanciaProperty(), new NumberStringConverter());
		codEstudianteText.textProperty().bindBidirectional(estancia.estudianteProperty(), new NumberStringConverter());
		codResidenciaText.textProperty().bindBidirectional(estancia.residenciasProperty(), new NumberStringConverter());
		fechaInicioText.textProperty().bindBidirectional(estancia.fechaInicioProperty());
		fechaFinText.textProperty().bindBidirectional(estancia.fechaFinProperty());
		precioPagadoText.textProperty().bindBidirectional(estancia.precioPagadoProperty(), new NumberStringConverter());

		limpiarCampos();
	}

	public VBox getView() {
		return estanciaVBox;
	}

	@FXML
	void onAgregarAction(ActionEvent event) {
		Estancia est = new Estancia();
		est.setEstudiantes(new Estudiante(Integer.parseInt(codEstudianteText.getText())));
		est.setResidencias(new Residencia(Integer.parseInt(codResidenciaText.getText())));
		est.setFechaInicio(parsearFecha(fechaInicioText.getText()));
		est.setFechaFin(parsearFecha(fechaFinText.getText()));
		est.setPrecioPagado(Short.parseShort(precioPagadoText.getText()));

		hibernateConsulta.aniadirEstancia(est);
		onActualizarTabla();
		limpiarCampos();

	}

	@FXML
	void onEliminarAction(ActionEvent event) {
		EstanciaBean estanciaSeleccionada = estanciaTable.getSelectionModel().getSelectedItem();
		hibernateConsulta.eliminarEstancia(estanciaSeleccionada.getEstancia());
		onActualizarTabla();
		limpiarCampos();
	}

	@FXML
	void onModificarAction(ActionEvent event) {
		EstanciaBean estanciaSeleccionada = estanciaTable.getSelectionModel().getSelectedItem();
		estanciaSeleccionada.getEstancia().setCodEstancia(Integer.parseInt(codEstanciaText.getText()));
		estanciaSeleccionada.getEstancia().setEstudiantes(new Estudiante(Integer.parseInt(codEstudianteText.getText())));
		estanciaSeleccionada.getEstancia().setResidencias(new Residencia(Integer.parseInt(codResidenciaText.getText())));
		estanciaSeleccionada.getEstancia().setFechaInicio(parsearFecha(fechaInicioText.getText()));
		estanciaSeleccionada.getEstancia().setFechaFin(parsearFecha(fechaFinText.getText()));
		estanciaSeleccionada.getEstancia().setPrecioPagado(Short.parseShort(precioPagadoText.getText()));
		
		hibernateConsulta.modificarEstancia(estanciaSeleccionada.getEstancia());
		onActualizarTabla();
		limpiarCampos();
	}

	@FXML
	void onSeleccionarEstancia(MouseEvent event) {
		EstanciaBean estanciaSeleccionada = estanciaTable.getSelectionModel().getSelectedItem();
		System.out.println(estanciaSeleccionada);
		if (estanciaSeleccionada != null) {
			estancia.setCodEstancia(estanciaSeleccionada.getCodEstancia());
			estancia.setEstudiante(estanciaSeleccionada.getEstudiante());
			estancia.setResidencias(estanciaSeleccionada.getResidencias());
			estancia.setFechaFin(estanciaSeleccionada.getFechaFin());
			estancia.setFechaInicio(estanciaSeleccionada.getFechaInicio());
			estancia.setPrecioPagado(estanciaSeleccionada.getPrecioPagado());
		}
	}
	
    @FXML
    void onLimpiarAction(ActionEvent event) {
    	limpiarCampos();
    }

	void onActualizarTabla() {
		List<Estancia> est = hibernateConsulta.cargarTablaEstancias();
		estanciasBeanList.clear();
		for (Estancia estan : est) {
			estanciasBeanList.add(new EstanciaBean(estan));
		}
	}

	void limpiarCampos() {
		codEstanciaText.setText("");
		codEstudianteText.setText("");
		codResidenciaText.setText("");
		fechaInicioText.setText("");
		fechaFinText.setText("");
		precioPagadoText.setText("");

	}

	private Date parsearFecha(String date) {
		String startDateString = date;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = null;
		try {
			startDate = df.parse(startDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return new java.sql.Date(startDate.getTime());
	}

}
