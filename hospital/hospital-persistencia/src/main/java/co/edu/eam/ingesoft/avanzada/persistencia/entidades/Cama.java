package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Camas")
public class Cama implements Serializable{

	@Id
	@Column(name="Id_Cama")
	private int idCama;
	
	@Column(name="Disponibilidad")
	private boolean disponibilidad;
	
	@ManyToOne
	@JoinColumn(name="Hospitalizacion")
	private Hospitalizacion hospitalizacion;
}
