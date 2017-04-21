package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="Usuario")
@NamedQuery(name=Usuario.USUARIO,query="SELECT u FROM Usuario u WHERE u.nombreUsuario=?1")
public class Usuario implements Serializable{

	public static final String USUARIO = "Usuario.listUs";
	
	@Id
	@JoinColumn(name="Id_Persona")
	private Persona idPersona;
	
	@Column(name="Nombre_Usuario")
	private String nombreUsuario;
	
	@Column(name="Contrasenia")
	private String contrasenia;

	public Usuario() {
		super();
	}

	public Usuario(Persona idPersona, String nombreUsuario, String contrasenia) {
		super();
		this.idPersona = idPersona;
		this.nombreUsuario = nombreUsuario;
		this.contrasenia = contrasenia;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
	
	
}
