package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class PatologiaTratamientoPK implements Serializable{
	
	private int patologiaa;
	
	private int tratamient;

	public PatologiaTratamientoPK() {
		super();
	}

	public PatologiaTratamientoPK(int idPatologia, int idTratamiento) {
		super();
		this.patologiaa = idPatologia;
		this.tratamient = idTratamiento;
	}

	public int getIdPatologia() {
		return patologiaa;
	}

	public void setIdPatologia(int idPatologia) {
		this.patologiaa = idPatologia;
	}

	public int getIdTratamiento() {
		return tratamient;
	}

	public void setIdTratamiento(int idTratamiento) {
		this.tratamient = idTratamiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + patologiaa;
		result = prime * result + tratamient;
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
		PatologiaTratamientoPK other = (PatologiaTratamientoPK) obj;
		if (patologiaa != other.patologiaa)
			return false;
		if (tratamient != other.tratamient)
			return false;
		return true;
	} 
	
	

}
