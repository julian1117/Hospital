package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class OrdenHospitalizacionPK implements Serializable{
	
	private Integer idCita;
	
	private Integer idHospitalizacion;

	public OrdenHospitalizacionPK(Integer idCita, Integer id) {
		super();
		this.idCita = idCita;
		this.idHospitalizacion = id;
	}

	public OrdenHospitalizacionPK() {
		super();
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Integer getId() {
		return idHospitalizacion;
	}

	public void setId(Integer id) {
		this.idHospitalizacion = id;
	}
	
	

}
