package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Agendas")
public class Agenda implements Serializable{
	
	@Id
	@Column(name="Id_Agenda")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="Horarios")
	private Horario horarios;
	
	@ManyToOne
	@JoinColumn(name="Medicos")
	private Medico medicos;

	public Agenda() {
		super();
	}

	public Agenda(int id, Horario horarios, Medico medicos) {
		super();
		this.id = id;
		this.horarios = horarios;
		this.medicos = medicos;
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

	public Medico getMedicos() {
		return medicos;
	}

	public void setMedicos(Medico medicos) {
		this.medicos = medicos;
	}
	
	
}
