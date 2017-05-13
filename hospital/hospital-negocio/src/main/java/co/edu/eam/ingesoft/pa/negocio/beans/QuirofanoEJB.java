package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Quirofano;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class QuirofanoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param quirofano
	 */
	public void crearQuirofano(Quirofano quirofano){
		Quirofano qui =  buscarQuirofano(quirofano.getId());
		
		if(qui==null){
			em.persist(quirofano);
		}else{
			throw new ExcepcionNegocio("El quierofano ya se encuentra registrado");
		}
	}
	
	/**
	 * permite la busqueda de un quirofano ingresado en el sistema
	 * @param id numero de quirofano a buscar
	 * @return el quierodano encontrado
	 */
	public Quirofano buscarQuirofano(Integer id){
		return em.find(Quirofano.class, id);
	}
	
	/**
	 * permite la edicion de un quirofano que este en el sistema
	 * @param quirofano a editar
	 */
	public void editarQuierofano(Quirofano quirofano){
		Quirofano qui = buscarQuirofano(quirofano.getId());
		if(qui!=null){
			em.merge(quirofano);
		}else{
			throw new ExcepcionNegocio("El quirofano no se encuentra en el sistema");

		}
	}
	
	/**
	 * lista los quirofanos del hospital
	 * @return
	 */
	public List<Quirofano> listarQuirofano(){
		return em.createNamedQuery(Quirofano.LISTAR_QUIROFANO).getResultList();
	}

	public void crearCama(Cama cama){
		Cama ca = buscarCama(cama.getIdCama());
		if(ca==null){
			em.persist(cama);
		}else{
			throw new ExcepcionNegocio("la cama no se encuentra en el sistema");

		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Cama buscarCama(Integer id){
		return em.find(Cama.class, id);
	}
}
