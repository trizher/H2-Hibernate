package aed.hibernate.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "residencias")
public class Residencia implements Serializable{
	private int codResidencia;
	private String nomResidencia;
	private Universidad universidad;
	private Short precioMensual;
	private boolean comedor;
	private ResidenciaObservacion residenciasOservaciones;
	private List<Estancia> estancias = new ArrayList<Estancia>();

	public Residencia() {
		// TODO Auto-generated constructor stub
	}
	
	public Residencia(int codResidencia) {
		this.codResidencia = codResidencia;
	}
	
	public Residencia(int codResidencia, String nomResidencia, Universidad codUniversidad, Short precioMensual, boolean comedor,
			ResidenciaObservacion residenciaObservacion, List<Estancia> estancias) {
		this.codResidencia = codResidencia;
		this.nomResidencia = nomResidencia;
		this.universidad = codUniversidad;
		this.precioMensual = precioMensual;
		this.comedor = comedor;
		if(residenciaObservacion != null) {
			this.residenciasOservaciones = residenciaObservacion;
		}
		this.estancias = estancias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "codResidencia", unique = true, nullable = false)
	public int getCodResidencia() {
		return codResidencia;
	}

	public void setCodResidencia(int codResidencia) {
		this.codResidencia = codResidencia;
	}

	@Column(name = "nomResidencia", length = 30)
	public String getNomResidencia() {
		return nomResidencia;
	}

	public void setNomResidencia(String nomResidencia) {
		this.nomResidencia = nomResidencia;
	}

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH} )
	@JoinColumn(name = "codUniversidad")
	public Universidad getUniversidades() {
		return universidad;
	}

	public void setUniversidades(Universidad codUniversidad) {
		this.universidad = codUniversidad;
	}

	@Column(name = "precioMensual")
	public Short getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(Short precioMensual) {
		this.precioMensual = precioMensual;
	}

	@Column(name = "comedor")
	public boolean getComedor() {
		return comedor;
	}

	public void setComedor(boolean comedor) {
		this.comedor = comedor;
	}
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "residencias", cascade = CascadeType.ALL)
	public ResidenciaObservacion getResidenciasobservaciones() {
		return this.residenciasOservaciones;
	}

	public void setResidenciasobservaciones(ResidenciaObservacion residenciasobservaciones) {
		this.residenciasOservaciones = residenciasobservaciones;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "residencias", cascade = CascadeType.ALL)
	public List<Estancia> getEstancias() {
		return this.estancias;
	}

	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}
	
	@Override
	public String toString() {
		return "" + this.codResidencia + " " + this.nomResidencia + " " + this.universidad.getCodUniversidad();
	}
}
