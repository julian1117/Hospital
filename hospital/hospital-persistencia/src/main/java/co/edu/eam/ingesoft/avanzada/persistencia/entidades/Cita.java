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
	@Column(name="id_Cita",nullable=false)
	private Integer idCita;
	
	@ManyToOne
	@JoinColumn(name="Agenda",nullable=false)
	private Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name="Tipo_Cita",nullable=false)
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name="cita",nullable=true)
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="Paciente",nullable=false)
	private Persona persona;
	
	@Column(name="Estado")
	private boolean estado;

	public Cita() {
		super();
	}

	public Cita(Integer idCita, Agenda agenda, TipoCita tipoCita, Cita cita, Persona persona, boolean estado) {
		super();
		this.idCita = idCita;
		this.agenda = agenda;
		this.tipoCita = tipoCita;
		this.cita = cita;
		this.persona = persona;
		this.estado = estado;
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
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

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
	
}
