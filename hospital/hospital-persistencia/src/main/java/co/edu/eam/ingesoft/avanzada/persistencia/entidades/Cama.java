package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NamedQuery(name=Cama.LISTAR_CAMA,query="SELECT c FROM Cama c")
@Table(name="CAMAS")
public class Cama implements Serializable{
	
	public static final String LISTAR_CAMA="Cama.listar";

	@Id
	@Column(name="Id",nullable=false)
	private Integer idCama;
	
	@Column(name="Disponibilidad",nullable=false)
	private boolean disponibilidad;
		
	@Column(name="descripcion",nullable=false)
	private String descripcion;

	public Cama() {
		super();
	}

	public Cama(Integer idCama, boolean disponibilidad, String descripcion) {
		super();
		this.idCama = idCama;
		this.disponibilidad = disponibilidad;
		this.descripcion = descripcion;
	}

	public Integer getIdCama() {
		return idCama;
	}

	public void setIdCama(Integer idCama) {
		this.idCama = idCama;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCama == null) ? 0 : idCama.hashCode());
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
		Cama other = (Cama) obj;
		if (idCama == null) {
			if (other.idCama != null)
				return false;
		} else if (!idCama.equals(other.idCama))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idCama.toString() ;
	}


	

	
}
