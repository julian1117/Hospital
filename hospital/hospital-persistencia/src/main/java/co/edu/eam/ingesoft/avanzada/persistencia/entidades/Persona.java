package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;

@Entity
@Table(name="Personas")
public class Persona implements Serializable {
	
	@Id
	@Column(name="Id_Persona",nullable=false)
	private Integer idPersona;
	
	@Column(name="Nombre",nullable=false,length=25)
	private String nombre;
	
	@Column(name="Apellido",nullable=false,length=25)
	private String apellido;
	
	@Column(name="Fecha_Nacimiento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name="Telefono",nullable=false,length=10)
	private String telefono;
	
	@Column(name="Direccion",nullable=false,length=40)
	private String direccion;
	
	@Column(name="Tipo_Usuario",nullable=false,length=30)
	private String tipoUsuario;
	
	@Column(name="Email", unique=true,nullable=false,length=50)
	private String email;
	
	@Column(name="Sexo",nullable=false,length=1)
	private boolean sexo;
	
	@Column(name="Contrasenia",nullable=false,length=20)
	private String contrasenia;
	
	@ManyToOne
	@JoinColumn(name="Ciudad",nullable=false)
	private Ciudad ciudad;

	public Persona() {
		super();
	}

	public Persona(int idPersona, String nombre, String apellido, Date fechaNacimiento, String telefono,
			String direccion, String tipoUsuario, String email, boolean sexo, String contrasenia, Ciudad ciudad) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipoUsuario = tipoUsuario;
		this.email = email;
		this.sexo = sexo;
		this.contrasenia = contrasenia;
		this.ciudad = ciudad;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSexo() {
		return sexo;
	}

	public void setSexo(boolean sexo) {
		this.sexo = sexo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	
	
	

}
