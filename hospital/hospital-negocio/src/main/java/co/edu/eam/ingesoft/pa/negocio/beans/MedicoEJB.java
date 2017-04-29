package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class MedicoEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param medico
	 */
	public void crearMedico(Medico medico){
		
		Medico buscar = buscarMedico(medico.getIdPersona());
		
		if(buscar == null){
			em.persist(medico);
		}else{
			throw new ExcepcionNegocio("El medico ya se encuentra en el sistema");
		}
		
	}
	
	/**
	 * permite buscar a un medico ya registrado en el 
	 * sistema por medio de su id
	 * @param id numero de identificacion por el cual se 
	 * va  a buscar al medico
	 * @return
	 */
	public Medico buscarMedico(Long id){
		Medico med = em.find(Medico.class, id);
		return med;
	}
		
	/**
	 * Lista de medicos
	 * @return
	 */
	public List<Medico> listaMedicos(){
		return em.createNamedQuery(Medico.LISTA_MEDICOS).getResultList();		
		 
	}
	
	
	

}
