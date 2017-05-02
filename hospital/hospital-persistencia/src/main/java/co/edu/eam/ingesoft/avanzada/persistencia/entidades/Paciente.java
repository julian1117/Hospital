package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

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


	
	
	public Paciente(Long idPersona, String nombre, String apellido, Date fechaNacimiento, String telefono,
			String direccion, String tipoUsuario, String email, String sexo, Ciudad ciudad, Eps eps) {
		super(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion, tipoUsuario, email, sexo, ciudad);
		this.eps = eps;
	}




	public Paciente(Eps eps) {
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
