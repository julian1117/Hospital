package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class PatologiaTratamientoPK implements Serializable{
	
	private int idPatologia;
	
	private int idTratamiento;

	public PatologiaTratamientoPK() {
		super();
	}

	public PatologiaTratamientoPK(int idPatologia, int idTratamiento) {
		super();
		this.idPatologia = idPatologia;
		this.idTratamiento = idTratamiento;
	}

	public int getIdPatologia() {
		return idPatologia;
	}

	public void setIdPatologia(int idPatologia) {
		this.idPatologia = idPatologia;
	}

	public int getIdTratamiento() {
		return idTratamiento;
	}

	public void setIdTratamiento(int idTratamiento) {
		this.idTratamiento = idTratamiento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPatologia;
		result = prime * result + idTratamiento;
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
		if (idPatologia != other.idPatologia)
			return false;
		if (idTratamiento != other.idTratamiento)
			return false;
		return true;
	} 
	
	

}
