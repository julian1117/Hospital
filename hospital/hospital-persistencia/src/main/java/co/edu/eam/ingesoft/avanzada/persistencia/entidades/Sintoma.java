package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="SINTOMAS")
@NamedQuery(name=Sintoma.LISTA_SINTOMAS,query="SELECT s FROM Sintoma s")
public class Sintoma implements Serializable{
	
	public static final String LISTA_SINTOMAS = "Sintoma.listaSintoma";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idSintoma;
	
	@Column(name="Nombre_sintomas",nullable=false,length=40)
	private String nombreSintoma;

	public Sintoma() {
		super();
	}

	public Sintoma(int idSintoma, String nombreSintoma) {
		super();
		this.idSintoma = idSintoma;
		this.nombreSintoma = nombreSintoma;
	}

	public int getIdSintoma() {
		return idSintoma;
	}

	public void setIdSintoma(int idSintoma) {
		this.idSintoma = idSintoma;
	}

	public String getNombreSintoma() {
		return nombreSintoma;
	}

	public void setNombreSintoma(String nombreSintoma) {
		this.nombreSintoma = nombreSintoma;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idSintoma == null) ? 0 : idSintoma.hashCode());
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
		Sintoma other = (Sintoma) obj;
		if (idSintoma == null) {
			if (other.idSintoma != null)
				return false;
		} else if (!idSintoma.equals(other.idSintoma))
			return false;
		return true;
	}
	
	

}
