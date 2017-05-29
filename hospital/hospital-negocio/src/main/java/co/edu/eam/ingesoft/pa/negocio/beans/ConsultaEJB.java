package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;

@Stateless
@LocalBean
public class ConsultaEJB {

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * lista PACIENTES CON CIRUGIAS QUE NO HAN REQUERIDO HOSPITALIZACION
	 * @return
	 */
	public List<String> listarPacientesCirugias(){
		return em.createNativeQuery("SELECT ORD.CITAS_ID ,PAC.PERSONAS_ID,PER.NOMBRE,PER.APELLIDO FROM PACIENTES PAC JOIN CITAS C ON PAC.PERSONAS_ID= C.PACIENTES_PERSONA_ID JOIN ORDEN_CIRUGIAS ORD ON ORD.CITAS_ID = C.ID JOIN CIRUGIAS CIR ON ORD.CIRUGIAS_ID_CIRUGIA = CIR.ID_CIRUGIA JOIN TIPO_CIRUGIAS TC ON CIR.TIPO_CIRUGIAS_ID = TC.ID JOIN PERSONAS PER ON PAC.PERSONAS_ID= PER.PERSONAS_ID MINUS SELECT OH.CITAS_ID , PAC.PERSONAS_ID,PER.NOMBRE,PER.APELLIDO FROM PACIENTES PAC JOIN CITAS C ON PAC.PERSONAS_ID= C.PACIENTES_PERSONA_ID JOIN ORDEN_HOSPITALIZACION OH ON OH.CITAS_ID = C.ID JOIN HOSPITALIZACIONES H ON OH.HOSPITALIZACIONES_ID = H.ID_HOSPITALIZACION JOIN PERSONAS PER ON PAC.PERSONAS_ID= PER.PERSONAS_ID").getResultList(); 
		}
//	
	
}
