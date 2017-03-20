package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sintomas")
public class Sintoma implements Serializable{
	
	@Id
	@Column(name="Id_Sintoma",nullable=false)
	private int idSintoma;
	
	@Column(name="Nombre_Sintoma",nullable=false)
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
	
	

}
