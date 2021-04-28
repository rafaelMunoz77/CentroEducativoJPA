package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.Materia;




public class MateriaControlador {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
	// instancia del singleton
	private static MateriaControlador instancia = null;

	/**
	 * 
	 */
	public MateriaControlador() {
	}

	/**
	 * 
	 * @return
	 */
	public static MateriaControlador getInstancia() {
		if (instancia == null) {
			instancia = new MateriaControlador();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public List<Materia> findAll () {
		List<Materia> resultado = new ArrayList<Materia>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM Materia o", Materia.class);
			resultado = (List<Materia>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

}
