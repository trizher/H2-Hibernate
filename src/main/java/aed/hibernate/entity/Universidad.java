package aed.hibernate.entity;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Universidades 
 */
@Entity
@Table(name = "universidades")
public class Universidad implements Serializable {

	private String codUniversidad;
	private String nomUniversidad;
	private List<Residencia> residencias = new ArrayList<Residencia>();

	public Universidad() {
	}

	public Universidad(String codUniversidad) {
		this.codUniversidad = codUniversidad;
	}
	
	public Universidad(String codUniversidad, String nomUniversidad) {
		this.codUniversidad = codUniversidad;
		this.nomUniversidad = nomUniversidad;
	}

	public Universidad(String codUniversidad, String nomUniversidad, List<Residencia> residencias) {
		this.codUniversidad = codUniversidad;
		this.nomUniversidad = nomUniversidad;
		this.residencias = residencias;
	}

	@Id
	@Column(name = "codUniversidad", unique = true, nullable = false, length = 6)
	public String getCodUniversidad() {
		return this.codUniversidad;
	}

	public void setCodUniversidad(String codUniversidad) {
		this.codUniversidad = codUniversidad;
	}

	@Column(name = "nomUniversidad", length = 30)
	public String getNomUniversidad() {
		return this.nomUniversidad;
	}

	public void setNomUniversidad(String nomUniversidad) {
		this.nomUniversidad = nomUniversidad;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "universidades", cascade = {CascadeType.ALL})
	public List<Residencia> getResidencias() {
		return this.residencias;
	}

	public void setResidencias(List<Residencia> residencias) {
		this.residencias = residencias;
	}

	@Override
	public String toString() {
		return nomUniversidad;
	}
	


}
