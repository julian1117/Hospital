package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDEN_EXAMENES")
public class OrdenExamen implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDEN_EXAMENE_SEQ")
    @SequenceGenerator(sequenceName = "ORDEN_EXAMENES_SEQ", allocationSize = 1, name = "ORDEN_EXAMENE_SEQ")
	@Column(name="ID_ORDEN_EXAME",nullable=false)
	private Integer idOrdenExamen;
	
	
	@ManyToOne
	@JoinColumn(name="CITAS_id",nullable=false)
	private Cita citaId;
	
	
	@ManyToOne
	@JoinColumn(name="EXAMENES_ID_EXAMEN",nullable=false)
	private Examen idExamen;
	
	

	public OrdenExamen() {
		super();
	}
	
	



	public OrdenExamen(Cita citaId, Examen idExamen) {
		super();
		this.citaId = citaId;
		this.idExamen = idExamen;
	}





	public OrdenExamen(Integer idOrdenExamen, Cita citaId, Examen idExamen) {
		super();
		this.idOrdenExamen = idOrdenExamen;
		this.citaId = citaId;
		this.idExamen = idExamen;
	}



	public Integer getIdOrdenExamen() {
		return idOrdenExamen;
	}



	public void setIdOrdenExamen(Integer idOrdenExamen) {
		this.idOrdenExamen = idOrdenExamen;
	}



	public Cita getCitaId() {
		return citaId;
	}



	public void setCitaId(Cita citaId) {
		this.citaId = citaId;
	}



	public Examen getIdExamen() {
		return idExamen;
	}



	public void setIdExamen(Examen idExamen) {
		this.idExamen = idExamen;
	}

	
	
	
	

}
