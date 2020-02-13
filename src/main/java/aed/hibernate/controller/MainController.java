package aed.hibernate.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import aed.hibernate.bbdd.HibernateConsulta;
import aed.hibernate.bean.EstanciaBean;
import aed.hibernate.bean.EstudianteBean;
import aed.hibernate.bean.ResidenciaBean;
import aed.hibernate.bean.ResidenciaObservacionBean;
import aed.hibernate.bean.UniversidadBean;
import aed.hibernate.entity.Estancia;
import aed.hibernate.entity.Estudiante;
import aed.hibernate.entity.Residencia;
import aed.hibernate.entity.ResidenciaObservacion;
import aed.hibernate.entity.Universidad;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainController implements Initializable {

	private EstudianteController estudianteController = new EstudianteController();
	private EstanciaController estanciaController = new EstanciaController();
	private UniversidadController universidadController = new UniversidadController();
	private ResidenciaController residenciaController = new ResidenciaController();
	private static ListProperty<ResidenciaBean> residenciasBeanList = new SimpleListProperty<ResidenciaBean>(
			FXCollections.observableArrayList());
	private static ListProperty<EstanciaBean> estanciasBeanList = new SimpleListProperty<EstanciaBean>(
			FXCollections.observableArrayList());
	private static ListProperty<EstudianteBean> estudiantesBeanList = new SimpleListProperty<EstudianteBean>(
			FXCollections.observableArrayList());
	private static ListProperty<ResidenciaObservacionBean> residenciasObservacionesBeanList = new SimpleListProperty<ResidenciaObservacionBean>(
			FXCollections.observableArrayList());
	private static ListProperty<UniversidadBean> universidadesBeanList = new SimpleListProperty<UniversidadBean>(
			FXCollections.observableArrayList());

	@FXML
	private TabPane view;

	@FXML
	private Tab residenciasTab;

	@FXML
	private Tab estanciasTab;

	@FXML
	private Tab universidadTab;

	@FXML
	private Tab estudiantesTab;

	private HibernateConsulta hibernateConsulta;

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		estudiantesTab.setContent(estudianteController.getView());
		estanciasTab.setContent(estanciaController.getView());
		universidadTab.setContent(universidadController.getView());
		residenciasTab.setContent(residenciaController.getView());

		hibernateConsulta = new HibernateConsulta();
		
		List<Universidad> universidad = hibernateConsulta.cargarTablaUniversidades();
		for (Universidad uni : universidad) {
			universidadesBeanList.add(new UniversidadBean(uni));
		}

		List<ResidenciaObservacion> residenciaObservacion = hibernateConsulta.cargarTablaResidenciasObservaciones();
		for (ResidenciaObservacion residenciaObs : residenciaObservacion) {
			residenciasObservacionesBeanList.add(new ResidenciaObservacionBean(residenciaObs));
		}

		List<Estudiante> estudiante = hibernateConsulta.cargarTablaEstudiantes();
		for (Estudiante estud : estudiante) {
			estudiantesBeanList.add(new EstudianteBean(estud));
		}

		List<Estancia> estancia = hibernateConsulta.cargarTablaEstancias();
		for (Estancia estanc : estancia) {
			estanciasBeanList.add(new EstanciaBean(estanc));
		}

		List<Residencia> residencia = hibernateConsulta.cargarTablaResidencias();
		for (Residencia resid : residencia) {
			residenciasBeanList.add(new ResidenciaBean(resid));
		}

		// HibernateConsulta.setSession(hb.openSession());
//		view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
//			@Override
//			public void changed(ObservableValue<? extends Tab> o, Tab ov, Tab nv) {
//				String pestanhaSeleccionada = view.getSelectionModel().getSelectedItem().getText();
//				if (pestanhaSeleccionada.equals("Residencias")) {
//					// residenciaController.actualizarTabla();
//					System.out.println("buh");
//				} else if (pestanhaSeleccionada.equals("Estancias")) {
//					// hibernateConsulta.actualizarEstancias();
//					System.out.println("buh2");
//				} else if (pestanhaSeleccionada.equals("Universidades")) {
//					// hibernateConsulta.actualizarUniversidades();
//				} else if (pestanhaSeleccionada.equals("Estudiantes")) {
//					// hibernateConsulta.actualizarEstudiantes();
//				}
//			}
//		});
	}

	public TabPane getView() {
		return view;
	}

	public static ListProperty<ResidenciaBean> getResidenciasBeanList() {
		return residenciasBeanList;
	}

	public static void setResidenciasBeanList(ListProperty<ResidenciaBean> residenciasBeanList) {
		MainController.residenciasBeanList = residenciasBeanList;
	}

	public static ListProperty<EstanciaBean> getEstanciasBeanList() {
		return estanciasBeanList;
	}

	public static void setEstanciasBeanList(ListProperty<EstanciaBean> estanciasBeanList) {
		MainController.estanciasBeanList = estanciasBeanList;
	}

	public static ListProperty<EstudianteBean> getEstudiantesBeanList() {
		return estudiantesBeanList;
	}

	public static void setEstudiantesBeanList(ListProperty<EstudianteBean> estudiantesBeanList) {
		MainController.estudiantesBeanList = estudiantesBeanList;
	}

	public static ListProperty<ResidenciaObservacionBean> getResidenciasObservacionesBeanList() {
		return residenciasObservacionesBeanList;
	}

	public static void setResidenciasObservacionesBeanList(
			ListProperty<ResidenciaObservacionBean> residenciasObservacionesBeanList) {
		MainController.residenciasObservacionesBeanList = residenciasObservacionesBeanList;
	}

	public static ListProperty<UniversidadBean> getUniversidadesBeanList() {
		return universidadesBeanList;
	}

	public static void setUniversidadesBeanList(ListProperty<UniversidadBean> universidadesBeanList) {
		MainController.universidadesBeanList = universidadesBeanList;
	}

}
