package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;

import co.edu.eam.ingesoft.avanzada.persistencia.enumeraciones.TipoUsuario;

@Entity
@Table(name="PERSONAS")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona implements Serializable {
	
	@Id
	@Column(name="PERSONAS_ID",nullable=false)
	private Long idPersona;
	
	@Column(name="Nombre",nullable=false,length=25)
	private String nombre;
	
	@Column(name="Apellido",nullable=false,length=25)
	private String apellido;
	
	@Column(name="Fecha_nacimiento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name="Telefono",nullable=false,length=10)
	private String telefono;
	
	@Column(name="Direccion",nullable=false,length=40)
	private String direccion;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Tipo_us",nullable=false,length=30)
	private TipoUsuario tipoUsuario;
	
	@Column(name="Email", unique=true,nullable=false,length=50)
	private String email;
	
	@Column(name="Sexo",nullable=false,length=1)
	private String sexo;
	

	@ManyToOne
	@JoinColumn(name="CIUDAD_Id",nullable=false)
	private Ciudad ciudad;

	public Persona() {
		super();
	}

	public Persona(Long idPersona, String nombre, String apellido, Date fechaNacimiento, String telefono,
			String direccion, TipoUsuario tipoUsuario, String email, String sexo, Ciudad ciudad) {
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
		this.ciudad = ciudad;
	}


	public Long getIdPersona() {
		return idPersona;
	}




	public void setIdPersona(Long idPersona) {
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

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		return true;
	}

	
	
	
	
	

}
