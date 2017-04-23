package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;

@Stateless
@LocalBean
public class GeneralEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public Ciudad buscarCiudad(Integer ciudad){
		Ciudad ci = em.find(Ciudad.class, ciudad);
		return ci;
	}
	
	/**
	 * lista todas las ciudades del sistema 
	 * @return las ciudades que hayan en el sistema
	 */
	public List<Ciudad> listarCiudad(){
		return em.createNamedQuery(Ciudad.LISTAR_CIUDAD).getResultList();
	}

}
