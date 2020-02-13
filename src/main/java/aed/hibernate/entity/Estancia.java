package aed.hibernate.entity;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "estancias")
public class Estancia implements Serializable {

	private int codEstancia;
	private Estudiante estudiantes;
	private Residencia residencias;
	private Date fechaInicio;
	private Date fechaFin;
	private Short precioPagado;

	public Estancia() {
	}

	public Estancia(int codEstancia) {
		this.codEstancia = codEstancia;
	}

	public Estancia(int codEstancia, Estudiante estudiante, Residencia residencia, Date fechaInicio, Date fechaFin,
			Short precioPagado) {
		this.codEstancia = codEstancia;
		this.estudiantes = estudiante;
		this.residencias = residencia;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioPagado = precioPagado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codEstancia", unique = true, nullable = false)
	public int getCodEstancia() {
		return this.codEstancia;
	}

	public void setCodEstancia(int codEstancia) {
		this.codEstancia = codEstancia;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codEstudiante")
	public Estudiante getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(Estudiante estudiantes) {
		this.estudiantes = estudiantes;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codResidencia")
	public Residencia getResidencias() {
		return this.residencias;
	}

	public void setResidencias(Residencia residencia) {
		this.residencias = residencia;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaInicio", length = 10)
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fechaFin", length = 10)
	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Column(name = "precioPagado")
	public Short getPrecioPagado() {
		return this.precioPagado;
	}

	public void setPrecioPagado(Short precioPagado) {
		this.precioPagado = precioPagado;
	}

	@Override
	public String toString() {
		return "codEstancia=" + codEstancia + ", estudiantes=" + estudiantes + ", residencias=" + residencias
				+ ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", precioPagado=" + precioPagado;
	}
	
	

}
