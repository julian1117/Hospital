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
	
	
	@OneToOne
	@JoinColumn(name="HOSPNES_PROCEDIMIENTOS_Id",unique=true,nullable=false)
	private Hospitalizacion hospitalizacion;

	public Cama() {
		super();
	}

	public Cama(int idCama, boolean disponibilidad, Hospitalizacion hospitalizacion) {
		super();
		this.idCama = idCama;
		this.disponibilidad = disponibilidad;
		this.hospitalizacion = hospitalizacion;
	}

	public int getIdCama() {
		return idCama;
	}

	public void setIdCama(int idCama) {
		this.idCama = idCama;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Hospitalizacion getHospitalizacion() {
		return hospitalizacion;
	}

	public void setHospitalizacion(Hospitalizacion hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}
	
	
	
	
}
