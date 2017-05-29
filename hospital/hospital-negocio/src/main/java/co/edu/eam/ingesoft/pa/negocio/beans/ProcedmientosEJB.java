package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.CausaPatologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Diagnostico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenCirugiaPK;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenHospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.PatologiaSintoma;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.PatologiaTratamiento;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.ResultadoExamen;
import co.edu.eam.ingesoft.pa.negocio.excepciones.ExcepcionNegocio;

@Stateless
@LocalBean
public class ProcedmientosEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * 
	 * @param examen
	 */
	public void crearExamen(Examen examen){
		
		//Examen ex = buscarExamen(examen.getIdProcedimiento());
		
		//if(ex==null){
			em.persist(examen);
//		}else{
//			throw new ExcepcionNegocio("El procedimiento no se encuentra en el sistema");
//
//		}
		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Examen buscarExamen(Integer id){
		Examen exam = em.find(Examen.class, id);
		return exam;
	}
	
	public void crearCirugia (Cirugia cirugia){
//		Cirugia ci = buscarCirugia(cirugia.getId());
//		if(ci==null){
			em.persist(cirugia);
//		}else{
//		throw new ExcepcionNegocio("La cirugia ya se encuentra programada");
//
//		}
	}
	
	public Cirugia buscarCirugia(Integer id){
		return em.find(Cirugia.class, id);
	}
	
	
	public void crearHospitalizacion(Hospitalizacion hos){
		em.persist(hos);
	}
	
	public Hospitalizacion buscarHospi(Integer id){
		return em.find(Hospitalizacion.class, id);
	}
	
	/**
	 * 
	 */
	public void crearOrdenExamen(OrdenExamen ordenExam){
		em.persist(ordenExam);
	}
	
	/**
	 * 
	 * @param idOrdenExam
	 * @return
	 */
	public OrdenExamen buscarOrdenExamen(Integer idOrdenExam){
		return em.find(OrdenExamen.class, idOrdenExam);
	}
	
	public void crearOrdenCirugia(OrdenCirugia ordenCiru){
		//OrdenCirugia buscarOr = buscarOrdenCirugia(ordenCiru.getIdCita(), ordenCiru.getIdCirugia());
		//if(buscarOr == null){
		em.persist(ordenCiru);
		//}else{
			//throw new ExcepcionNegocio("Ya esta registrada esta orden");
		//}
	}
	
	public OrdenCirugia buscarOrdenCirugia(Cita idCita, Cirugia idCirugia){
		OrdenCirugiaPK ordenPk = new OrdenCirugiaPK(idCita.getIdCita(), idCirugia.getId());
		OrdenCirugia ord = em.find(OrdenCirugia.class, ordenPk);
		return ord;
	}

	public void crearOrdenCirugi(OrdenCirugia id){
		em.persist(id);
	}
	
	public void crearOrdenHopitalizacion(OrdenHospitalizacion orden){
		em.persist(orden);
	}
	
	public void crearPatologiaTratamiento(PatologiaTratamiento patoTrata){
		em.persist(patoTrata);
	}
	
	public void crearPatologiaSintoma(PatologiaSintoma patoSintoma){
		em.persist(patoSintoma);
	}
	
	public void crearPatologiaCausa(CausaPatologia causaPato){
		em.persist(causaPato);
	}
	
	public void crearDiagnostico(Diagnostico dig){
		em.persist(dig);
	}
	
	public List<OrdenExamen> listarExamenes(Long cedula){
		return em.createNativeQuery(
				"SELECT * FROM ORDEN_EXAMENES oe inner join CITAS ci on ci.ID= oe.CITAS_ID inner join PACIENTES pa on ci.PACIENTES_PERSONA_ID= pa.PERSONAS_ID inner join PERSONAS per on per.PERSONAS_ID= pa.PERSONAS_ID where pa.PERSONAS_ID=?1",
				OrdenExamen.class).setParameter(1, cedula).getResultList();
	}
	
	public void crearResultadoExamen(ResultadoExamen resultado){
		em.persist(resultado);
	}
	

}
