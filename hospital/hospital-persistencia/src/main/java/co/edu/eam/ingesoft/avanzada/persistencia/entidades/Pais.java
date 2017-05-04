package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAIS")
public class Pais implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAISES_SEQ")
    @SequenceGenerator(sequenceName = "PAIS_SEQ", allocationSize = 1, name = "PAISES_SEQ")
	@Column(name="Id")
	private Integer idPais;
	
	@Column(name="Nombre_p",nullable=false,length=25)
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
