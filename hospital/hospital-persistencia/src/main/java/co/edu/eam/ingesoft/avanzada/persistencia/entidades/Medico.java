package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="MEDICOS")
@NamedQueries({
	@NamedQuery(name=Medico.LISTA_MEDICOS,query="SELECT m FROM Medico m"),
	@NamedQuery(name=Medico.LISTA_MEDICOS_ESP,query="SELECT m FROM Medico m WHERE m.especializaciones.idEspecializacion=?1")
})
public class Medico  extends Persona implements Serializable{
	
	public static final String LISTA_MEDICOS = "Medico.listaMed";
	
	public static final String LISTA_MEDICOS_ESP = "Medico.listaMedEsp";
	
	@ManyToOne
	@JoinColumn(name="ESPECIALIZACIONES_Id",nullable=true)
	private Especializacione especializaciones;
	

	public Medico() {
		super();
	}
	
	public Medico(Long idPersona, String nombre, String apellido, Date fechaNacimiento, String telefono,
			String direccion, Roll roll, String email, String sexo, Ciudad ciudad, Especializacione especializaciones) {
		super(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion, roll, email, sexo, ciudad);
		this.especializaciones = especializaciones;
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
