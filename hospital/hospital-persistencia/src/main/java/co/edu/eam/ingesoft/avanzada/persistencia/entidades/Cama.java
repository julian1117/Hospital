package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Camas")
public class Cama implements Serializable{

	@Id
	@Column(name="Id_Cama")
	private int idCama;
	
	@Column(name="Disponibilidad")
	private boolean disponibilidad;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Hospitalizacion")
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
