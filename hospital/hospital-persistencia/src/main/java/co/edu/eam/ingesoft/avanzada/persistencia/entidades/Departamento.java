package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Departamentos")
public class Departamento implements Serializable{
	
	@Id
	@Column(name="id_departamento")
	private int IdDepartamento;
	
	@Column(name="Nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="Id_Pais")
	private Pais IdPais;

	public Departamento() {
		super();
	}

	public Departamento(int idDepartamento, String nombre, Pais idPais) {
		super();
		IdDepartamento = idDepartamento;
		this.nombre = nombre;
		IdPais = idPais;
	}

	public int getIdDepartamento() {
		return IdDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		IdDepartamento = idDepartamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pais getIdPais() {
		return IdPais;
	}

	public void setIdPais(Pais idPais) {
		IdPais = idPais;
	}
	
	
	
}
