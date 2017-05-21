package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
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

	public void crearPaciente(Paciente paciente) {
		Paciente buscarPer = buscarPaciente(paciente.getIdPersona());

		if (buscarPer == null) {
			em.persist(paciente);
		} else {
			throw new ExcepcionNegocio("La persona ya se encuentra en el sistema");
		}
	}

	public Paciente buscarPaciente(Long id) {
		Paciente paciente = em.find(Paciente.class, id);
		return paciente;
	}

	public void editarPaciente(Paciente paciente) {
		em.merge(paciente);
	}

	
	/**
	 * lista de citas por paciente
	 * @param cedula del paciente que entra al sistema
	 * @return lista de sus citas
	 */
	public List<Cita> listaCitasPaciente(Long cedula){
		return em.createNativeQuery(
				"SELECT * FROM CITAS c JOIN PERSONAS pac ON c.PACIENTES_PERSONA_ID = pac.PERSONAS_ID  JOIN TIPOS_CITAS tp ON tp.ID = c.TIPOS_CITAS_ID JOIN AGENDAS a on c.AGENDAS_ID = a.ID  JOIN CONSULTORIOS con on con.ID = a.CONSULTORIOS_ID JOIN PERSONAS pm on pm.PERSONAS_ID = a.MEDICOS_PERSONAS_ID JOIN HORAS_CITAS hr on c.HORAS_CITAS_ID=hr.ID WHERE pac.PERSONAS_ID=?1 AND c.ESTEADO=0",
				Cita.class).setParameter(1, cedula).getResultList();
	}
	

}
