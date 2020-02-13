package aed.hibernate.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import aed.hibernate.entity.Estancia;
import aed.hibernate.entity.Residencia;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class VerMasDialogController extends Dialog implements Initializable  {
	
	@FXML
	private VBox view;
	@FXML
	private TextArea verMasArea;

	Residencia residencia;

	public VerMasDialogController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/VerMasDialogView.fxml"));
		loader.setController(this);
		Node view = loader.load();
		
		setTitle("Datos Residencia");
		getDialogPane().setContent(view);
		
		getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
		Node closeButton = getDialogPane().lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);
	}

	public void cargarResidencia(Residencia r) {
		residencia = r;
		String data = "Datos Residencia\n\n";
		data += "Código: " + residencia.getCodResidencia() + "\n";
		data += "Nombre: " + residencia.getNomResidencia() + "\n";
		data += "Precio mensual: " + residencia.getPrecioMensual() + "\n";
		data += "Comedor: " + residencia.getComedor() + "\n";
		if(residencia.getResidenciasobservaciones() != null) { 
			data += "Observaciones: " + residencia.getResidenciasobservaciones().getObservacion() + "\n\n";
		} else {
			data += "Observaciones: \n\n";
		}
		data += "Universidad:" + "\n";
		data += "\tCódigo: " + residencia.getUniversidades().getCodUniversidad() + "\n";
		data += "\tNombre: " + residencia.getUniversidades().getNomUniversidad() + "\n\n";
		data += "Estancias:" + "\n";
		for (Estancia estancia : residencia.getEstancias()) {
			data += "\tCódigo: " + estancia.getCodEstancia() + "\n";
			data += "\tFecha inicio: " + estancia.getFechaInicio() + "\n";
			data += "\tFecha fin: " + estancia.getFechaFin() + "\n";
			data += "\tEstudiante:" + "\n";
			data += "\t\tCódigo: " + estancia.getEstudiantes().getCodEstudiante() + "\n";
			data += "\t\tNombre: " + estancia.getEstudiantes().getNomEstudiante() + "\n";
			data += "\t\tDNI: " + estancia.getEstudiantes().getDni() + "\n";
			data += "\t\tTeléfono: " + estancia.getEstudiantes().getTelefonoEstudiante() + "\n\n";
		}
		verMasArea.setText(data);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
