package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class CausaPatologiaPK implements Serializable{

	private int causaPatologia;
	
	private int patologia;

	public CausaPatologiaPK() {
		super();
	}

	public CausaPatologiaPK(int causaPatologia, int patologia) {
		super();
		this.causaPatologia = causaPatologia;
		this.patologia = patologia;
	}

	public int getCausaPatologia() {
		return causaPatologia;
	}

	public void setCausaPatologia(int causaPatologia) {
		this.causaPatologia = causaPatologia;
	}

	public int getPatologia() {
		return patologia;
	}

	public void setPatologia(int patologia) {
		this.patologia = patologia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + causaPatologia;
		result = prime * result + patologia;
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
		if (causaPatologia != other.causaPatologia)
			return false;
		if (patologia != other.patologia)
			return false;
		return true;
	}

	
	
	
}
