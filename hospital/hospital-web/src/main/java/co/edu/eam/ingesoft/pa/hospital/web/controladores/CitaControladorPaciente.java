package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.ParseException;
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

@Named(value = "citaControllerPaciente")
@ViewScoped
public class CitaControladorPaciente implements Serializable {
	
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
	
	@Inject
	private SessionController usuarioSesion;

	@PostConstruct
	public void inicializar() {
		listTipoCita = citaEJB.listaTipoCita();
		listaHorasAgenda = generalEJB.listaHora();
		listaEspecializacion = generalEJB.listarEspecializacione();
		// = medicoEJB.listaMedicosEspe(especializacion.getIdEspecializacion());

		cedulaPaciente=String.valueOf(usuarioSesion.getUse().getIdPersona().getIdPersona());
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
