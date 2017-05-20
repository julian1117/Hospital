package co.edu.eam.ingesoft.pa.negocio.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Causa;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Eps;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Especializacione;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.HoraCita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Roll;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Sintoma;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Tratamiento;

@Stateless
@LocalBean
public class GeneralEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	/**
	 * metodo que busca una ciudad ya exxistente
	 * @param ciudad el numero de identificacion de la ciudad
	 * @return la ciudad encontrada
	 */
	public Ciudad buscarCiudad(Integer ciudad){
		Ciudad ci = em.find(Ciudad.class, ciudad);
		return ci;
	}
	
	/**
	 * lista todas las ciudades del sistema 
	 * @return las ciudades que hayan en el sistema
	 */
	public List<Ciudad> listarCiudad(){
		return em.createNamedQuery(Ciudad.LISTAR_CIUDAD).getResultList();
	}
	
	/**
	 * busca una eps ya existente 
	 * @param eps el id de la eps a buscar
	 * @return la eps encontrada
	 */
	public Eps buscarEps(Integer eps){
		Eps e = em.find(Eps.class, eps);
		return e;
	}
	
	/**
	 * lista todas las eps del sistema 
	 * @return las eps que estan en el sistema 
	 */
	public List<Eps> listarEps(){
		return em.createNamedQuery(Eps.LISTAR_EPS).getResultList();
	}

	/**
	 * Buscar hora cita
	 * @param id de la cita
	 * @return objeto cita
	 */
	public HoraCita buscarHoraCita(Integer id){
		return em.find(HoraCita.class, id);
	}
	
	/**
	 * Busca un objeto patologia
	 * @param id por el que se busca
	 * @return objeto patologia
	 */
	public Patologia buscarPatologia (Integer id){
		return em.find(Patologia.class, id);
	}
	
	/**
	 * Lista de patologias
	 * @return lista de patologias
	 */
	public List<Patologia> listaPatologia (){
		return em.createNamedQuery(Patologia.LISTA_PATOLOGIA).getResultList();
	}
	
	public List<HoraCita> listaHora(){
		return em.createNamedQuery(HoraCita.LISTA_HORAS).getResultList();
	}
	
	/**
	 * Buscar una causa 
	 * @param id por el que se busca
	 * @return objeto cuasa
	 */
	public Causa buscarCausa(Integer id){
		return em.find(Causa.class, id);
	}
	
	/**
	 * Lista de causas
	 * @return lista de causas
	 */
	public List<Causa> listaCausa(){
		return em.createNamedQuery(Causa.LISTA_CAUSAS).getResultList();
	}
	
	/**
	 * Busca un sintoma
	 * @return objeto sintoma
	 */
	public Sintoma buscarSintoma(Integer id){
		return em.find(Sintoma.class, id);
	}
	
	/**
	 * lista de sintomas
	 * @return
	 */
	public List<Sintoma> listaSintoma(){
		return em.createNamedQuery(Sintoma.LISTA_SINTOMAS).getResultList();
	}
	
	/**
	 * Busca un tratamiento por id
	 * @param id del tratamiento
	 * @return objeto tratamiento
	 */
	public Tratamiento buscarTratamiento(Integer id){
		return em.find(Tratamiento.class, id);
	}
	
	/**
	 * Lista de tratamientos
	 * @return lista de tratamientos
	 */
	public List<Tratamiento> listaTratamiento(){
		return em.createNamedQuery(Tratamiento.LISTA_TRATAMIENTO).getResultList();
	}
	
	/**
	 * busca las espacializaciones qie hay en el sistema
	 * @param id de la especializacion a buscar
	 * @return
	 */
	public Especializacione buscarEspecializacione(Integer id){
		return em.find(Especializacione.class, id);
	}
	
	/**
	 * lista las esoecializaciones encontradas en el sistema 
	 * @return las especializaciones encontradas
	 */
	public List<Especializacione> listarEspecializacione(){
		return em.createNamedQuery(Especializacione.LISTAR_ESPECIALIZACIONES).getResultList();
	}
	
	/**
	 * busca los tipos de examenes del sistema
	 * @param id identificacion del tipo de examen a buscar
	 * @return
	 */
	public TipoExamen buscarTipoExamen(Integer id){
		return em.find(TipoExamen.class, id);
	}
	
	/**
	 * lista los tipos de examenes del sistema
	 * @return los tipos de examanes encontrados
	 */
	public List<TipoExamen> listarTipoExamen(){
		return em.createNamedQuery(TipoExamen.LISTAR_TIPO_EXAMEN).getResultList();
	}
	
	/**
	 * busca los tipos de cirugias 
	 * @param id la identificacion de las cirugias a buscar
	 * @return las cirugias encontradas
	 */
	public TipoCirugia buscarTipoCirugia(Integer id){
		return em.find(TipoCirugia.class, id);
	}
	
	/**
	 * lista los tipos de cirugias del sistema
	 * @return los tipos de cirugias encontrados
	 */
	public List<TipoCirugia> listarTipoCirugias(){
		return em.createNamedQuery(TipoCirugia.LISTAR_TIPO_CIRUGIAS).getResultList();
	}
	
	/**
	 * busca un examen que se encuentre en el sistema
	 * @param id de el examen a buscar
	 * @return el examen encontrado
	 */
	public Examen buscarnExamen(Integer id){
		return em.find(Examen.class, id);		
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Cama buscarCama(Integer id){
		return em.find(Cama.class, id);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Cama> listarCama(){
		return em.createNamedQuery(Cama.LISTAR_CAMA).getResultList();
	}
	
	public Roll buscarRol(Integer roles){
		return em.find(Roll.class, roles);
	}
	
	public Examen buscarIdExamen(Integer id){
		return em.find(Examen.class, id);
	}
	
	public Cita buscarIdCita(Integer id){
		return em.find(Cita.class, id);
	}
}
