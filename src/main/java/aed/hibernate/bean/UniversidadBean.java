package aed.hibernate.bean;

import aed.hibernate.entity.Universidad;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UniversidadBean {

	private StringProperty codUniversidad = new SimpleStringProperty();
	private StringProperty nomUniversidad = new SimpleStringProperty();
	
	public UniversidadBean() {
		// TODO Auto-generated constructor stub
	}
	
	public UniversidadBean(Universidad universidad) {
		codUniversidad.set(universidad.getCodUniversidad());
		nomUniversidad.set(universidad.getNomUniversidad());
	}
	
	public StringProperty codUniversidadProperty() {
		return this.codUniversidad;
	}
	
	public String getCodUniversidad() {
		return this.codUniversidadProperty().get();
	}
	
	public void setCodUniversidad(final String codUniversidad) {
		this.codUniversidadProperty().set(codUniversidad);
	}
	
	public StringProperty nomUniversidadProperty() {
		return this.nomUniversidad;
	}
	
	public String getNomUniversidad() {
		return this.nomUniversidadProperty().get();
	}
	
	public void setNomUniversidad(final String nomUniversidad) {
		this.nomUniversidadProperty().set(nomUniversidad);
	}
	
	
}
