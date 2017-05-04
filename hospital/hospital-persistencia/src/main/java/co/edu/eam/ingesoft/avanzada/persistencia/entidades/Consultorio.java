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
@Table(name="CONSULTORIOS")
public class Consultorio implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSULTORIO_SEQ")
    @SequenceGenerator(sequenceName = "CONSULTORIOS_SEQ", allocationSize = 1, name = "CONSULTORIO_SEQ")
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
