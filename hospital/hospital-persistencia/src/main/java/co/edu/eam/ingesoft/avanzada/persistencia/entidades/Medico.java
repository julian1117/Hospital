package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Medicos")
public class Medico extends Persona implements Serializable{

	@Id
	@Column(name="Id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="Especializaciones")
	private Especializacione especializaciones;
	
	@Id
	@OneToOne
	@JoinColumn(name="Id_Persona",unique= true)
	private Persona idPersona;

	public Medico() {
		super();
	}

	
	
	
	
	
}
