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
public class Medico extends Persona implements Serializable{

	
	@ManyToOne
	@JoinColumn(name="Especializaciones")
	private Especializacione especializaciones;
	
	@OneToOne
	@JoinColumn(name="Id_Persona")
	private Persona idPersona;

	public Medico() {
		super();
	}

	public Medico(Especializacione especializaciones, Persona idPersona) {
		super();
		this.especializaciones = especializaciones;
		this.idPersona = idPersona;
	}

	public Especializacione getEspecializaciones() {
		return especializaciones;
	}

	public void setEspecializaciones(Especializacione especializaciones) {
		this.especializaciones = especializaciones;
	}

//	public Persona getIdPersona() {
//		return idPersona;
//	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	
	
	
	
}
