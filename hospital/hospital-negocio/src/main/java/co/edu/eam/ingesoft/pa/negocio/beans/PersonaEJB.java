package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class PersonaEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * metodo que permite la creacion de una persona
	 * @param persona persona que se va a crear
	 */
	public void crearPersona(Persona persona){
		Persona buscar = buscarPersona(persona.getIdPersona().toString());
		
		if(buscar == null){
			em.persist(persona);
		}else{
			throw new ExcepcionNegocio("La persona ya se encuentra en el sistema");
		}
		
	}	
	
	/**
	 * permite la busqueda de una persona ya registrada por medio de 
	 * su numero de identificacion
	 * @param idPersona numero de identificacion de la persona a buscar
	 * @return
	 */
	public Persona buscarPersona(String idPersona){
		Persona per = em.find(Persona.class, idPersona);
		return per;
	}
	
	/**
	 * permite elminar a una persona registrada en el sistema por medio
	 * de su numero de identificacion
	 * @param persona persona la cual se eliminara
	 */
	public void eliminar(Persona persona){
		persona = buscarPersona(persona.getIdPersona().toString());
		em.remove(persona);
	}
	
	/**
	 * permite la edicion de una persona 
	 * @param persona persona a la cual se le haran las 
	 * modificaciones en el sistema
	 */
	public void editar(Persona persona){
		persona = buscarPersona(persona.getIdPersona().toString());
		em.merge(persona);
	}
	
	

}
