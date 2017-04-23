package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class CitaEJB {

	@PersistenceContext
	private EntityManager em;

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
	public List<Cita> listCitaPaciente(Long cedula) {
		List<Cita> citas = em.createNamedQuery(Cita.LISTA_CITAS_PACIENTE).setParameter(1, cedula).getResultList();
		return citas;
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

	public void eliminarCitaPaciente(Cita codigoCita) {
		try {
			Cita citaEliminar = buscarCitaPaciente(codigoCita.getIdCita());			
			em.remove(citaEliminar);
		} catch (ExcepcionNegocio e) {
			throw new ExcepcionNegocio("No fue posible eliminar la cita");
		}
	}

}
