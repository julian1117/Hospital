package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class OrdenCirugiaPK implements Serializable{

	private Integer idCita;
	
	private Integer idCirugia;

	public OrdenCirugiaPK(Integer idCita, Integer id) {
		super();
		this.idCita = idCita;
		this.idCirugia = id;
	}

	public OrdenCirugiaPK() {
		super();
	}

	public Integer getIdCita() {
		return idCita;
	}

	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}

	public Integer getId() {
		return idCirugia;
	}

	public void setId(Integer id) {
		this.idCirugia = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCirugia == null) ? 0 : idCirugia.hashCode());
		result = prime * result + ((idCita == null) ? 0 : idCita.hashCode());
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
		OrdenCirugiaPK other = (OrdenCirugiaPK) obj;
		if (idCirugia == null) {
			if (other.idCirugia != null)
				return false;
		} else if (!idCirugia.equals(other.idCirugia))
			return false;
		if (idCita == null) {
			if (other.idCita != null)
				return false;
		} else if (!idCita.equals(other.idCita))
			return false;
		return true;
	}
	
	
	
}
