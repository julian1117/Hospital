package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ACCESOS")
@NamedQuery(name=Acceso.LISTA_ACCESO,query="SELECT a FROM Acceso a WHERE a.roll.id=?1")
public class Acceso {
	
	public static final String LISTA_ACCESO = "Acceso.listaAcc";
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Roll roll;
	
	@Column(name="links")
	private String links;
	
	@Column(name="nombre")
	private String nombre;

	
	
	public Acceso() {
		super();
	}

	public Acceso(Integer id, Roll roll, String links, String nombre) {
		super();
		this.id = id;
		this.roll = roll;
		this.links = links;
		this.nombre = nombre;
	}







	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Roll getRoll() {
		return roll;
	}

	public void setRoll(Roll roll) {
		this.roll = roll;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Acceso other = (Acceso) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
