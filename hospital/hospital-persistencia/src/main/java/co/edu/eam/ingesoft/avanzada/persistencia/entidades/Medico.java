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
@Table(name="MEDICOS")
@AttributeOverride(name="idPersona",column=@Column(name="PERSONAS_Id"))
public class Medico  extends Persona implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="ESPECIALIZACIONES_Id",nullable=true)
	private Especializacione especializaciones;
	

	public Medico() {
		super();
	}
	
	

	public Medico(Especializacione especializaciones) {
		super();
		this.especializaciones = especializaciones;
	}



	public Especializacione getEspecializaciones() {
		return especializaciones;
	}

	public void setEspecializaciones(Especializacione especializaciones) {
		this.especializaciones = especializaciones;
	}
	
}
