package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="Medicos")
@AttributeOverride(name="idPersona",column=@Column(name="PERSONA_Id"))
public class Medico  extends Persona implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="Especializaciones",nullable=true)
	private Especializacione especializaciones;
	

	public Medico() {
		super();
	}

	public Especializacione getEspecializaciones() {
		return especializaciones;
	}

	public void setEspecializaciones(Especializacione especializaciones) {
		this.especializaciones = especializaciones;
	}
	
}
