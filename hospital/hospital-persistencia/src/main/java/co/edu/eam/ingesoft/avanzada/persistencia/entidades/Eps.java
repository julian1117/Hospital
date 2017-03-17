package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Eps")
public class Eps implements Serializable{

	@Id
	@Column(name="Id_Eps")
	private int idEps;
	
	@Column(name="Nombre",unique = true)
	private String nombre;
	
	@Column(name="Prepagada")
	private boolean prepagada;


	public Eps() {
		super();
	}

	
	
	
}
