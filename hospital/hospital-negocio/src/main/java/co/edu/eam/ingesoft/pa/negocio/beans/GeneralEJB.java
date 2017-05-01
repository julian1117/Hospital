package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Eps;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.HoraCita;

@Stateless
@LocalBean
public class GeneralEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * metodo que busca una ciudad ya exxistente
	 * @param ciudad el numero de identificacion de la ciudad
	 * @return la ciudad encontrada
	 */
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
	
	/**
	 * busca una eps ya existente 
	 * @param eps el id de la eps a buscar
	 * @return la eps encontrada
	 */
	public Eps buscarEps(Integer eps){
		Eps e = em.find(Eps.class, eps);
		return e;
	}
	
	/**
	 * lista todas las eps del sistema 
	 * @return las eps que estan en el sistema 
	 */
	public List<Eps> listarEps(){
		return em.createNamedQuery(Eps.LISTAR_EPS).getResultList();
	}

	/**
	 * Buscar hora cita
	 * @param id de la cita
	 * @return objeto cita
	 */
	public HoraCita buscarHoraCita(Integer id){
		return em.find(HoraCita.class, id);
	}
	
}
