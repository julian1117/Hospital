package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Agenda;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.HoraCita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@Named(value = "citaController")
@ViewScoped
public class CitaControlador implements Serializable {

	@Pattern(regexp="[0-9]*",message="Solo numeros")
	@Length(min=8,max=10,message="Longitus de 8 a 10")
	private String cedulaPaciente;

	private Medico medico;

	private HoraCita horaCita;

	private List<Medico> listaMedicos;

	private TipoCita tipoCita;

	private List<TipoCita> listTipoCita;

	private List<Cita> listaCita;

	private List<HoraCita> listaHorasAgenda;

	private String fecha;

	private Date fechaCita;

	@EJB
	private MedicoEJB medicoEJB;

	@EJB
	private CitaEJB citaEJB;

	@EJB
	private GeneralEJB generalEJB;

	@PostConstruct
	public void inicializar() {
		listaMedicos = medicoEJB.listaMedicos();
		listTipoCita = citaEJB.listaTipoCita();
		listaHorasAgenda = generalEJB.listaHora();
	}

	/**
	 * Busca todas las citas del apciente que esten como no atendidas
	 */
	public void buscarPaciente() {
		listaCita = citaEJB.listCitaPaciente(Long.parseLong(cedulaPaciente));
		if (listaCita.isEmpty()) {
			Messages.addFlashGlobalError("El paciente no tiene citas regsitradas en el momento");
		}
	}

	/**
	 * Registrar cita del paciente
	 * 
	 * @throws ParseException
	 */
	public void asignarCita() {
		try {
			fechaCita = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
			
			Paciente paciente = citaEJB.buscarPaciente(Long.parseLong(cedulaPaciente));
			
//			Agenda agenda = new Agenda();
//			agenda.setMedico(medico);
//			agenda.setFechaCita(fechaCita);
//			agenda.setConsultorio(null);
//			agenda.setHora(horaCita);
//			
//			Cita cita = new Cita();
//			cita.setPersona(paciente);
//			cita.setTipoCita(tipoCita);
//			cita.setAgenda(agenda);
//			
//			citaEJB.crearCita(agenda,cita);
//			listaCita = citaEJB.listCitaPaciente(Long.parseLong(cedulaPaciente));

			Messages.addFlashGlobalInfo("Se agendo la cita con exito");
			
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	/**
	 * Elimina cita del paciente
	 * 
	 * @param cita
	 */
	public void eliminarCita(Cita cita) {
		try {
			citaEJB.eliminarCitaPaciente(cita);
			listaCita = citaEJB.listCitaPaciente(Long.parseLong(cedulaPaciente));

			Messages.addFlashGlobalInfo("La cita fue eliminada con exito");
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public List<TipoCita> getListTipoCita() {
		return listTipoCita;
	}

	public void setListTipoCita(List<TipoCita> listTipoCita) {
		this.listTipoCita = listTipoCita;
	}

	public String getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(String cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public List<Cita> getListaCita() {
		return listaCita;
	}

	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public HoraCita getHoraCita() {
		return horaCita;
	}

	public void setHoraCita(HoraCita horaCita) {
		this.horaCita = horaCita;
	}

	public List<HoraCita> getListaHorasAgenda() {
		return listaHorasAgenda;
	}

	public void setListaHorasAgenda(List<HoraCita> listaHorasAgenda) {
		this.listaHorasAgenda = listaHorasAgenda;
	}

}
