package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.ItemMedicamento;

@Stateless
@LocalBean
public class EntregaMedEJB {

	@PersistenceContext
	private EntityManager em;

	/**
	 * lista de medicamentos por paciente
	 * 
	 * @param cedeula
	 *            del paciene
	 * @return lista de medicamentos
	 */
	public List<ItemMedicamento> listaMedPac(Long cedeula) {
		return em.createNativeQuery(
				"SELECT * FROM ITEM_MEDICAMENTOS im JOIN CITAS c on im.ID = c.ID where c.PACIENTES_PERSONA_ID=?1",
				ItemMedicamento.class).setParameter(1, cedeula).getResultList();

	}

}
