package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Horarios")
public class Horario implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id_Horarios",nullable=false)
	private Integer idHorarios;
	
	@Column(name="Hora_Inicio",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date horaInicio;
	
	@Column(name="Hora_Final",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date horaFinal;

	public Horario() {
		super();
	}

	public Horario(int idHorarios, Date horaInicio, Date horaFinal) {
		super();
		this.idHorarios = idHorarios;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}

	public int getIdHorarios() {
		return idHorarios;
	}

	public void setIdHorarios(int idHorarios) {
		this.idHorarios = idHorarios;
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
	
	
	
	
}
