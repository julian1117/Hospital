package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class OrdenProcedimientoPK implements Serializable {

	private Integer idOrdenMedica;
	
	private Integer idProcedimiento;

	public OrdenProcedimientoPK() {
		super();
	}

	public OrdenProcedimientoPK(int idOrdenMedica, int idProcedimiento) {
		super();
		this.idOrdenMedica = idOrdenMedica;
		this.idProcedimiento = idProcedimiento;
	}

	public int getIdOrdenMedica() {
		return idOrdenMedica;
	}

	public void setIdOrdenMedica(int idOrdenMedica) {
		this.idOrdenMedica = idOrdenMedica;
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
		result = prime * result + idOrdenMedica;
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
		if (idOrdenMedica != other.idOrdenMedica)
			return false;
		if (idProcedimiento != other.idProcedimiento)
			return false;
		return true;
	}

	
	
	
}
