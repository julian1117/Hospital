package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Inventario;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.ItemMedicamento;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

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
				"SELECT * FROM ITEM_MEDICAMENTOS im JOIN CITAS c on im.ID = c.ID where c.PACIENTES_PERSONA_ID=?1 AND im.ESTADO=0",
				ItemMedicamento.class).setParameter(1, cedeula).getResultList();
	}

	public List<Inventario> listaInventario(Integer tiMed) {
		return em.createNativeQuery("SELECT * FROM INVENTARIOS I WHERE I.TIPO_MEDICAMENTO_ID=?1", Inventario.class)
				.setParameter(1, tiMed).getResultList();
	}

	public void entregaMedicamentos(ItemMedicamento itMed) {

		List<Inventario> inv = listaInventario(itMed.getTipoMedicamento().getIdTipoMedicamento());

		Inventario inventario = inv.get(0);
		
		int cant = inventario.getCantidadDisponible();

		inventario.setCantidadDisponible(cant - itMed.getCantidadResetada());

		itMed.setEstado(true);

		if (cant >= itMed.getCantidadResetada()) {
			em.merge(itMed);
			em.merge(inventario);
		} else {
			throw new ExcepcionNegocio("No hay suficients medicamentos en el inventario: " + cant);
		}

	}

}
