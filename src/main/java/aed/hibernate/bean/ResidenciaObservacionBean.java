package aed.hibernate.bean;

import aed.hibernate.entity.ResidenciaObservacion;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ResidenciaObservacionBean {

	private IntegerProperty codResidencia = new SimpleIntegerProperty();
	private StringProperty observacion = new SimpleStringProperty();

	public ResidenciaObservacionBean(ResidenciaObservacion residenciaObservacion) {
		if (residenciaObservacion != null) {
			codResidencia.set(residenciaObservacion.getCodResidencia());
			observacion.set(residenciaObservacion.getObservacion());
		} else {
			codResidencia.set(999);
			observacion.set(" ");
		}

	}

	public IntegerProperty codResidenciaProperty() {
		return this.codResidencia;
	}

	public int getCodResidencia() {
		return this.codResidenciaProperty().get();
	}

	public void setCodResidencia(final int codResidencia) {
		this.codResidenciaProperty().set(codResidencia);
	}

	public StringProperty observacionProperty() {
		return this.observacion;
	}

	public String getObservacion() {
		return this.observacionProperty().get();
	}

	public void setObservacion(final String observacion) {
		this.observacionProperty().set(observacion);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getObservacion();
	}

}
