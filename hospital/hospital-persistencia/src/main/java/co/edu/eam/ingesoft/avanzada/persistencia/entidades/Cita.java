package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CITAS")
@NamedQuery(name=Cita.LISTA_CITAS_PACIENTE,query="SELECT c FROM Cita c WHERE c.persona.idPersona=?1")
public class Cita implements Serializable{

	public static final String LISTA_CITAS_PACIENTE = "Cita.listaCitaPaciente";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idCita;
	
	@ManyToOne
	@JoinColumn(name="AGENDAS_Id",nullable=false)
	private Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name="TIPOS_CITAS_Id",nullable=false)
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=true)
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="PACIENTES_PERSONA_Id",nullable=false)
	private Paciente persona;
	
	@Column(name="esteado")
	private boolean estado;

	public Cita() {
		super();
	}

	public Cita(Integer idCita, Agenda agenda, TipoCita tipoCita, Cita cita, Paciente persona, boolean estado) {
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

	public Paciente getPersona() {
		return persona;
	}

	public void setPersona(Paciente persona) {
		this.persona = persona;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	
	
	
}
