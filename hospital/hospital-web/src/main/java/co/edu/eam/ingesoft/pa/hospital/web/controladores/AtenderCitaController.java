package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.Date;
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
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.CausaPatologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Diagnostico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Examen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Hospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.ItemMedicamento;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.OrdenHospitalizacion;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.PatologiaSintoma;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.PatologiaTratamiento;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Quirofano;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.ResultadoExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Sintoma;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCirugia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoExamen;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoMedicamento;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Tratamiento;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GestionMedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PacienteEJB;
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

	private String detalleExam;

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

	private static List<OrdenExamen> listaExamenCar;

	private String motivo;

	private String detalleHospi;

	private static OrdenExamen orden;

	private String descripcionMedico;
	
	private List<TipoMedicamento> listaMed;
	
	private TipoMedicamento tipoMedicamento;
	
	private String cantidad;
	
	private String formula;

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

	@EJB
	private PacienteEJB pacienteEJB;
	
	

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
		listaMed = generalEJB.listaMedicamento();

	}

	public String AtenderCita(Cita doc) {
		cita = doc;
		cargarExamenes(doc.getPersona().getIdPersona());
		return "/paginas/seguro/Medico/AtenderCita.xhtml?faces-redirect=true";

	}

	public void obtenerOrden(OrdenExamen or) {
		orden = or;
	}

	public void cargarExamenes(Long ced) {
		// Paciente persona =
		// pacienteEJB.buscarPaciente(Long.parseLong(cedulaPaciente));
		// Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());

		listaExamenCar = procedimientosEJB.listarExamenes(ced);

	}

	public void descPatologia() {

		Patologia patolo = generalEJB.buscarPatologia(patologia.getIdPatologia());

		textoDesPatologia = patolo.getDescripcion();
	}



	public void generarResultadoExamen() {
		
		if (orden != null) {
		OrdenExamen ordenExam = procedimientosEJB.buscarOrdenExamen(orden.getIdOrdenExamen());
		
			Date fecha = new Date();
			ResultadoExamen resultado = new ResultadoExamen(detalleExam, fecha, ordenExam);

			procedimientosEJB.crearResultadoExamen(resultado);			
			//quirofanoEJB.eliminarOrden(ordenExam);
			Messages.addFlashGlobalInfo("Resultado generado!");
			
		} else {
			Messages.addFlashGlobalError("Por favor seleccione el examen a dar resultado");
		}

	}

	public void generarSintoma() {
		try {
			Sintoma sin = generalEJB.buscarSintoma(sintoma.getIdSintoma());
			Patologia pato = generalEJB.buscarPatologia(patologia.getIdPatologia());

			PatologiaSintoma ptSin = new PatologiaSintoma(pato, sin);
			procedimientosEJB.crearPatologiaSintoma(ptSin);

			Messages.addFlashGlobalInfo("Sintoma generado!");

		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	public void generarCausa() {
		try {

			Causa ca = generalEJB.buscarCausa(causa.getIdCausasPa());
			Patologia pato = generalEJB.buscarPatologia(patologia.getIdPatologia());

			CausaPatologia causaPa = new CausaPatologia(ca, pato);
			procedimientosEJB.crearPatologiaCausa(causaPa);

			Messages.addFlashGlobalInfo("Causa generado!");

		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	public void generarTratamiento() {
		try {

			Tratamiento trata = generalEJB.buscarTratamiento(tratamiento.getIdTratamiento());
			Patologia pato = generalEJB.buscarPatologia(patologia.getIdPatologia());

			PatologiaTratamiento patoloTrata = new PatologiaTratamiento(pato, trata);
			procedimientosEJB.crearPatologiaTratamiento(patoloTrata);

			Messages.addFlashGlobalInfo("Tratamiento generado!");
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	public void generarDiagnostico() {
		try {
			Patologia pato = generalEJB.buscarPatologia(patologia.getIdPatologia());
			Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());

			Diagnostico dig = new Diagnostico(citaa, pato, descripcionMedico);
			procedimientosEJB.crearDiagnostico(dig);

			citaa.setEstado(true);
			citaEJB.editarCita(citaa);
			Messages.addFlashGlobalInfo("Diagnostico generado!");

		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	public void generarExamen() {
		try {

			TipoExamen tipoExam = generalEJB.buscarTipoExamen(tipoExamen.getIdTipoExamenes());
			Examen ex = new Examen(tipoExam, descripcionExamen);
			procedimientosEJB.crearExamen(ex);

			Examen idExa = generalEJB.buscarIdExamen(ex.getIdExamen());
			// Integer exa = idExa.getIdExamen();
			//
			Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());
			// Integer cit = cita.getIdCita();

			OrdenExamen ordenema = new OrdenExamen(citaa, idExa);
			procedimientosEJB.crearOrdenExamen(ordenema);

			Messages.addFlashGlobalInfo("Examen generado!");

		} catch (Exception e) {

		}

	}

	public void generarCirugia() {
		try {
			TipoCirugia tipoC = generalEJB.buscarTipoCirugia(tipoCirugia.getIdTipoCirugia());
			Quirofano qui = quirofanoEJB.buscarQuirofano(quirofano.getId());

			if (qui.isOcupado() == true) {

				Cirugia ciru = new Cirugia(tipoC, descripcionInicio, descripcionFinal, qui);
				procedimientosEJB.crearCirugia(ciru);

				Cirugia busCiru = generalEJB.buscarCirugia(ciru.getId());
				Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());
				OrdenCirugia ordenCiru = new OrdenCirugia(citaa, busCiru);

				procedimientosEJB.crearOrdenCirugia(ordenCiru);

				Date fecha = new Date();

				qui.setFechaOcupado(fecha);
				qui.setOcupado(false);
				qui.setDetalleOcupacion(motivo);
				quirofanoEJB.editarQuierofano(qui);
				Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");
			} else {
				Messages.addFlashGlobalInfo("El quirofano a disponer de la cirugia se encuentra ocupado");
			}

		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}

	public void generarHospitalizacion() {
		try {

			Cama ca = generalEJB.buscarCama(cama.getIdCama());

			if (ca.isDisponibilidad() == true) {

				Hospitalizacion hos = new Hospitalizacion(detalleHospi, motivo, ca);
				procedimientosEJB.crearHospitalizacion(hos);

				Cita citaa = generalEJB.buscarIdCita(cita.getIdCita());
				Hospitalizacion buscarHos = generalEJB.buscarHopitalizacion(hos.getId());

				OrdenHospitalizacion ordenHos = new OrdenHospitalizacion(citaa, buscarHos);
				procedimientosEJB.crearOrdenHopitalizacion(ordenHos);

				ca.setDisponibilidad(false);
				quirofanoEJB.editarCamas(ca);

				Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");
			} else {
				Messages.addFlashGlobalInfo("La cama a disponer de la hospitalizacion se encuentra ocupada");
			}
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}
	
	
	public void agregarMedicamento(){
		
		ItemMedicamento tipoM = new ItemMedicamento();
		tipoM.setIdCita(cita);
		tipoM.setCantidadResetada(Integer.parseInt(cantidad));
		tipoM.setEstado(true);
		tipoM.setFormula(formula);
		tipoM.setTipoMedicamento(tipoMedicamento);
		
		generalEJB.agregarMed(tipoM);
		
		Messages.addFlashGlobalInfo("Medicamento agregado con exito");

		
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

	public List<OrdenExamen> getListaExamenCar() {
		return listaExamenCar;
	}

	public void setListaExamenCar(List<OrdenExamen> listaExamenCar) {
		this.listaExamenCar = listaExamenCar;
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

	public String getDescripcionMedico() {
		return descripcionMedico;
	}

	public void setDescripcionMedico(String descripcionMedico) {
		this.descripcionMedico = descripcionMedico;
	}

	public SessionController getUsuarioSesion() {
		return usuarioSesion;
	}

	public void setUsuarioSesion(SessionController usuarioSesion) {
		this.usuarioSesion = usuarioSesion;
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

	public List<Quirofano> getListarQuirofanos() {
		return listarQuirofanos;
	}

	public void setListarQuirofanos(List<Quirofano> listarQuirofanos) {
		this.listarQuirofanos = listarQuirofanos;
	}

	public String getDetalleExam() {
		return detalleExam;
	}

	public void setDetalleExam(String detalleExam) {
		this.detalleExam = detalleExam;
	}

	public OrdenExamen getOrden() {
		return orden;
	}

	public void setOrden(OrdenExamen orden) {
		this.orden = orden;
	}

	public List<TipoMedicamento> getListaMed() {
		return listaMed;
	}

	public void setListaMed(List<TipoMedicamento> listaMed) {
		this.listaMed = listaMed;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}
	
	

}
