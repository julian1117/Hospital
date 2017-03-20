package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class CirugiaPK implements Serializable{
	
	private Procedimiento procedimiento;
	
	private TipoCirugia tipoCirugia;

	public CirugiaPK() {
		super();
	}

	public CirugiaPK(Procedimiento procedimiento, TipoCirugia tipoCirugia) {
		super();
		this.procedimiento = procedimiento;
		this.tipoCirugia = tipoCirugia;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}

	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((procedimiento == null) ? 0 : procedimiento.hashCode());
		result = prime * result + ((tipoCirugia == null) ? 0 : tipoCirugia.hashCode());
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
		CirugiaPK other = (CirugiaPK) obj;
		if (procedimiento == null) {
			if (other.procedimiento != null)
				return false;
		} else if (!procedimiento.equals(other.procedimiento))
			return false;
		if (tipoCirugia == null) {
			if (other.tipoCirugia != null)
				return false;
		} else if (!tipoCirugia.equals(other.tipoCirugia))
			return false;
		return true;
	}
	
	

}
