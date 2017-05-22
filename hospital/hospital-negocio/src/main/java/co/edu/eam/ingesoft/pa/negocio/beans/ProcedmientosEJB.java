package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenCirugiaPK;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenHospitalizacion;
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
	
	

}
