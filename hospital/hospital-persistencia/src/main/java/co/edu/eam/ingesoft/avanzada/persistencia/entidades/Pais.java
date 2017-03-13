package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Paises")
public class Pais implements Serializable{

	@Column(name="id_Pais")
	@Id
	private int idPais;
	
	@Column(name="nombre")
	private String nombre;
	
	

	public Pais() {
		super();
	}

	public Pais(int idPais, String nombre) {
		super();
		this.idPais = idPais;
		this.nombre = nombre;
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
}
