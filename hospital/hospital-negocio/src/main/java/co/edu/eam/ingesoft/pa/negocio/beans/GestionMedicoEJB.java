package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;

@Stateless
@LocalBean
public class GestionMedicoEJB {


	@PersistenceContext
	private EntityManager em;
	
	
	public List<Cita> listaCitaMedico(Long cedula) {
		return em.createNativeQuery(
				"SELECT * FROM CITAS c JOIN PERSONAS pac ON c.PACIENTES_PERSONA_ID = pac.PERSONAS_ID JOIN TIPOS_CITAS tp ON tp.ID = c.TIPOS_CITAS_ID JOIN AGENDAS a on c.AGENDAS_ID = a.ID JOIN CONSULTORIOS con on con.ID = a.CONSULTORIOS_ID JOIN PERSONAS pm on pm.PERSONAS_ID = a.MEDICOS_PERSONAS_ID JOIN HORAS_CITAS hr on c.HORAS_CITAS_ID=hr.ID WHERE a.MEDICOS_PERSONAS_ID=?1 AND c.ESTEADO=0",
				Cita.class).setParameter(1, cedula).getResultList();
	}
	
}
