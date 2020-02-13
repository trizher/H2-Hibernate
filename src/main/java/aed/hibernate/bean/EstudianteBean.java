package aed.hibernate.bean;

import aed.hibernate.entity.Estudiante;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EstudianteBean {
	private IntegerProperty codEstudiante = new SimpleIntegerProperty();
	private StringProperty dni = new SimpleStringProperty();
	private StringProperty nomEstudiante = new SimpleStringProperty();
	private StringProperty telefonoEstudiante = new SimpleStringProperty();
	//private ListProperty<EstanciaBean> estancias = new SimpleListProperty<EstanciaBean>();
	
	Estudiante estudiante = new Estudiante();
	
	public EstudianteBean() {
		// TODO Auto-generated constructor stub
	}
	
	public EstudianteBean(Estudiante estudiante) {
		this.codEstudiante.set(estudiante.getCodEstudiante());
		this.dni.set(estudiante.getDni());
		this.nomEstudiante.set(estudiante.getNomEstudiante());
		this.telefonoEstudiante.set(estudiante.getTelefonoEstudiante());
		this.estudiante = estudiante;
	}
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public IntegerProperty codEstudianteProperty() {
		return this.codEstudiante;
	}
	
	public int getCodEstudiante() {
		return this.codEstudianteProperty().get();
	}
	
	public void setCodEstudiante(final int codEstudiante) {
		this.codEstudianteProperty().set(codEstudiante);
	}
	
	public StringProperty dniProperty() {
		return this.dni;
	}
	
	public String getDni() {
		return this.dniProperty().get();
	}
	
	public void setDni(final String dni) {
		this.dniProperty().set(dni);
	}
	
	public StringProperty nomEstudianteProperty() {
		return this.nomEstudiante;
	}
	
	public String getNomEstudiante() {
		return this.nomEstudianteProperty().get();
	}
	
	public void setNomEstudiante(final String nomEstudiante) {
		this.nomEstudianteProperty().set(nomEstudiante);
	}
	
	public StringProperty telefonoEstudianteProperty() {
		return this.telefonoEstudiante;
	}
	
	public String getTelefonoEstudiante() {
		return this.telefonoEstudianteProperty().get();
	}
	
	public void setTelefonoEstudiante(final String telefonoEstudiante) {
		this.telefonoEstudianteProperty().set(telefonoEstudiante);
	}
	
//	public ListProperty<EstanciaBean> estanciasProperty() {
//		return this.estancias;
//	}
//	
//	public ObservableList<EstanciaBean> getEstancias() {
//		return this.estanciasProperty().get();
//	}
//	
//	public void setEstancias(final ObservableList<EstanciaBean> estancias) {
//		this.estanciasProperty().set(estancias);
//	}
	
	
	
}
