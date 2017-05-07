package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CAMAS")
public class Cama implements Serializable{

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

	

	
}
