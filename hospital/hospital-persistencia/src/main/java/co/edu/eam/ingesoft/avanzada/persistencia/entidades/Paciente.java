package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTES")
//@AttributeOverride(name="idPersona",column=@Column(name="PERSONA_Id"))
public class Paciente extends Persona  implements Serializable {

	@ManyToOne
	@JoinColumn(name = "EPS_Id", nullable = false)
	private Eps eps;

	

	public Paciente() {
		super();
	}

	/**
	 * constructor
	 * @param eps
	 * @param persona
	 */
	public Paciente(Eps eps, Persona persona) {
		super();
		this.eps = eps;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	
}
