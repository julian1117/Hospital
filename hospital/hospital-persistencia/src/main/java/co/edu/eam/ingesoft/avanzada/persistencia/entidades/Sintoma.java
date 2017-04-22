package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SINTOMAS")
public class Sintoma implements Serializable{
	
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
	
	

}
