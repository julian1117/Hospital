package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class AgendaPK implements Serializable{
	
	private int idHorarios;
	
	private Persona idPersona;

	public AgendaPK() {
		super();
	}

	public AgendaPK(int idHorarios, Persona idPersona) {
		super();
		this.idHorarios = idHorarios;
		this.idPersona = idPersona;
	}

	public int getIdHorarios() {
		return idHorarios;
	}

	public void setIdHorarios(int idHorarios) {
		this.idHorarios = idHorarios;
	}

	public Persona getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idHorarios;
		result = prime * result + ((idPersona == null) ? 0 : idPersona.hashCode());
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
		AgendaPK other = (AgendaPK) obj;
		if (idHorarios != other.idHorarios)
			return false;
		if (idPersona == null) {
			if (other.idPersona != null)
				return false;
		} else if (!idPersona.equals(other.idPersona))
			return false;
		return true;
	}
	
	

}
