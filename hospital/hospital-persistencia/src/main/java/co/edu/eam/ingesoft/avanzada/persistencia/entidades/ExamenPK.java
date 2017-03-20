package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class ExamenPK implements Serializable{
	
	private TipoExamen tipoExamen;
	
	private Procedimiento procedimiento;

	public ExamenPK() {
		super();
	}

	public ExamenPK(TipoExamen tipoExamen, Procedimiento procedimiento) {
		super();
		this.tipoExamen = tipoExamen;
		this.procedimiento = procedimiento;
	}

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((procedimiento == null) ? 0 : procedimiento.hashCode());
		result = prime * result + ((tipoExamen == null) ? 0 : tipoExamen.hashCode());
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
		ExamenPK other = (ExamenPK) obj;
		if (procedimiento == null) {
			if (other.procedimiento != null)
				return false;
		} else if (!procedimiento.equals(other.procedimiento))
			return false;
		if (tipoExamen == null) {
			if (other.tipoExamen != null)
				return false;
		} else if (!tipoExamen.equals(other.tipoExamen))
			return false;
		return true;
	}

	
}
