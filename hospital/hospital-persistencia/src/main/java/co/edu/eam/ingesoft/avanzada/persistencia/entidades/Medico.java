package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="MEDICOS")
//@AssociationOverride(name="idPersona", joinColumns=@JoinColumn(name="PERSONAS_id"))
@NamedQuery(name=Medico.LISTA_MEDICOS,query="SELECT m FROM Medico m")
public class Medico  extends Persona implements Serializable{
	
	public static final String LISTA_MEDICOS = "Medico.listaMed";
	
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
