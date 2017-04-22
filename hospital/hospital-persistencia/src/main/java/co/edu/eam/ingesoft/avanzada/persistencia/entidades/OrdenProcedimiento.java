package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORDEN_PROCE")
@IdClass(OrdenProcedimientoPK.class)
public class OrdenProcedimiento implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="MEDICINAS_Id",nullable=false)
	private OrdenMedica idOrdenMedica;
	
	@Id
	@ManyToOne
	@JoinColumn(name="PROCE_Id",nullable=false)
	private Procedimiento idProcedimiento;

	public OrdenProcedimiento() {
		super();
	}

	public OrdenProcedimiento(OrdenMedica idOrdenMedica, Procedimiento idProcedimiento) {
		super();
		this.idOrdenMedica = idOrdenMedica;
		this.idProcedimiento = idProcedimiento;
	}

	public OrdenMedica getIdOrdenMedica() {
		return idOrdenMedica;
	}

	public void setIdOrdenMedica(OrdenMedica idOrdenMedica) {
		this.idOrdenMedica = idOrdenMedica;
	}

	public Procedimiento getIdProcedimiento() {
		return idProcedimiento;
	}

	public void setIdProcedimiento(Procedimiento idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}

	

}
