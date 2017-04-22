package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="CONSULTORIOS")
public class Consultorio implements Serializable {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="ubicacion")
	private String ubicacion;

	public Consultorio() {
		super();
	}
	
	public Consultorio(Integer id, String ubicacion) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	
	
	
	

}
