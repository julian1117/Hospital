package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Medicos")
public class Medicos implements Serializable{

	@Id
	@Column(name="Id_Medico")
	private int idMedico;
	
	@ManyToOne
	@JoinColumn(name="Especializaciones")
	private Especializaciones especializaciones;
	
	@OneToOne
	@JoinColumn(name="Id_Persona")
	private Personas idPersona;

	public Medicos() {
		super();
	}

	public Medicos(int idMedico, Especializaciones especializaciones, Personas idPersona) {
		super();
		this.idMedico = idMedico;
		this.especializaciones = especializaciones;
		this.idPersona = idPersona;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public Especializaciones getEspecializaciones() {
		return especializaciones;
	}

	public void setEspecializaciones(Especializaciones especializaciones) {
		this.especializaciones = especializaciones;
	}

	public Personas getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Personas idPersona) {
		this.idPersona = idPersona;
	}
	
	
	
}
