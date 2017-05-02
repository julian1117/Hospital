package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="PATOLOGIAS")
@NamedQuery(name=Patologia.LISTA_PATOLOGIA,query="SELECT p FROM Patologia p")
public class Patologia implements Serializable{
	 
	public static final String LISTA_PATOLOGIA = "Patologia.listaPato";
	//CAMbio de  name's mapeada
	@Id
	@Column(name="id",nullable=false)
	private Integer idPatologia;
	
	@Column(name="descripcion",nullable=false,length=2000)
	private String descripcion;
	
	@Column(name="nombre",nullable=false,length=40)
	private String nombre;
	
	

	public Patologia() {
		super();
	}



	public Patologia(int idPatologia, String descripcion, String nombre) {
		super();
		this.idPatologia = idPatologia;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}



	public int getIdPatologia() {
		return idPatologia;
	}



	public void setIdPatologia(int idPatologia) {
		this.idPatologia = idPatologia;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		result = prime * result + ((idPatologia == null) ? 0 : idPatologia.hashCode());
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
		Patologia other = (Patologia) obj;
		if (idPatologia == null) {
			if (other.idPatologia != null)
				return false;
		} else if (!idPatologia.equals(other.idPatologia))
			return false;
		return true;
	}
	
}
