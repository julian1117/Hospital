package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@IdClass(OrdenHospitalizacionPK.class)
@Table(name="ORDEN_HOSPITALIZACION")
public class OrdenHospitalizacion implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita idCita;
	
	@Id
	@ManyToOne
	@JoinColumn(name="HOSPITALIZACIONES_ID",nullable=false)
	private Hospitalizacion idHospitalizacion;

	public OrdenHospitalizacion(Cita idCita, Hospitalizacion idHospitalizacion) {
		super();
		this.idCita = idCita;
		this.idHospitalizacion = idHospitalizacion;
	}

	public OrdenHospitalizacion() {
		super();
	}

	public Cita getIdCita() {
		return idCita;
	}

	public void setIdCita(Cita idCita) {
		this.idCita = idCita;
	}

	public Hospitalizacion getIdHospitalizacion() {
		return idHospitalizacion;
	}

	public void setIdHospitalizacion(Hospitalizacion idHospitalizacion) {
		this.idHospitalizacion = idHospitalizacion;
	}
	
	

}
