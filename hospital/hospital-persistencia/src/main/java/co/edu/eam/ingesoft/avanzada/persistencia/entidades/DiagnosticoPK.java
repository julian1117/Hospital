package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class DiagnosticoPK implements Serializable{
	
	private int idCita;
	
	private int idPatologia;

	public DiagnosticoPK() {
		super();
	}

	public DiagnosticoPK(int idCita, int idPatologia) {
		super();
		this.idCita = idCita;
		this.idPatologia = idPatologia;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
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
		result = prime * result + idCita;
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
		DiagnosticoPK other = (DiagnosticoPK) obj;
		if (idCita != other.idCita)
			return false;
		if (idPatologia != other.idPatologia)
			return false;
		return true;
	}
	
	

}
