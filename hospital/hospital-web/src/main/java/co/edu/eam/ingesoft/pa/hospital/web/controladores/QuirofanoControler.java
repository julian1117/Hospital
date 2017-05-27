package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenHospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Quirofano;
import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;

@Named("quirofanoControler")
@ViewScoped
public class QuirofanoControler implements Serializable {

	private String idQuirofano;

	private String detalleImplementos;

	private String nombreQui;

	private String ocupado;

	private String detalleOcupado;

	private Date fechaOcupado;

	private String fechastr;

	private String idCamas;

	private String disponibilidad;

	private String detalleCama;
	
	private List<Quirofano> listaQuirofano;
	
	private Cirugia quirofano;
	
	private String estadoQuirofano;
	
	private List<OrdenHospitalizacion> listarCamas;

	@EJB
	private QuirofanoEJB quirofanoEJB;
	
	
	

	public List<OrdenHospitalizacion> getListarCamas() {
		return listarCamas;
	}

	public void setListarCamas(List<OrdenHospitalizacion> listarCamas) {
		this.listarCamas = listarCamas;
	}

	public List<Quirofano> getListaQuirofano() {
		return listaQuirofano;
	}

	public void setListaQuirofano(List<Quirofano> listaQuirofano) {
		this.listaQuirofano = listaQuirofano;
	}

	public Cirugia getQuirofano() {
		return quirofano;
	}

	public void setQuirofano(Cirugia quirofano) {
		this.quirofano = quirofano;
	}

	public String getDetalleCama() {
		return detalleCama;
	}

	public void setDetalleCama(String detalleCama) {
		this.detalleCama = detalleCama;
	}

	public String getIdCamas() {
		return idCamas;
	}

	public void setIdCamas(String idCamas) {
		this.idCamas = idCamas;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public QuirofanoEJB getQuirofanoEJB() {
		return quirofanoEJB;
	}

	public void setQuirofanoEJB(QuirofanoEJB quirofanoEJB) {
		this.quirofanoEJB = quirofanoEJB;
	}

	public String getFechastr() {
		return fechastr;
	}

	public void setFechastr(String fechastr) {
		this.fechastr = fechastr;
	}

	public String getIdQuirofano() {
		return idQuirofano;
	}

	public void setIdQuirofano(String idQuirofano) {
		this.idQuirofano = idQuirofano;
	}

	public String getDetalleImplementos() {
		return detalleImplementos;
	}

	public String getEstadoQuirofano() {
		return estadoQuirofano;
	}

	public void setEstadoQuirofano(String estadoQuirofano) {
		this.estadoQuirofano = estadoQuirofano;
	}

	public void setDetalleImplementos(String detalleImplementos) {
		this.detalleImplementos = detalleImplementos;
	}

	public String getNombreQui() {
		return nombreQui;
	}

	public void setNombreQui(String nombreQui) {
		this.nombreQui = nombreQui;
	}

	public String getOcupado() {
		return ocupado;
	}

	public void setOcupado(String ocupado) {
		this.ocupado = ocupado;
	}

	public String getDetalleOcupado() {
		return detalleOcupado;
	}

	public void setDetalleOcupado(String detalleOcupado) {
		this.detalleOcupado = detalleOcupado;
	}

	public Date getFechaOcupado() {
		return fechaOcupado;
	}

	public void setFechaOcupado(Date fechaOcupado) {
		this.fechaOcupado = fechaOcupado;
	}

	@PostConstruct
	public void inicializar(){
		listaQuirofano = quirofanoEJB.listarQuirofano();
		listarCamas = quirofanoEJB.listarCamas();
		}
	//}
	
	
	public void crearQuirofano() {
		try {
			// fechastr="01-01-2000";
			// fechaOcupado=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Quirofano quirofano = new Quirofano(Integer.parseInt(idQuirofano), detalleImplementos, nombreQui, true);
			// Quirofano quirofano = new
			// Quirofano(Integer.parseInt(idQuirofano), detalleImplementos,
			// nombreQui, false, "ninguno", fechaOcupado );
			quirofanoEJB.crearQuirofano(quirofano);
			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}
	}

	public void buscar() {
		Quirofano qui = quirofanoEJB.buscarQuirofano(Integer.parseInt(idQuirofano));
		if (qui != null) {
			nombreQui = qui.getNombreQuirofano();
			detalleImplementos = qui.getDetalleImplementos();
		} else {
			Messages.addFlashGlobalInfo("El quirofano no se encuentra registardo");

		}
	}

	public void editar() {
		Quirofano qui = quirofanoEJB.buscarQuirofano(Integer.parseInt(idQuirofano));
		if (qui != null) {
			// fechastr="01-01-2000";
			// fechaOcupado=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Quirofano quirofano = new Quirofano(Integer.parseInt(idQuirofano), detalleImplementos, nombreQui, false);
			// Quirofano quirofano = new
			// Quirofano(Integer.parseInt(idQuirofano), detalleImplementos,
			// nombreQui, false, "ninguno", fechaOcupado );
			quirofanoEJB.editarQuierofano(quirofano);
			Messages.addFlashGlobalInfo("Registro editado Con Exito!!");

		}
	}

	public void crearCamas() {
		try {

			Cama ca = new Cama(Integer.parseInt(idCamas), true, detalleCama);
			quirofanoEJB.crearCama(ca);
			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}

	}

	public void buscarCamas() {
		try {
			
			Cama ca = quirofanoEJB.buscarCama(Integer.parseInt(idCamas));
			if (ca != null) {
				detalleCama = ca.getDescripcion();
				} else {
				Messages.addFlashGlobalInfo("La cama no se encuentra registardo");

			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}

	}

	public void editarCamas() {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}
	}
}
