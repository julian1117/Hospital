package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class DiagnosticoPK implements Serializable{
	
	private Integer idCita;
	
	private Integer patologiaId;

	public DiagnosticoPK() {
		super();
	}

	public DiagnosticoPK(int idCita, int patologiaId) {
		super();
		this.idCita = idCita;
		this.patologiaId = patologiaId;
	}

	public int getIdCita() {
		return idCita;
	}

	public void setIdCita(int idCita) {
		this.idCita = idCita;
	}

	public int getPatologiaId() {
		return patologiaId;
	}

	public void setPatologiaId(int patologiaId) {
		this.patologiaId = patologiaId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCita;
		result = prime * result + patologiaId;
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
		if (patologiaId != other.patologiaId)
			return false;
		return true;
	}

	
	
	

}
