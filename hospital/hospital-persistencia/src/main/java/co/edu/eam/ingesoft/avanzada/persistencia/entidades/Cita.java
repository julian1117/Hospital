package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Citas")
public class Cita implements Serializable{

	@Id
	@Column(name="id_Cita")
	private int idCita;
	
	@ManyToOne
	@JoinColumn(name="Agenda")
	private Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name="Tipo_Cita")
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name="cita")
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="Paciente")
	private Paciente paciente;

	public Cita() {
		super();
	}

	public Cita(int idCita, Agenda agenda, TipoCita tipoCita, Cita cita, Paciente paciente) {
		super();
		this.idCita = idCita;
		this.agenda = agenda;
		this.tipoCita = tipoCita;
		this.cita = cita;
		this.paciente = paciente;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
