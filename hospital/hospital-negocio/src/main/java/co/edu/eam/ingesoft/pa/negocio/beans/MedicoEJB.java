package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Agenda;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
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
	public void crearMedico(Medico medico) {

		Medico buscar = buscarMedico(medico.getIdPersona());

		if (buscar == null) {
			em.persist(medico);
		} else {
			throw new ExcepcionNegocio("El medico ya se encuentra en el sistema");
		}

	}

	/**
	 * permite buscar a un medico ya registrado en el sistema por medio de su id
	 * 
	 * @param id
	 *            numero de identificacion por el cual se va a buscar al medico
	 * @return
	 */
	public Medico buscarMedico(Long id) {
		return em.find(Medico.class, id);
	}

	/**
	 * Lista de medicos
	 * 
	 * @return
	 */
	public List<Medico> listaMedicos() {
		return em.createNamedQuery(Medico.LISTA_MEDICOS).getResultList();

	}

	public List<Medico> listaMedicosCompleta() {
		return em.createNativeQuery(
				"SELECT * FROM MEDICOS M JOIN ESPECIALIZACIONES E ON E.ID = M.ESPECIALIZACIONES_ID JOIN PERSONAS P ON P.PERSONAS_ID = M.PERSONAS_ID",
				Medico.class).getResultList();
	}

	/**
	 * list medico por especialidad
	 * 
	 * @param idEsp
	 * @return
	 */
	public List<Medico> listaMedicosEspe(Integer idEsp) {
		return em.createNamedQuery(Medico.LISTA_MEDICOS_ESP).setParameter(1, idEsp).getResultList();
	}

	public void editarMedico(Medico medico) {
		em.merge(medico);
	}

	/**
	 * Permite crear una agenda a un medico
	 * @param agenda
	 */
	public void crearAgendaMedico(Agenda agenda) {

		String[] horaInicio = agenda.getHoraInicio().split(":");
		String[] horaFinal = agenda.getHoraFinal().split(":");

		List<Agenda> listaMedicoAgenda = em
				.createNativeQuery(
						"SELECT * FROM MEDICOS M JOIN AGENDAS A ON M.PERSONAS_ID = A.MEDICOS_PERSONAS_ID WHERE M.PERSONAS_ID=?1 AND A.FECHA=?2",
						Agenda.class)
				.setParameter(1, agenda.getMedico().getIdPersona()).setParameter(2, agenda.getFecha()).getResultList();
		
		if (listaMedicoAgenda.size() == 0) {
			for (int i = 0; i < horaInicio.length; i++) {

				int horaIni = Integer.parseInt(horaInicio[0]);
				int horaFin = Integer.parseInt(horaFinal[0]);

				if (horaIni < horaFin) {
					em.persist(agenda);
				} else {
					throw new ExcepcionNegocio("Ingrese una hora valida");
				}
			}
		} else {
			throw new ExcepcionNegocio("Ya existe un registro para este medico con la fecha ingresada");
		}

	}

}
