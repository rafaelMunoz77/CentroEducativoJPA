package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Estudiante;
import model.entities.TipologiaSexo;


public class EstudianteControlador {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
	// instancia del singleton
	private static EstudianteControlador instancia = null;

	/**
	 * 
	 */
	public EstudianteControlador() {
	}

	/**
	 * 
	 * @return
	 */
	public static EstudianteControlador getInstancia() {
		if (instancia == null) {
			instancia = new EstudianteControlador();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public Estudiante findFirst () {
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e order by e.id", Estudiante.class);
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Estudiante findLast () {
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e order by e.id desc", Estudiante.class);
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	/**
	 * 
	 * @return
	 */
	public Estudiante findNext (Estudiante e) {
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e where e.id > :idActual order by e.id", Estudiante.class);
			q.setParameter("idActual", e.getId());
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

	
	
	
	/**
	 * 
	 * @return
	 */
	public Estudiante findPrevious (Estudiante e) {
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT e FROM Estudiante e where e.id < :idActual order by e.id desc", Estudiante.class);
			q.setParameter("idActual", e.getId());
			Estudiante resultado = (Estudiante) q.setMaxResults(1).getSingleResult();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}
	
	
	
	/**
	 * 
	 */
	public boolean remove(Estudiante e) {
		EntityManager em = this.factory.createEntityManager();
		try {
			em.getTransaction().begin();
			if (!em.contains(e)) {
				e = em.merge(e);
			}
			em.remove(e);
			em.getTransaction().commit();
			em.close();
			return true;
		}
		catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param e
	 */
	public boolean save(Estudiante e) {
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


	
	/**
	 * 
	 * @return
	 */
	public List<Estudiante> findAll () {
		List<Estudiante> resultado = new ArrayList<Estudiante>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM Estudiante o", Estudiante.class);
			resultado = (List<Estudiante>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

}
