package aed.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "residenciasobservaciones")
public class ResidenciaObservacion {

	private int codResidencia;
	private Residencia residencia;
	private String observacion;

	public ResidenciaObservacion() {
	}

	public ResidenciaObservacion(String observacion) {
		this.observacion = observacion;
	}

	public ResidenciaObservacion(Residencia residencia) {
		this.residencia = residencia;
	}

	public ResidenciaObservacion(int codResidencia, String observacion) {
		this.codResidencia = codResidencia;
		this.observacion = observacion;
	}

	@Id
	@GeneratedValue(generator = "ResidenciasObservacionesIdGenerator")
	@GenericGenerator(name = "ResidenciasObservacionesIdGenerator", strategy = "foreign", parameters = @Parameter(name = "property", value = "residencias"))
	@Column(name = "codResidencia", unique = true, nullable = false)
	public int getCodResidencia() {
		return this.codResidencia;
	}

	public void setCodResidencia(int codResidencia) {
		this.codResidencia = codResidencia;
	}

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "codResidencia")
	public Residencia getResidencias() {
		return this.residencia;
	}

	public void setResidencias(Residencia residencia) {
		this.residencia = residencia;
	}

	@Column(name = "observaciones", length = 200)
	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}
