package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class PatologiaSintomaPK implements Serializable{
	
	private int idPatologia;
	
	private int idSintoma;

	public PatologiaSintomaPK() {
		super();
	}

	public PatologiaSintomaPK(int idPatologia, int idSintoma) {
		super();
		this.idPatologia = idPatologia;
		this.idSintoma = idSintoma;
	}

	public int getIdPatologia() {
		return idPatologia;
	}

	public void setIdPatologia(int idPatologia) {
		this.idPatologia = idPatologia;
	}

	public int getIdSintoma() {
		return idSintoma;
	}

	public void setIdSintoma(int idSintoma) {
		this.idSintoma = idSintoma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPatologia;
		result = prime * result + idSintoma;
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
		PatologiaSintomaPK other = (PatologiaSintomaPK) obj;
		if (idPatologia != other.idPatologia)
			return false;
		if (idSintoma != other.idSintoma)
			return false;
		return true;
	}
	
	

}
