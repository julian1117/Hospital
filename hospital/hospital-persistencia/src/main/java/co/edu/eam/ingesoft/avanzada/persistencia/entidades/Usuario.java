package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="USUARIOS")
@NamedQuery(name=Usuario.USUARIO,query="SELECT us FROM Usuario us WHERE us.nombreUsuario=?1")
public class Usuario implements Serializable{

	public static final String USUARIO = "Usuario.listUs";
	
	
	@OneToOne//(fetch=FetchType.EAGER)
	@JoinColumn(name="PERSONAS_Id")	
	private Persona idPersona;
	
	@Id
	@Column(name="nombre_usu")
	private String nombreUsuario;
	
	@Column(name="contrasenia")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreUsuario == null) ? 0 : nombreUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (nombreUsuario == null) {
			if (other.nombreUsuario != null)
				return false;
		} else if (!nombreUsuario.equals(other.nombreUsuario))
			return false;
		return true;
	}
	
	
	
}


/*
 * 
 * select
10:57:32,161 INFO  [stdout] (default task-57)         usuario0_.nombre_usu as nombre_usu1_34_,
10:57:32,161 INFO  [stdout] (default task-57)         usuario0_.contrasenia as contrasenia2_34_,
10:57:32,161 INFO  [stdout] (default task-57)         usuario0_.PERSONAS_Id as PERSONAS_Id3_34_ 
10:57:32,161 INFO  [stdout] (default task-57)     from
10:57:32,161 INFO  [stdout] (default task-57)         USUARIOS usuario0_ 
10:57:32,161 INFO  [stdout] (default task-57)     where
10:57:32,161 INFO  [stdout] (default task-57)         usuario0_.nombre_usu=?

10:57:32,170 INFO  [stdout] (default task-57) Hibernate: 
10:57:32,170 INFO  [stdout] (default task-57)     select
10:57:32,170 INFO  [stdout] (default task-57)         persona0_.PERSONAS_ID as PERSONAS_ID1_23_0_,
10:57:32,170 INFO  [stdout] (default task-57)         persona0_.Apellido as Apellido2_23_0_,
10:57:32,170 INFO  [stdout] (default task-57)         persona0_.CIUDAD_Id as CIUDAD_Id10_23_0_,
10:57:32,170 INFO  [stdout] (default task-57)         persona0_.Direccion as Direccion3_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_.Email as Email4_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_.Fecha_nacimiento as Fecha_nacimiento5_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_.Nombre as Nombre6_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_.Sexo as Sexo7_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_.Telefono as Telefono8_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_.Tipo_us as Tipo_us9_23_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_1_.ESPECIALIZACIONES_Id as ESPECIALIZACIONES_2_16_0_,
10:57:32,171 INFO  [stdout] (default task-57)         persona0_2_.EPS_Id as EPS_Id2_19_0_,
10:57:32,171 INFO  [stdout] (default task-57)         case 
10:57:32,171 INFO  [stdout] (default task-57)             when persona0_1_.PERSONAS_ID is not null then 1 
10:57:32,171 INFO  [stdout] (default task-57)             when persona0_2_.PERSONAS_ID is not null then 2 
10:57:32,172 INFO  [stdout] (default task-57)             when persona0_.PERSONAS_ID is not null then 0 
10:57:32,172 INFO  [stdout] (default task-57)         end as clazz_0_,
10:57:32,172 INFO  [stdout] (default task-57)         ciudad1_.Id as Id1_6_1_,
10:57:32,172 INFO  [stdout] (default task-57)         ciudad1_.DEPARTAMENTO_Id as DEPARTAMENTO_Id3_6_1_,
10:57:32,172 INFO  [stdout] (default task-57)         ciudad1_.Nombre as Nombre2_6_1_,
10:57:32,172 INFO  [stdout] (default task-57)         departamen2_.Id as Id1_8_2_,
10:57:32,172 INFO  [stdout] (default task-57)         departamen2_.PAIS_Id as PAIS_Id3_8_2_,
10:57:32,172 INFO  [stdout] (default task-57)         departamen2_.Nombre as Nombre2_8_2_,
10:57:32,172 INFO  [stdout] (default task-57)         pais3_.Id as Id1_20_3_,
10:57:32,172 INFO  [stdout] (default task-57)         pais3_.Nombre_p as Nombre_p2_20_3_,
10:57:32,172 INFO  [stdout] (default task-57)         especializ4_.Id as Id1_11_4_,
10:57:32,173 INFO  [stdout] (default task-57)         especializ4_.Nombre_especializacion as Nombre_especializa2_11_4_,
10:57:32,173 INFO  [stdout] (default task-57)         eps5_.Id as Id1_10_5_,
10:57:32,173 INFO  [stdout] (default task-57)         eps5_.Nombre as Nombre2_10_5_,
10:57:32,173 INFO  [stdout] (default task-57)         eps5_.Prepagada as Prepagada3_10_5_ 
10:57:32,173 INFO  [stdout] (default task-57)     from
10:57:32,173 INFO  [stdout] (default task-57)         PERSONAS persona0_ 
10:57:32,174 INFO  [stdout] (default task-57)     left outer join
10:57:32,174 INFO  [stdout] (default task-57)         MEDICOS persona0_1_ 
10:57:32,174 INFO  [stdout] (default task-57)             on persona0_.PERSONAS_ID=persona0_1_.PERSONAS_ID 
10:57:32,174 INFO  [stdout] (default task-57)     left outer join
10:57:32,174 INFO  [stdout] (default task-57)         PACIENTES persona0_2_ 
10:57:32,174 INFO  [stdout] (default task-57)             on persona0_.PERSONAS_ID=persona0_2_.PERSONAS_ID 
10:57:32,174 INFO  [stdout] (default task-57)     left outer join
10:57:32,175 INFO  [stdout] (default task-57)         CIUDAD ciudad1_ 
10:57:32,175 INFO  [stdout] (default task-57)             on persona0_.CIUDAD_Id=ciudad1_.Id 
10:57:32,175 INFO  [stdout] (default task-57)     left outer join
10:57:32,175 INFO  [stdout] (default task-57)         DEPARTAMENTO departamen2_ 
10:57:32,175 INFO  [stdout] (default task-57)             on ciudad1_.DEPARTAMENTO_Id=departamen2_.Id 
10:57:32,175 INFO  [stdout] (default task-57)     left outer join
10:57:32,175 INFO  [stdout] (default task-57)         PAIS pais3_ 
10:57:32,175 INFO  [stdout] (default task-57)             on departamen2_.PAIS_Id=pais3_.Id 
10:57:32,175 INFO  [stdout] (default task-57)     left outer join
10:57:32,175 INFO  [stdout] (default task-57)         ESPECIALIZACIONES especializ4_ 
10:57:32,176 INFO  [stdout] (default task-57)             on persona0_1_.ESPECIALIZACIONES_Id=especializ4_.Id 
10:57:32,176 INFO  [stdout] (default task-57)     left outer join
10:57:32,176 INFO  [stdout] (default task-57)         EPS eps5_ 
10:57:32,176 INFO  [stdout] (default task-57)             on persona0_2_.EPS_Id=eps5_.Id 
10:57:32,176 INFO  [stdout] (default task-57)     where
10:57:32,176 INFO  [stdout] (default task-57)         persona0_.PERSONAS_ID=?
 * 
 */

