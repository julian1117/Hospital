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

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Causa;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Sintoma;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Tratamiento;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GestionMedicoEJB;

@Named(value = "atenderCitaController")
@ViewScoped
public class AtenderCitaController implements Serializable {

//	@Pattern(regexp = "[0-9]*", message = "Solo numeros")
//	@Length(min = 8, max = 11, message = "La longitud debe ser de 8 a 11 numer")
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
		listaCitasMedico = medicoGestionEJB.listaCitaMedico(
				usuarioSesion.getUse().getIdPersona().getIdPersona());
	 }
	
	
	public String AtenderCita(Cita citaAt){	
		cita = citaAt;		
		return "/paginas/seguro/Medico/AtenderCita.xhtml?faces-redirect=true";
	}
	
	public void descPatologia(){
		
		Patologia patolo = generalEJB.buscarPatologia(patologia.getIdPatologia());
		
		textoDesPatologia = patolo.getDescripcion();
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
	

}
