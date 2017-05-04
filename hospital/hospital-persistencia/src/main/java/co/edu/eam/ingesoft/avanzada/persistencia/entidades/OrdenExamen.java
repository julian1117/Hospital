package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDEN_EXAMENES")
public class OrdenExamen implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita citaId;
	
	@ManyToOne
	@JoinColumn(name="RESULTADOS_EXAMENES_Id",nullable=false)
	private ResultadoExamen resultadoExamen;
	
	@ManyToOne
	@JoinColumn(name="EXAMENES_ID_EXAMEN",nullable=false)
	private Examen idExamen;
	
	

	public OrdenExamen() {
		super();
	}

	public OrdenExamen(Cita citaId, ResultadoExamen resultadoExamen, Examen idExamen) {
		super();
		this.citaId = citaId;
		this.resultadoExamen = resultadoExamen;
		this.idExamen = idExamen;
	}

	public Cita getCitaId() {
		return citaId;
	}

	public void setCitaId(Cita citaId) {
		this.citaId = citaId;
	}

	public ResultadoExamen getResultadoExamen() {
		return resultadoExamen;
	}

	public void setResultadoExamen(ResultadoExamen resultadoExamen) {
		this.resultadoExamen = resultadoExamen;
	}

	public Examen getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Examen idExamen) {
		this.idExamen = idExamen;
	}


	
	
	

}
