package aed.hibernate.bean;

import java.util.Date;

import aed.hibernate.entity.Estancia;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class EstanciaBean {

	private IntegerProperty codEstancia = new SimpleIntegerProperty();
	// private ObjectProperty<EstudianteBean> estudiante = new
	// SimpleObjectProperty<EstudianteBean>();
	// private ObjectProperty<ResidenciaBean> residencias = new
	// SimpleObjectProperty<ResidenciaBean>();
	private IntegerProperty residencias = new SimpleIntegerProperty();
	private IntegerProperty estudiante = new SimpleIntegerProperty();

//	private ObjectProperty<Date> fechaInicio = new SimpleObjectProperty<Date>();
	private StringProperty fechaInicio = new SimpleStringProperty();
//	private ObjectProperty<Date> fechaFin = new SimpleObjectProperty<Date>();
	private StringProperty fechaFin = new SimpleStringProperty();

	private IntegerProperty precioPagado = new SimpleIntegerProperty();

	private ListProperty<EstudianteBean> listEstudiante = new SimpleListProperty<EstudianteBean>();

	private Estancia estancia = new Estancia();

	public EstanciaBean() {
		// TODO Auto-generated constructor stub
	}

	public EstanciaBean(Estancia estancia) {
		this.codEstancia.set(estancia.getCodEstancia());
		if (estancia.getFechaInicio() == null) {
			this.fechaInicio.set("2020-01-28");
		} else {
			this.fechaInicio.set(estancia.getFechaInicio().toString());
		}

		if (estancia.getFechaFin() == null) {
			this.fechaFin.set("2020-01-28");
		} else {
			this.fechaFin.set(estancia.getFechaFin().toString());
		}
		

		this.precioPagado.set(estancia.getPrecioPagado());
		this.estudiante.set(estancia.getEstudiantes().getCodEstudiante());

		this.residencias.set(estancia.getResidencias().getCodResidencia());
		this.estancia = estancia;
	}

	public IntegerProperty codEstanciaProperty() {
		return this.codEstancia;
	}

	public int getCodEstancia() {
		return this.codEstanciaProperty().get();
	}

	public void setCodEstancia(final int codEstancia) {
		this.codEstanciaProperty().set(codEstancia);
	}

//	public ObjectProperty<Date> fechaInicioProperty() {
//		return this.fechaInicio;
//	}
//
//	public Date getFechaInicio() {
//		return this.fechaInicioProperty().get();
//	}
//
//	public void setFechaInicio(final Date fechaInicio) {
//		this.fechaInicioProperty().set(fechaInicio);
//	}

//	public ObjectProperty<Date> fechaFinProperty() {
//		return this.fechaFin;
//	}
//
//	public Date getFechaFin() {
//		return this.fechaFinProperty().get();
//	}
//
//	public void setFechaFin(final Date fechaFin) {
//		this.fechaFinProperty().set(fechaFin);
//	}

	public ListProperty<EstudianteBean> listEstudianteProperty() {
		return this.listEstudiante;
	}

	public ObservableList<EstudianteBean> getListEstudiante() {
		return this.listEstudianteProperty().get();
	}

	public void setListEstudiante(final ObservableList<EstudianteBean> listEstudiante) {
		this.listEstudianteProperty().set(listEstudiante);
	}

	public IntegerProperty precioPagadoProperty() {
		return this.precioPagado;
	}

	public int getPrecioPagado() {
		return this.precioPagadoProperty().get();
	}

	public void setPrecioPagado(final int precioPagado) {
		this.precioPagadoProperty().set(precioPagado);
	}

	public IntegerProperty residenciasProperty() {
		return this.residencias;
	}

	public int getResidencias() {
		return this.residenciasProperty().get();
	}

	public void setResidencias(final int residencias) {
		this.residenciasProperty().set(residencias);
	}

	public IntegerProperty estudianteProperty() {
		return this.estudiante;
	}

	public int getEstudiante() {
		return this.estudianteProperty().get();
	}

	public void setEstudiante(final int estudiante) {
		this.estudianteProperty().set(estudiante);
	}

	public StringProperty fechaInicioProperty() {
		return this.fechaInicio;
	}

	public String getFechaInicio() {
		return this.fechaInicioProperty().get();
	}

	public void setFechaInicio(final String fechaInicio) {
		this.fechaInicioProperty().set(fechaInicio);
	}

	public StringProperty fechaFinProperty() {
		return this.fechaFin;
	}

	public String getFechaFin() {
		return this.fechaFinProperty().get();
	}

	public void setFechaFin(final String fechaFin) {
		this.fechaFinProperty().set(fechaFin);
	}

	public Estancia getEstancia() {
		return estancia;
	}

	public void setEstancia(Estancia estancia) {
		this.estancia = estancia;
	}

	public void setResidencias(IntegerProperty residencias) {
		this.residencias = residencias;
	}

//	public ObjectProperty<EstudianteBean> estudianteProperty() {
//		return this.estudiante;
//	}
//
//	public EstudianteBean getEstudiante() {
//		return this.estudianteProperty().get();
//	}
//
//	public void setEstudiante(final EstudianteBean estudiante) {
//		this.estudianteProperty().set(estudiante);
//	}
//
//	public ObjectProperty<ResidenciaBean> residenciasProperty() {
//		return this.residencias;
//	}
//
//	public ResidenciaBean getResidencias() {
//		return this.residenciasProperty().get();
//	}
//
//	public void setResidencias(final ResidenciaBean residencias) {
//		this.residenciasProperty().set(residencias);
//	}

}
