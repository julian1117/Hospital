package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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

@Named(value = "atenderCitaController")
@ViewScoped
public class AtenderCitaController implements Serializable {

	@Pattern(regexp = "[0-9]*", message = "Solo numeros")
	@Length(min = 8, max = 11, message = "La longitud debe ser de 8 a 11 numer")
	private String cedulaPaciente;

	private String textoDesPatologia;
	
	private Cita cita;

	private Patologia patologia;

	private Causa causa;

	private Sintoma sintoma;

	private Tratamiento tratamiento;

	private List<Cita> listaCita;

	private List<Patologia> listaPatolgia;

	private List<Causa> listaCausas;

	private List<Sintoma> listaSintomas;

	private List<Tratamiento> listaTratamiento;

	
	
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
	 }
	
	public void descPatologia(){
		
		Patologia patolo = generalEJB.buscarPatologia(patologia.getIdPatologia());
		
		textoDesPatologia = patolo.getDescripcion();
	}

	/**
	 * Busca todas las citas del apciente que esten como no atendidas
	 */
	public void buscarPaciente() {

		listaCita = citaEJB.listCitaPaciente(Long.parseLong(cedulaPaciente));
		if (listaCita.isEmpty()) {
			Messages.addFlashGlobalError("ERROR /nEl paciente no tiene citas regsitradas en el momento");
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

	public List<Cita> getListaCita() {
		return listaCita;
	}

	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
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
	

}
