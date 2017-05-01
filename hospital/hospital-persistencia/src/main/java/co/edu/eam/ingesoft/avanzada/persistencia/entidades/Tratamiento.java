package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TRATAMIENTOS")
@NamedQuery(name=Tratamiento.LISTA_TRATAMIENTO,query="SELECT t FROM Tratamiento t")
public class Tratamiento implements Serializable{
	 
	public static final String LISTA_TRATAMIENTO = "Tratamiento.listaTratamienot";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idTratamiento; 
	
	@Column(name="Nombre_patalogia",nullable=false,length=40)
	private String nombrePatologia;

	public Tratamiento() {
		super();
	}

	public Tratamiento(int idTratamiento, String nombrePatologia) {
		super();
		this.idTratamiento = idTratamiento;
		this.nombrePatologia = nombrePatologia;
	}

	public int getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	public String getNombrePatologia() {
		return nombrePatologia;
	}

	public void setNombrePatologia(String nombrePatologia) {
		this.nombrePatologia = nombrePatologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTratamiento == null) ? 0 : idTratamiento.hashCode());
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
		Tratamiento other = (Tratamiento) obj;
		if (idTratamiento == null) {
			if (other.idTratamiento != null)
				return false;
		} else if (!idTratamiento.equals(other.idTratamiento))
			return false;
		return true;
	}
	
	
}
