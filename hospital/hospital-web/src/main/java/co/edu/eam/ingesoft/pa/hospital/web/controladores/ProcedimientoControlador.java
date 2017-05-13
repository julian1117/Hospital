package co.edu.eam.ingesoft.pa.hospital.web.controladores;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Quirofano;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoExamen;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.ProcedmientosEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;


@Named("proceControler")
@ViewScoped
public class ProcedimientoControlador implements Serializable{
	
	private String cedulaPaciente;
	
	private TipoExamen tipoExamen;
	
	private Examen examen;
	
	private List<TipoExamen> listarExamen;
	
	private String descripcionExamen;
	
	private String descripcionInicio;

	private String descripcionFinal;
	
	private TipoCirugia tipoCirugia;
	
	private List<TipoCirugia> listarTipoCirugias;	
	
	private String idCirugia;
	
	private Quirofano quirofano;
	
	private List<Quirofano> listarQuirofanos;
	
	private Cama cama;
	
	private List<Cama> listaCamas;
	
	private String motivo;
	
	private String detalleHospi;
	
	
	@EJB
	private GeneralEJB generalEJB;
	
	@EJB
	private ProcedmientosEJB procedimientosEJB;
	
	@EJB
	private QuirofanoEJB quirofanoEJB;
	
	@PostConstruct
	public void inicializar() {
		listarExamen = generalEJB.listarTipoExamen();
		listarTipoCirugias = generalEJB.listarTipoCirugias();
		listarQuirofanos = quirofanoEJB.listarQuirofano();
		listaCamas = generalEJB.listarCama();
	}
	
	
	

	public String getMotivo() {
		return motivo;
	}




	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}




	public String getDetalleHospi() {
		return detalleHospi;
	}




	public void setDetalleHospi(String detalleHospi) {
		this.detalleHospi = detalleHospi;
	}




	public Cama getCama() {
		return cama;
	}



	public void setCama(Cama cama) {
		this.cama = cama;
	}



	public List<Cama> getListaCamas() {
		return listaCamas;
	}



	public void setListaCamas(List<Cama> listaCamas) {
		this.listaCamas = listaCamas;
	}



	public QuirofanoEJB getQuirofanoEJB() {
		return quirofanoEJB;
	}



	public void setQuirofanoEJB(QuirofanoEJB quirofanoEJB) {
		this.quirofanoEJB = quirofanoEJB;
	}



	public List<Quirofano> getListarQuirofanos() {
		return listarQuirofanos;
	}


	public void setListarQuirofanos(List<Quirofano> listarQuirofanos) {
		this.listarQuirofanos = listarQuirofanos;
	}


	public String getCedulaPaciente() {
		return cedulaPaciente;
	}


	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}


	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}


	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}


	public Examen getExamen() {
		return examen;
	}


	public void setExamen(Examen examen) {
		this.examen = examen;
	}


	public List<TipoExamen> getListarExamen() {
		return listarExamen;
	}


	public void setListarExamen(List<TipoExamen> listarExamen) {
		this.listarExamen = listarExamen;
	}


	public String getDescripcionExamen() {
		return descripcionExamen;
	}


	public void setDescripcionExamen(String descripcionExamen) {
		this.descripcionExamen = descripcionExamen;
	}


	public String getDescripcionInicio() {
		return descripcionInicio;
	}


	public void setDescripcionInicio(String descripcionInicio) {
		this.descripcionInicio = descripcionInicio;
	}


	public String getDescripcionFinal() {
		return descripcionFinal;
	}


	public void setDescripcionFinal(String descripcionFinal) {
		this.descripcionFinal = descripcionFinal;
	}


	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}


	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}


	public List<TipoCirugia> getListarTipoCirugias() {
		return listarTipoCirugias;
	}


	public void setListarTipoCirugias(List<TipoCirugia> listarTipoCirugias) {
		this.listarTipoCirugias = listarTipoCirugias;
	}


	public String getIdCirugia() {
		return idCirugia;
	}


	public void setIdCirugia(String idCirugia) {
		this.idCirugia = idCirugia;
	}


	public Quirofano getQuirofano() {
		return quirofano;
	}


	public void setQuirofano(Quirofano quirofano) {
		this.quirofano = quirofano;
	}


	public GeneralEJB getGeneralEJB() {
		return generalEJB;
	}


	public void setGeneralEJB(GeneralEJB generalEJB) {
		this.generalEJB = generalEJB;
	}


	public ProcedmientosEJB getProcedimientosEJB() {
		return procedimientosEJB;
	}


	public void setProcedimientosEJB(ProcedmientosEJB procedimientosEJB) {
		this.procedimientosEJB = procedimientosEJB;
	}


	public void buscarPaciente(){		
	}
	
	
	
	public void generarExamen(){
		try {
			TipoExamen tipoExam = generalEJB.buscarTipoExamen(tipoExamen.getIdTipoExamenes());
			Examen ex = new Examen(tipoExam, descripcionExamen);
			procedimientosEJB.crearExamen(ex);

			Messages.addFlashGlobalInfo("Examen generado!");
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}	
		
	}
	
	public void generarCirugia(){
		try {
			TipoCirugia tipoC = generalEJB.buscarTipoCirugia(tipoCirugia.getIdTipoCirugia());
			Quirofano qui = quirofanoEJB.buscarQuirofano(quirofano.getId());
			
			Cirugia ciru = new Cirugia(tipoC, descripcionInicio, descripcionFinal, qui);
			procedimientosEJB.crearCirugia(ciru);
 			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}
	
	public void generarHospitalizacion(){
		try {
			
			Cama ca = generalEJB.buscarCama(cama.getIdCama());
			
			Hospitalizacion hos = new Hospitalizacion(detalleHospi, motivo, ca);
			procedimientosEJB.crearHospitalizacion(hos);
 			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

			
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}
	
	
}
