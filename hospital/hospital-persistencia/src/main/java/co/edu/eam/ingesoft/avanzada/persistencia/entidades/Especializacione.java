package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Especializaciones")
public class Especializacione implements Serializable{

	@Id
	@Column(name="Id_Especializacion",nullable=false)
	private int idEspecializacion;
	
	@Column(name="Nombre",nullable=false,length=40)
	private String nombre;

	public Especializacione() {
		super();
	}

	public Especializacione(int idEspecializacion, String nombre) {
		super();
		this.idEspecializacion = idEspecializacion;
		this.nombre = nombre;
	}

	public int getIdEspecializacion() {
		return idEspecializacion;
	}

	public void setIdEspecializacion(int idEspecializacion) {
		this.idEspecializacion = idEspecializacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
