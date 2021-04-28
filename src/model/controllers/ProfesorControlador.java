package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Profesor;




public class ProfesorControlador {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
	// instancia del singleton
	private static ProfesorControlador instancia = null;

	/**
	 * 
	 */
	public ProfesorControlador() {
	}

	/**
	 * 
	 * @return
	 */
	public static ProfesorControlador getInstancia() {
		if (instancia == null) {
			instancia = new ProfesorControlador();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public List<Profesor> findAll () {
		List<Profesor> resultado = new ArrayList<Profesor>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM Profesor o", Profesor.class);
			resultado = (List<Profesor>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

}
