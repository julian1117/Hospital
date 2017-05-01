package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class PacienteEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private PersonaEJB persnaEJB;
	
	public void crearPaciente(Paciente paciente){
		Persona buscarPer = persnaEJB.buscarPersona(paciente.getIdPersona());
		if(buscarPer!=null){
			em.persist(paciente);
		}else{
			throw new ExcepcionNegocio("La persona no se encuentra en el sistema");
		}
	}
	
	

}
