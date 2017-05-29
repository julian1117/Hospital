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
	public void crearCita(Cita cita) {

		List<Cita> listaCitas = em.createNamedQuery(Cita.LISTA_CITA).setParameter(1, cita.getPersona().getIdPersona())
				.getResultList();

		for (int i = 0; i < listaCitas.size(); i++) {
			if (listaCitas.get(i).getAgenda().getFecha() != cita.getAgenda().getFecha()
					&& listaCitas.get(i).getHoraCita().getId() != cita.getHoraCita().getId()) {
				em.persist(cita);
			} else {
				throw new ExcepcionNegocio("Ya existe un registro similar");
			}
		}
	}

		/**
	 * Buscar una cita por su id
	 * 
	 * @param id
	 * @return
	 */
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
	 *            del paciente
	 * @return lista de citas del paciente
	 */
	public List<Cita> listaCitaPaciente(Long cedula) {
		return em.createNativeQuery(
				"SELECT * FROM CITAS c JOIN PERSONAS pac ON c.PACIENTES_PERSONA_ID = pac.PERSONAS_ID JOIN TIPOS_CITAS tp ON tp.ID = c.TIPOS_CITAS_ID JOIN AGENDAS a on c.AGENDAS_ID = a.ID JOIN CONSULTORIOS con on con.ID = a.CONSULTORIOS_ID JOIN PERSONAS pm on pm.PERSONAS_ID = a.MEDICOS_PERSONAS_ID JOIN HORAS_CITAS hr on c.HORAS_CITAS_ID=hr.ID  WHERE c.PACIENTES_PERSONA_ID=?1 AND c.ESTEADO=0",
				Cita.class).setParameter(1, cedula).getResultList();
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

	/**
	 * Busca una agenda
	 * 
	 * @param id
	 * @return
	 */
	public Agenda buscarAgenda(Integer id) {
		return em.find(Agenda.class, id);
	}

	/**
	 * Lista de agendas de un medico con la fechas
	 * mayores a la actual
	 * @param cedula
	 * @return
	 */
	public List<Agenda> listaAgendaMedico(long cedula) {
		return em.createNativeQuery("SELECT * FROM AGENDAS A WHERE A.MEDICOS_PERSONAS_ID=?1 AND current_date<A.FECHA", Agenda.class)
				.setParameter(1, cedula).getResultList();
	}

	/**
	 * Elimina la cita de un paciente
	 * 
	 * @param codigoCita
	 *            id de la cita a eliminar
	 */
	public void eliminarCitaPaciente(Cita codigoCita) {
		try {
			Cita citaEliminar = buscarCitaPaciente(codigoCita.getIdCita());
			em.remove(citaEliminar);
		} catch (ExcepcionNegocio e) {
			throw new ExcepcionNegocio("No fue posible eliminar la cita");
		}
	}

	
	public void editarCita(Cita id){
		em.merge(id);
	}
}
