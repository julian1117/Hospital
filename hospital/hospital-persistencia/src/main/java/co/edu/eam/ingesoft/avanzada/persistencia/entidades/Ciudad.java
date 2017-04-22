package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="Ciudades")
@NamedQuery(name=Ciudad.LISTAR_CIUDAD,query="SELECT c FROM Ciudad c")
public class Ciudad implements Serializable{
	
	public static final String LISTAR_CIUDAD= "Ciudad.listarCiudad";
	
	@Id
	@Column(name="Id_Ciudad",nullable=false)
	private Integer idCiuad;
	
	@Column(name="Ciudad",nullable=false,length=25)
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="Id_departamento",nullable=false)
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
