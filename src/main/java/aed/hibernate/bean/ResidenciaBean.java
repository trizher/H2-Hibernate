package aed.hibernate.bean;

import aed.hibernate.entity.Residencia;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class ResidenciaBean {

	private IntegerProperty codResidencia = new SimpleIntegerProperty();
	private StringProperty nomResidencia = new SimpleStringProperty();
	//private ObjectProperty<UniversidadBean> codUniversidad =new SimpleObjectProperty<UniversidadBean>();
	private StringProperty codUniversidad = new SimpleStringProperty();

	private IntegerProperty precioMensual = new SimpleIntegerProperty();
	//private BooleanProperty comedor = new SimpleBooleanProperty();
	private StringProperty comedor = new SimpleStringProperty();

	//private ObjectProperty<ResidenciaObservacionBean> residenciasObservaciones = new SimpleObjectProperty<ResidenciaObservacionBean>();
	private StringProperty residenciasObservaciones = new SimpleStringProperty();
	
	private ListProperty<EstanciaBean> estancias = new SimpleListProperty<EstanciaBean>();	
	
	private Residencia residencia = new Residencia();
	
	public ResidenciaBean() {
		// TODO Auto-generated constructor stub
	}

	
	public ResidenciaBean(Residencia residencia) {
		codResidencia.set(residencia.getCodResidencia());
		nomResidencia.set(residencia.getNomResidencia());
		//codUniversidad.set(new UniversidadBean(residencia.getUniversidades()));
		codUniversidad.set(residencia.getUniversidades().getCodUniversidad());
		precioMensual.set(residencia.getPrecioMensual());
		comedor.set(residencia.getComedor()? "true" : "false");
		//this.residenciasObservaciones.set(new ResidenciaObservacionBean(residencia.getResidenciasobservaciones()));
		if(residencia.getResidenciasobservaciones() != null) {
			this.residenciasObservaciones.set(residencia.getResidenciasobservaciones().getObservacion());
		} else {
			this.residenciasObservaciones.set("");
		}
		this.residencia = residencia;
		
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
	
	public StringProperty nomResidenciaProperty() {
		return this.nomResidencia;
	}
	
	public String getNomResidencia() {
		return this.nomResidenciaProperty().get();
	}
	
	public void setNomResidencia(final String nomResidencia) {
		this.nomResidenciaProperty().set(nomResidencia);
	}
	
	public IntegerProperty precioMensualProperty() {
		return this.precioMensual;
	}
	
	public int getPrecioMensual() {
		return this.precioMensualProperty().get();
	}
	
	public void setPrecioMensual(final int precioMensual) {
		this.precioMensualProperty().set(precioMensual);
	}
	
//	public BooleanProperty comedorProperty() {
//		return this.comedor;
//	}
//	
//	public boolean isComedor() {
//		return this.comedorProperty().get();
//	}
//	
//	public void setComedor(final boolean comedor) {
//		this.comedorProperty().set(comedor);
//	}
	
	
	
//	public ObjectProperty<ResidenciaObservacionBean> residenciasObservacionesProperty() {
//		return this.residenciasObservaciones;
//	}
//	
//	public ResidenciaObservacionBean getResidenciasObservaciones() {
//		return this.residenciasObservacionesProperty().get();
//	}
//	
//	public void setResidenciasObservaciones(final ResidenciaObservacionBean residenciasObservaciones) {
//		this.residenciasObservacionesProperty().set(residenciasObservaciones);
//	}
	
	public StringProperty residenciasObservacionesProperty() {
		return this.residenciasObservaciones;
	}
	


	public String getResidenciasObservaciones() {
		return this.residenciasObservacionesProperty().get();
	}
	

	public void setResidenciasObservaciones(final String residenciasObservaciones) {
		this.residenciasObservacionesProperty().set(residenciasObservaciones);
	}
	
	
	public StringProperty comedorProperty() {
		return this.comedor;
	}
	


	public String getComedor() {
		return this.comedorProperty().get();
	}
	


	public void setComedor(final String comedor) {
		this.comedorProperty().set(comedor);
	}
	
	
	
	public ListProperty<EstanciaBean> estanciasProperty() {
		return this.estancias;
	}
	
	public ObservableList<EstanciaBean> getEstancias() {
		return this.estanciasProperty().get();
	}
	
	public void setEstancias(final ObservableList<EstanciaBean> estancias) {
		this.estanciasProperty().set(estancias);
	}

//	public ObjectProperty<UniversidadBean> codUniversidadProperty() {
//		return this.codUniversidad;
//	}
//	
//
//	public UniversidadBean getCodUniversidad() {
//		return this.codUniversidadProperty().get();
//	}
//	
//
//	public void setCodUniversidad(final UniversidadBean codUniversidad) {
//		this.codUniversidadProperty().set(codUniversidad);
//	}
//	
	
	public StringProperty codUniversidadProperty() {
		return this.codUniversidad;
	}
	

	public String getCodUniversidad() {
		return this.codUniversidadProperty().get();
	}
	

	public void setCodUniversidad(final String codUniversidad) {
		this.codUniversidadProperty().set(codUniversidad);
	}
	
	

	
	public Residencia getResidencia() {
		return residencia;
	}

	public void setResidencia(Residencia residencia) {
		this.residencia = residencia;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "" + getCodResidencia() + " " + getNomResidencia() + " " + getCodUniversidad();
	}







	
	
	
	
}
