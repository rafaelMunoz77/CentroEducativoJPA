package model.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.entities.TipologiaSexo;



public class TipologiaSexoControlador {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("CentroEducativoJPA");
	
	// instancia del singleton
	private static TipologiaSexoControlador instancia = null;

	/**
	 * 
	 */
	public TipologiaSexoControlador() {
	}

	/**
	 * 
	 * @return
	 */
	public static TipologiaSexoControlador getInstancia() {
		if (instancia == null) {
			instancia = new TipologiaSexoControlador();
		}
		return instancia;
	}

	/**
	 * 
	 * @return
	 */
	public List<TipologiaSexo> findAll () {
		List<TipologiaSexo> resultado = new ArrayList<TipologiaSexo>();
		try {
			EntityManager em = this.factory.createEntityManager();
			Query q = em.createQuery("SELECT o FROM TipologiaSexo o", TipologiaSexo.class);
			resultado = (List<TipologiaSexo>) q.getResultList();
			em.close();
			return resultado;
		}
		catch (NoResultException nrEx) {
			return null;
		}
	}

}
