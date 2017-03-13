package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ordenes_Procedimientos")
@IdClass(OrdenProcedimientoPK.class)
public class OrdenProcedimiento implements Serializable {
	
	@Id
	@ManyToOne
	@JoinColumn(name="IdOrden_Procedimiento")
	private OrdenProcedimiento idOrdenProce;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Id_Procedimiento")
	private Procedimiento idProcedimiento;

	public OrdenProcedimiento() {
		super();
	}

	public OrdenProcedimiento(OrdenProcedimiento idOrdenProce, Procedimiento idProcedimiento) {
		super();
		this.idOrdenProce = idOrdenProce;
		this.idProcedimiento = idProcedimiento;
	}

	public OrdenProcedimiento getIdOrdenProce() {
		return idOrdenProce;
	}

	public void setIdOrdenProce(OrdenProcedimiento idOrdenProce) {
		this.idOrdenProce = idOrdenProce;
	}

	public Procedimiento getIdProcedimiento() {
		return idProcedimiento;
	}

	public void setIdProcedimiento(Procedimiento idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	
	

}
