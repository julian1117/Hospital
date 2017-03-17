package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Causas")
public class Causa implements Serializable {
	
	@Id
	@Column(name="Id_Causa_Patologia")
	private int idCausasPa;
	
	@Column(name="Nombre")
	private String nombre;

	public Causa() {
		super();
	}
	
	

}
