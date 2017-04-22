package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PATOLOGIAS_TRATAMIENTOS")
public class Patologia implements Serializable{
	 
	@Id
	@Column(name="Id",nullable=false)
	private Integer idPatologia;
	
	@Column(name="Descripcion",nullable=false,length=2000)
	private String descripcion;
	
	@Column(name="Nombre",nullable=false,length=40)
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


	
	
	
}
