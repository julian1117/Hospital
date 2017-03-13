package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patologias_Trar¿tamientos")
public class PatologiaTratamiento implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="patologia_tratamiento")
	private Patologia patologia;
	
	@ManyToOne
	@JoinColumn(name="Tratamiento")
	private Tratamiento tratamiento;

}
