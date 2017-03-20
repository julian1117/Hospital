package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Pacientes")
public class Paciente  implements Serializable {

	@ManyToOne
	@JoinColumn(name = "Eps", nullable = false)
	private Eps eps;

	@Id
	@OneToOne
	@JoinColumn(name = "id_persona", unique = true, nullable = false)
	private Persona persona;

	public Paciente() {
		super();
	}

	public Paciente(Eps eps, Persona persona) {
		super();
		this.eps = eps;
		this.persona = persona;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
