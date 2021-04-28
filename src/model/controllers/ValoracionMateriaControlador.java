package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;




public class ValoracionMateriaControlador {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
	// instancia del singleton
	private static ValoracionMateriaControlador instancia = null;

	/**
	 * 
	 */
	public ValoracionMateriaControlador() {
	}

	/**
	 * 
	 * @return
	 */
	public static ValoracionMateriaControlador getInstancia() {
		if (instancia == null) {
			instancia = new ValoracionMateriaControlador();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public ValoracionMateria findByMateriaAndProfesorAndEstudiante (Materia m, Profesor p, Estudiante e) {
		ValoracionMateria resultado = null;
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createNativeQuery("SELECT * FROM valoracionmateria where idMateria = ? and "
					+ "idProfesor = ? and idEstudiante = ?", ValoracionMateria.class);
			q.setParameter(1, m.getId());
			q.setParameter(2, p.getId());
			q.setParameter(3, e.getId());
			resultado = (ValoracionMateria) q.getSingleResult();
			em.close();
		}
		catch (NoResultException nrEx) {
		}
		return resultado;
	}
	
	
	/**
	 * 
	 * @param e
	 */
	public boolean save(ValoracionMateria e) {
		EntityManager em = this.factory.createEntityManager();
		try {
			em.getTransaction().begin();
			if (e.getId() != 0) {
				em.merge(e);
			}
			else {
				em.persist(e);
			}
			em.getTransaction().commit();
		}
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
		return true;
	}


}
