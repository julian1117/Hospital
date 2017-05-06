package co.edu.eam.ingesoft.pa.hospital.web.controladores;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoExamen;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.ProcedmientosEJB;


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
	
	private TipoCirugia cirugia;
	
	private List<TipoCirugia> listarTipoCirugias;
	
	//private Procedimiento proce;
	
	@EJB
	private GeneralEJB generalEJB;
	
	@EJB
	private ProcedmientosEJB procedimientosEJB;
	
	@PostConstruct
	public void inicializar() {
		listarExamen = generalEJB.listarTipoExamen();
		listarTipoCirugias = generalEJB.listarTipoCirugias();
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





	public TipoCirugia getCirugia() {
		return cirugia;
	}





	public void setCirugia(TipoCirugia cirugia) {
		this.cirugia = cirugia;
	}





	public List<TipoCirugia> getListarTipoCirugias() {
		return listarTipoCirugias;
	}





	public void setListarTipoCirugias(List<TipoCirugia> listarTipoCirugias) {
		this.listarTipoCirugias = listarTipoCirugias;
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
	
	public void descricionExamen(){
		Examen exam = generalEJB.buscarnExamen(examen.getIdExamen());
		descripcionExamen = exam.getDescripcion();
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
	
	
}
