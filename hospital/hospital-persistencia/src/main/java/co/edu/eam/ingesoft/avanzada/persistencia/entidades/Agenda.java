package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Agendas")
public class Agenda implements Serializable{
	
	@Id
	@Column(name="Id_Agenda",nullable=false)
	private int id;
	
	
	@ManyToOne
	@JoinColumn(name="Horarios",nullable=false)
	private Horario horarios;
	
	
	@ManyToOne
	@JoinColumn(name="Medicos",nullable=false)
	private Persona idPersona;
	//SE CAMBIO EL ATRIBUTO private Medico medico; ya que el medico es una herencia de persona
	
	public Agenda() {
		super();
	}

	public Agenda(int id, Horario horarios, Persona idPersona) {
		super();
		this.id = id;
		this.horarios = horarios;
		this.idPersona = idPersona;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Horario getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario horarios) {
		this.horarios = horarios;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

}
