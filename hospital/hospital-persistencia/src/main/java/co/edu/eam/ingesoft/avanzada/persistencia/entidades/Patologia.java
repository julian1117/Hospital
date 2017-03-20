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
	@Column(name="Id_Patologia",nullable=false)
	private int idPatologia;
	
	@Column(name="Descripcion",nullable=false)
	private String descripcion;
	
	@Column(name="Nombre",nullable=false)
	private String nombre;
	
	

	public Patologia() {
		super();
	}


	
	
	
}
