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

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

	private int codEstudiante;
	private String dni;
	private String nomEstudiante;
	private String telefonoEstudiante;
	private List<Estancia> estancias = new ArrayList<Estancia>();

	public Estudiante() {
	}

	public Estudiante(int codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	public Estudiante(int codEstudiante, String dni, String nomEstudiante, String telefonoEstudiante,
			List<Estancia> estancias) {
		this.codEstudiante = codEstudiante;
		this.dni = dni;
		this.nomEstudiante = nomEstudiante;
		this.telefonoEstudiante = telefonoEstudiante;
		this.estancias = estancias;
	}

	@Id
	@Column(name = "codEstudiante", unique = true, nullable = false)
	public int getCodEstudiante() {
		return this.codEstudiante;
	}

	public void setCodEstudiante(int codEstudiante) {
		this.codEstudiante = codEstudiante;
	}

	@Column(name = "dni", length = 9)
	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Column(name = "nomEstudiante", length = 50)
	public String getNomEstudiante() {
		return this.nomEstudiante;
	}

	public void setNomEstudiante(String nomEstudiante) {
		this.nomEstudiante = nomEstudiante;
	}

	@Column(name = "telefonoEstudiante", length = 9)
	public String getTelefonoEstudiante() {
		return this.telefonoEstudiante;
	}

	public void setTelefonoEstudiante(String telefonoEstudiante) {
		this.telefonoEstudiante = telefonoEstudiante;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiantes", cascade = CascadeType.ALL)
	public List<Estancia> getEstancias() {
		return this.estancias;
	}

	public void setEstancias(List<Estancia> estancias) {
		this.estancias = estancias;
	}

	@Override
	public String toString() {
		return getNomEstudiante();
	}
	
	

}