package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTO")
public class Departamento implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTAMENTOS_SEQ")
    @SequenceGenerator(sequenceName = "DEPARTAMENTO_SEQ", allocationSize = 1, name = "DEPARTAMENTOS_SEQ")
	@Column(name="Id")
	private Integer IdDepartamento;
	
	@Column(name="Nombre",nullable=false,length=25)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="PAIS_Id",nullable=false)
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
