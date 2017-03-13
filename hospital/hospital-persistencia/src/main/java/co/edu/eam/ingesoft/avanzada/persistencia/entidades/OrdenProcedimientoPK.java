package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class OrdenProcedimientoPK implements Serializable {

	private int idOrden;
	
	private int idProcedimiento;

	public OrdenProcedimientoPK() {
		super();
	}

	public OrdenProcedimientoPK(int idOrden, int idProcedimiento) {
		super();
		this.idOrden = idOrden;
		this.idProcedimiento = idProcedimiento;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public int getIdProcedimiento() {
		return idProcedimiento;
	}

	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idOrden;
		result = prime * result + idProcedimiento;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdenProcedimientoPK other = (OrdenProcedimientoPK) obj;
		if (idOrden != other.idOrden)
			return false;
		if (idProcedimiento != other.idProcedimiento)
			return false;
		return true;
	}
	
	
}
