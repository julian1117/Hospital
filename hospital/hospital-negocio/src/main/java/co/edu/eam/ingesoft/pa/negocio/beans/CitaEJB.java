package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Agenda;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class CitaEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 */
	public void crearCita(Agenda agenda, Cita cita) {
//		Cita citaB = buscarCita(cita.getIdCita());
//		if (citaB == null) {
			em.persist(agenda);
			em.persist(cita);
//		} else {
//			throw new ExcepcionNegocio("La cita ya existe");
//		}
	}

	public Cita buscarCita(Integer id) {
		return em.find(Cita.class, id);
	}

	/**
	 * Buscar paciente por cedula
	 * 
	 * @param cedula
	 *            del paciente
	 * @return obeto paciente
	 */
	public Paciente buscarPaciente(Long cedula) {
		return em.find(Paciente.class, cedula);
	}

	/**
	 * Permite buscar tipos de cita par aun paciente
	 * 
	 * @param tCita
	 * @return
	 */
	public TipoCita buscarTipoDeCita(int tCita) {
		TipoCita tp = em.find(TipoCita.class, tCita);
		return tp;
	}

	/**
	 * Lista de todos los tipos de citas
	 * 
	 * @return
	 */
	public List<TipoCita> listaTipoCita() {
		List<TipoCita> tipoCitas = em.createNamedQuery(TipoCita.LISTA_TIPO_CITAS).getResultList();
		return tipoCitas;
	}

	/**
	 * Lista de citas de un paciente
	 * 
	 * @param cedula
	 * @return
	 */

	public List<Cita> listaCitaPaciente(Long cedula) {
		return em.createNativeQuery(
				"SELECT * FROM CITAS c JOIN PERSONAS pac ON c.PACIENTES_PERSONA_ID = pac.PERSONAS_ID JOIN TIPOS_CITAS tp ON tp.ID = c.TIPOS_CITAS_ID JOIN AGENDAS a on c.AGENDAS_ID = a.ID JOIN CONSULTORIOS con on con.ID = a.CONSULTORIOS_ID JOIN PERSONAS pm on pm.PERSONAS_ID = a.MEDICOS_PERSONAS_ID JOIN HORAS_CITAS hr on c.HORAS_CITAS_ID=hr.ID  WHERE c.PACIENTES_PERSONA_ID=?1 AND c.ESTEADO=0",Cita.class).setParameter(1,cedula ).getResultList();
	
	}

	public List<Cita> listCitaPaciente(Long cedula) {
		return em.createNamedQuery(Cita.LISTA_CITAS_PACIENTE).setParameter(1, cedula).getResultList();
	}

	/**
	 * Busca cita de un paciente
	 * 
	 * @param codigoCita
	 * @return
	 */
	public Cita buscarCitaPaciente(Integer codigoCita) {
		return em.find(Cita.class, codigoCita);
	}

	public Agenda buscarAgenda(Integer id) {
		return em.find(Agenda.class, id);
	}

	public void eliminarCitaPaciente(Cita codigoCita) {
		try {
			Cita citaEliminar = buscarCitaPaciente(codigoCita.getIdCita());
			em.remove(citaEliminar);
			Agenda elimanrAgenda = buscarAgenda(citaEliminar.getAgenda().getId());
			em.remove(elimanrAgenda);
		} catch (ExcepcionNegocio e) {
			throw new ExcepcionNegocio("No fue posible eliminar la cita");
		}
	}

}
