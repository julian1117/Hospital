package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Ciudades")
public class Ciudad implements Serializable{
	
	@Id
	@Column(name="Id_Ciudad")
	private int idCiuad;
	
	@Column(name="Ciudad")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="")
	private Departamento departamento;

	public Ciudad() {
		super();
	}

	public Ciudad(int idCiuad, String nombre, Departamento departamento) {
		super();
		this.idCiuad = idCiuad;
		this.nombre = nombre;
		this.departamento = departamento;
	}

	public int getIdCiuad() {
		return idCiuad;
	}

	public void setIdCiuad(int idCiuad) {
		this.idCiuad = idCiuad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	

}
