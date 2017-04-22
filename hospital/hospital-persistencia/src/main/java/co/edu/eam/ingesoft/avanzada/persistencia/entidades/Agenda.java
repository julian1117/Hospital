package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AGENDAS")
public class Agenda implements Serializable{
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer id;
	
	@Column(name="Hora_inicio",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date horaInicio;
	
	@Column(name="Hora_final",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date horaFinal;
	
	@ManyToOne
	@JoinColumn(name="MEDICOS_PERSONAS_Id",nullable=false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="CONSULTORIOS_id",nullable=false)
	private Consultorio consultorio;
	
	public Agenda() {
		super();
	}

	public Agenda(Integer id, Date horaInicio, Date horaFinal, Medico medico, Consultorio consultorio) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.medico = medico;
		this.consultorio = consultorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	
	

	

}
