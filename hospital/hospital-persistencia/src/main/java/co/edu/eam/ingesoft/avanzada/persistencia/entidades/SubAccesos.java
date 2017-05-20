package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SUB_ACCESOS")
public class SubAccesos implements Serializable{
	
	@Id
	@Column(name="ud")
	private Integer id;
	
	@Column(name="sub_links")
	private String subLinks;
	
	@Column(name="nombre")
	private String nombre;
	

	public SubAccesos() {
		super();
	}

	public SubAccesos(Integer id, String subLinks, String nombre) {
		super();
		this.id = id;
		this.subLinks = subLinks;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubLinks() {
		return subLinks;
	}

	public void setSubLinks(String subLinks) {
		this.subLinks = subLinks;
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
		SubAccesos other = (SubAccesos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
