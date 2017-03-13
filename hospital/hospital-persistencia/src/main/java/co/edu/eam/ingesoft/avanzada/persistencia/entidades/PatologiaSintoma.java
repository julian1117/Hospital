package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patologias_Sintomas")
public class PatologiaSintoma implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="Patologia")
	private Patologia patologia;
	
	@ManyToOne
	@JoinColumn(name="Sintoma")
	private Sintoma sintoma;

}
