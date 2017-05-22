package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cama;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Causa;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenHospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Quirofano;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Sintoma;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Tratamiento;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GestionMedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.ProcedmientosEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;

@Named("atenderCitaController")
@ViewScoped
public class AtenderCitaController implements Serializable {

	// @Pattern(regexp = "[0-9]*", message = "Solo numeros")
	// @Length(min = 8, max = 11, message = "La longitud debe ser de 8 a 11
	// numer")
	private String cedulaPaciente;

	private String textoDesPatologia;

	private static Cita cita;

	private Patologia patologia;

	private Causa causa;

	private Sintoma sintoma;

	private Tratamiento tratamiento;

	private List<Patologia> listaPatolgia;

	private List<Causa> listaCausas;

	private List<Sintoma> listaSintomas;

	private List<Tratamiento> listaTratamiento;

	private List<Cita> listaCitasMedico;

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
	private ProcedmientosEJB procedimientosEJB;

	@EJB
	private QuirofanoEJB quirofanoEJB;

	@Inject
	private SessionController usuarioSesion;

	@EJB
	private GestionMedicoEJB medicoGestionEJB;

	@EJB
	private CitaEJB citaEJB;

	@EJB
	private GeneralEJB generalEJB;

	@PostConstruct
	public void inicializar() {
		listaPatolgia = generalEJB.listaPatologia();
		listaCausas = generalEJB.listaCausa();
		listaSintomas = generalEJB.listaSintoma();
		listaTratamiento = generalEJB.listaTratamiento();
		listaCitasMedico = medicoGestionEJB.listaCitaMedico(usuarioSesion.getUse().getIdPersona().getIdPersona());
		listarExamen = generalEJB.listarTipoExamen();
		listarTipoCirugias = generalEJB.listarTipoCirugias();
		listarQuirofanos = quirofanoEJB.listarQuirofano();
		listaCamas = generalEJB.listarCama();
	}

	public String AtenderCita(Cita doc) {
		cita = doc;
		return "/paginas/seguro/Medico/AtenderCita.xhtml?faces-redirect=true";
	}

	public void descPatologia() {

		Patologia patolo = generalEJB.buscarPatologia(patologia.getIdPatologia());

		textoDesPatologia = patolo.getDescripcion();
	}


	public void generarExamen() {
		try {
			
			TipoExamen tipoExam = generalEJB.buscarTipoExamen(tipoExamen.getIdTipoExamenes());
			Examen ex = new Examen(tipoExam, descripcionExamen);
			procedimientosEJB.crearExamen(ex);

			Examen idExa = generalEJB.buscarIdExamen(ex.getIdExamen());
		//	Integer exa = idExa.getIdExamen();
			//
			Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());
			//Integer cit = cita.getIdCita();
			
			OrdenExamen ordenema= new OrdenExamen(citaa, idExa);
			procedimientosEJB.crearOrdenExamen(ordenema);
			Messages.addFlashGlobalInfo("Examen generado!");
			
		} catch (Exception e) {

		}

	}
	

	public void generarCirugia() {
		try {
			TipoCirugia tipoC = generalEJB.buscarTipoCirugia(tipoCirugia.getIdTipoCirugia());
			Quirofano qui = quirofanoEJB.buscarQuirofano(quirofano.getId());

<<<<<<< HEAD
			if(qui.isOcupado()== true){
=======

			if(qui.isOcupado()== false){
>>>>>>> refs/remotes/origin/master
				Cirugia ciru = new Cirugia(tipoC, descripcionInicio, descripcionFinal, qui);
				procedimientosEJB.crearCirugia(ciru);
				
				Cirugia busCiru = generalEJB.buscarCirugia(ciru.getId());
				Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());
				Messages.addFlashGlobalError(busCiru.getId()+"");
				OrdenCirugia ordenCiru = new OrdenCirugia(citaa, busCiru);	
				
				procedimientosEJB.crearOrdenCirugia(ordenCiru);
				
				qui.setOcupado(false);
				quirofanoEJB.editarQuierofano(qui);
				Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");
			}else{
				Messages.addFlashGlobalInfo("El quirofano a disponer de la cirugia se encuentra ocupado");
			}
			

		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}

	public void generarHospitalizacion() {
		try {

			Cama ca = generalEJB.buscarCama(cama.getIdCama());
			
			if(ca.isDisponibilidad()==true){

			Hospitalizacion hos = new Hospitalizacion(detalleHospi, motivo, ca);
			procedimientosEJB.crearHospitalizacion(hos);
			
			Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());
			Hospitalizacion buscarHos = generalEJB.buscarHopitalizacion(hos.getId());
			
			OrdenHospitalizacion ordenHos = new OrdenHospitalizacion(citaa, buscarHos);
			procedimientosEJB.crearOrdenHopitalizacion(ordenHos);
			
			ca.setDisponibilidad(false);
			quirofanoEJB.editarCamas(ca);
			
			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");
			}else{
				Messages.addFlashGlobalInfo("La cama a disponer de la hospitalizacion se encuentra ocupada");
			}
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public Causa getCausa() {
		return causa;
	}

	public void setCausa(Causa causa) {
		this.causa = causa;
	}

	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	public List<Patologia> getListaPatolgia() {
		return listaPatolgia;
	}

	public void setListaPatolgia(List<Patologia> listaPatolgia) {
		this.listaPatolgia = listaPatolgia;
	}

	public List<Causa> getListaCausas() {
		return listaCausas;
	}

	public void setListaCausas(List<Causa> listaCausas) {
		this.listaCausas = listaCausas;
	}

	public List<Sintoma> getListaSintomas() {
		return listaSintomas;
	}

	public void setListaSintomas(List<Sintoma> listaSintomas) {
		this.listaSintomas = listaSintomas;
	}

	public List<Tratamiento> getListaTratamiento() {
		return listaTratamiento;
	}

	public void setListaTratamiento(List<Tratamiento> listaTratamiento) {
		this.listaTratamiento = listaTratamiento;
	}

	public String getTextoDesPatologia() {
		return textoDesPatologia;
	}

	public void setTextoDesPatologia(String textoDesPatologia) {
		this.textoDesPatologia = textoDesPatologia;
	}

	public List<Cita> getListaCitasMedico() {
		return listaCitasMedico;
	}

	public void setListaCitasMedico(List<Cita> listaCitasMedico) {
		this.listaCitasMedico = listaCitasMedico;
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
	
	
	
	
	
	
}
