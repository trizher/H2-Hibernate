package aed.hibernate.bbdd;

import java.util.List;

import org.hibernate.Session;

import aed.hibernate.bean.ResidenciaBean;
import aed.hibernate.entity.Estancia;
import aed.hibernate.entity.Estudiante;
import aed.hibernate.entity.Residencia;
import aed.hibernate.entity.ResidenciaObservacion;
import aed.hibernate.entity.Universidad;

public class HibernateConsulta {

	//private static Session session = HibernateUtil.openSession();
	private static Session session;
	
	public void aniadirEstudiante(Estudiante estudiante) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.saveOrUpdate(estudiante);
		session.getTransaction().commit();
		session.close();
	}

	public void aniadirResidencia(Residencia residencia) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.saveOrUpdate(residencia);
		session.getTransaction().commit();
	}

	public void aniadirResidenciaConObservacion(Residencia residencia, ResidenciaObservacion observacion) {
		openSession();
		session.clear();
		session.beginTransaction();
		residencia.setResidenciasobservaciones(observacion);
		observacion.setResidencias(residencia);
		session.saveOrUpdate(residencia);
		session.saveOrUpdate(observacion);
		session.getTransaction().commit();
		session.close();
	}

	public void aniadirUniversidad(Universidad universidad) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.saveOrUpdate(universidad);
		session.getTransaction().commit();
		session.close();
	}

	public void aniadirEstancia(Estancia estancia) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.save(estancia);
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Residencia> cargarTablaResidencias() {
		openSession();
		session.beginTransaction();
		List<Residencia> listaResidencias = session.createQuery("FROM Residencia", Residencia.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return listaResidencias;
	}

	public List<Estudiante> cargarTablaEstudiantes() {
		openSession();
		session.beginTransaction();
		List<Estudiante> listaEstudiantes = session.createQuery("FROM Estudiante", Estudiante.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return listaEstudiantes;
	}

	public List<Universidad> cargarTablaUniversidades() {
		openSession();
		session.beginTransaction();
		List<Universidad> listaUniversidades = session.createQuery("FROM Universidad", Universidad.class)
				.getResultList();
		session.getTransaction().commit();
		session.close();
		return listaUniversidades;
	}

	public List<Estancia> cargarTablaEstancias() {
		openSession();
		session.beginTransaction();
		List<Estancia> listaEstancias = session.createQuery("FROM Estancia", Estancia.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return listaEstancias;
	}

	public List<ResidenciaObservacion> cargarTablaResidenciasObservaciones() {
		openSession();
		session.clear();
		session.beginTransaction();
		List<ResidenciaObservacion> listaResidenciasObservaciones = session
				.createQuery("FROM ResidenciaObservacion", ResidenciaObservacion.class).getResultList();
		session.getTransaction().commit();
		session.close();
		return listaResidenciasObservaciones;
	}

	public void eliminarResidencia(Residencia residencia) {
		openSession();
		session.beginTransaction();
		session.delete(residencia);
		session.getTransaction().commit();
		session.close();
	}

	public void eliminarResidenciaObservacion(Residencia residencia, ResidenciaObservacion observacion) {
		openSession();
		session.clear();
		session.beginTransaction();
		residencia.setResidenciasobservaciones(null);
		session.update(residencia);
		session.delete(observacion);
		session.getTransaction().commit();
		session.close();
	}
	
	public void eliminarEstancia(Estancia estancia) {
		openSession();
		session.beginTransaction();
		session.delete(estancia);
		session.getTransaction().commit();
		session.close();
	}

	public void modificarResidencia(Residencia residencia) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.update(residencia);
		session.getTransaction().commit();
		session.close();
	}

	public void modificarResidenciaObservacion(Residencia residencia, ResidenciaObservacion observacion) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.update(residencia);
		session.saveOrUpdate(observacion);
		session.getTransaction().commit();
		session.close();
	}

	public void modificarEstancia(Estancia estancia) {
		openSession();
		session.clear();
		session.beginTransaction();
		session.update(estancia);
		session.getTransaction().commit();
		session.close();
	}

	public static Session getSession() {
		return session;
	}

	public static void setSession(Session session) {
		HibernateConsulta.session = session;
	}

	public static void openSession() {
		session = HibernateUtil.openSession();
	}
}
