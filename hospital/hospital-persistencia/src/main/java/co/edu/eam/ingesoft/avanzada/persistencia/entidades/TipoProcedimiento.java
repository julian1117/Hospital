package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_PROCE")
public class TipoProcedimiento implements Serializable{
	
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Nombre",nullable=true,length=40)
	private String nombre;

	public TipoProcedimiento() {
		super();
	}

	public TipoProcedimiento(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
