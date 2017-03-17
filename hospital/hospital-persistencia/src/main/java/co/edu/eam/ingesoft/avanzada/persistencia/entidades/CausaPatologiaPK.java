package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class CausaPatologiaPK implements Serializable{

	private int idCausasPa;
	
	private int idPatologia;

	public CausaPatologiaPK() {
		super();
	}

	public CausaPatologiaPK(int idCausasPa, int idPatologia) {
		super();
		this.idCausasPa = idCausasPa;
		this.idPatologia = idPatologia;
	}

	public int getIdCausasPa() {
		return idCausasPa;
	}

	public void setIdCausasPa(int idCausasPa) {
		this.idCausasPa = idCausasPa;
	}

	public int getIdPatologia() {
		return idPatologia;
	}

	public void setIdPatologia(int idPatologia) {
		this.idPatologia = idPatologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCausasPa;
		result = prime * result + idPatologia;
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
		CausaPatologiaPK other = (CausaPatologiaPK) obj;
		if (idCausasPa != other.idCausasPa)
			return false;
		if (idPatologia != other.idPatologia)
			return false;
		return true;
	}
	
	
	
}
