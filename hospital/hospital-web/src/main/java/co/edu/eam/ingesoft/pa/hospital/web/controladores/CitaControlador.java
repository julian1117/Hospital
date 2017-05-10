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
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Agenda;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Especializacione;
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

	@Pattern(regexp = "[0-9]*", message = "Solo numeros")
	@Length(min = 5, max = 10, message = "Campo cedula -Longitud de 5 a 10")
	private String cedulaPacienteLis;

	@Pattern(regexp = "[0-9]*", message = "Solo numeros")
	@Length(min = 5, max = 10, message = "Campo cedula -Longitud de 5 a 10")
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

	private Agenda agenda;

	private List<Agenda> listaAgenda;
	
	private  Especializacione especializacion;
	
	private List<Especializacione> listaEspecializacion;	

	@EJB
	private MedicoEJB medicoEJB;

	@EJB
	private CitaEJB citaEJB;

	@EJB
	private GeneralEJB generalEJB;

	@PostConstruct
	public void inicializar() {
		listTipoCita = citaEJB.listaTipoCita();
		listaHorasAgenda = generalEJB.listaHora();
		listaEspecializacion = generalEJB.listarEspecializacione();
	}

	/**
	 * Busca todas las citas del apciente que esten como no atendidas
	 */
	public void buscarPaciente() {
		listaCita = citaEJB.listaCitaPaciente(Long.parseLong(cedulaPacienteLis));
		if (listaCita.isEmpty()) {
			Messages.addFlashGlobalError("El paciente no tiene citas regsitradas en el momento");
		}
	}

	public void medicoEspe(){
		listaMedicos = medicoEJB.listaMedicosEspe(especializacion.getIdEspecializacion());
	}
	
	/**
	 * Registrar cita del paciente
	 * 
	 * @throws ParseException
	 */
	public void asignarCita() {
		try {
			// fechaCita = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);

			Paciente paciente = citaEJB.buscarPaciente(Long.parseLong(cedulaPaciente));
			if (paciente != null) {
				Agenda agendaM = citaEJB.buscarAgenda(agenda.getId());

				TipoCita tipoCi = citaEJB.buscarTipoDeCita(tipoCita.getIdTipoCita());

				HoraCita hC = generalEJB.buscarHoraCita(horaCita.getId());

				Cita cita = new Cita();
				cita.setPersona(paciente);
				cita.setTipoCita(tipoCi);
				cita.setAgenda(agendaM);
				cita.setHoraCita(hC);
				cita.setEstado(false);

				citaEJB.crearCita(cita);

				listaCita = citaEJB.listaCitaPaciente(Long.parseLong(cedulaPaciente));

				Messages.addFlashGlobalInfo("Se agendo la cita con exito");
			} else {
				Messages.addFlashGlobalError("La cedula ingresa no corresponde a un usuario registrado");
			}
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
			listaCita = citaEJB.listaCitaPaciente(cita.getPersona().getIdPersona());

			Messages.addFlashGlobalInfo("La cita fue eliminada con exito");
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}

	/**
	 * Lista de agendas de un medico expecifico
	 */
	public void agendaMedico() {
		listaAgenda = citaEJB.listaAgendaMedico(medico.getIdPersona());
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

	public List<Agenda> getListaAgenda() {
		return listaAgenda;
	}

	public void setListaAgenda(List<Agenda> listaAgenda) {
		this.listaAgenda = listaAgenda;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String getCedulaPacienteLis() {
		return cedulaPacienteLis;
	}

	public void setCedulaPacienteLis(String cedulaPacienteLis) {
		this.cedulaPacienteLis = cedulaPacienteLis;
	}

	public Especializacione getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(Especializacione especializacion) {
		this.especializacion = especializacion;
	}

	public List<Especializacione> getListaEspecializacion() {
		return listaEspecializacion;
	}

	public void setListaEspecializacion(List<Especializacione> listaEspecializacion) {
		this.listaEspecializacion = listaEspecializacion;
	}

	
}
