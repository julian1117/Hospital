package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRATAMIENTOS")
public class Tratamiento implements Serializable{
	 
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
	
	
}
