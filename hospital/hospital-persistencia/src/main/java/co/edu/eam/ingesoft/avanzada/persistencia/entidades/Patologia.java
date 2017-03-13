package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patologias")
public class Patologia implements Serializable{
	 
	@Id
	@Column(name="Id_Patologia")
	private int idPatologia;
	
	@Column(name="Descripcion")
	private String descripcion;
	
	@Column(name="Nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="Causa_Patologia")
	private CausaPatologia causaPatologia;

	public Patologia() {
		super();
	}

	public Patologia(int idPatologia, String descripcion, String nombre, CausaPatologia causaPatologia) {
		super();
		this.idPatologia = idPatologia;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.causaPatologia = causaPatologia;
	}

	public int getIdPatologia() {
		return idPatologia;
	}

	public void setIdPatologia(int idPatologia) {
		this.idPatologia = idPatologia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CausaPatologia getCausaPatologia() {
		return causaPatologia;
	}

	public void setCausaPatologia(CausaPatologia causaPatologia) {
		this.causaPatologia = causaPatologia;
	}
	
	
	
}
