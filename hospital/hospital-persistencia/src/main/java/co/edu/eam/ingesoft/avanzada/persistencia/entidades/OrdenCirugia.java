package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OrdenCirugiaPK.class)
@Table(name="ORDEN_CIRUGIAS")
public class OrdenCirugia implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita idCita;
	
	@Id
	@ManyToOne
	@JoinColumn(name="CIRUGIAS_ID_CIRUGIA",nullable=false)
	private Cirugia idCirugia;
	
	

	public OrdenCirugia() {
		super();
	}

	public OrdenCirugia(Cita idCita, Cirugia idCirugia) {
		super();
		this.idCita = idCita;
		this.idCirugia = idCirugia;
	}

	public Cita getIdCita() {
		return idCita;
	}

	public void setIdCita(Cita idCita) {
		this.idCita = idCita;
	}

	public Cirugia getIdCirugia() {
		return idCirugia;
	}

	public void setIdCirugia(Cirugia idCirugia) {
		this.idCirugia = idCirugia;
	}
	
	

}
