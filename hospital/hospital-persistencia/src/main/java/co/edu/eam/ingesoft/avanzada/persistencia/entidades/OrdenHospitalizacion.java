package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ORDEN_HOSPITALIZACION")
public class OrdenHospitalizacion implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDEN_HOSPITALIZACION_SEQ")
    @SequenceGenerator(sequenceName = "ORDEN_HOSPITALIZACIONES_SEQ", allocationSize = 1, name = "ORDEN_HOSPITALIZACION_SEQ")
	@Column(name="ID_ORDEN_HOSP",nullable=false)
	private Integer idOrdenHospi; 
	
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita idCita;
	
	
	@ManyToOne
	@JoinColumn(name="HOSPITALIZACIONES_ID",nullable=false)
	private Hospitalizacion idHospitalizacion;

	public OrdenHospitalizacion() {
		super();
	}
	
	public OrdenHospitalizacion(Cita idCita, Hospitalizacion idHospitalizacion) {
		super();
		this.idCita = idCita;
		this.idHospitalizacion = idHospitalizacion;
	}
	
	

	public OrdenHospitalizacion(Integer idOrdenHospi, Cita idCita, Hospitalizacion idHospitalizacion) {
		super();
		this.idOrdenHospi = idOrdenHospi;
		this.idCita = idCita;
		this.idHospitalizacion = idHospitalizacion;
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

	public Integer getIdOrdenHospi() {
		return idOrdenHospi;
	}

	public void setIdOrdenHospi(Integer idOrdenHospi) {
		this.idOrdenHospi = idOrdenHospi;
	}
	
	

}
