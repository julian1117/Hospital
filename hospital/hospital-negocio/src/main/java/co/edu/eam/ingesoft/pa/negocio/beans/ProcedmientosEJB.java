package co.edu.eam.ingesoft.pa.negocio.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
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
	

	
	

}
