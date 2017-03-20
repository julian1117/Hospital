package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patologias_Sintomas")
@IdClass(PatologiaSintomaPK.class)
public class PatologiaSintoma implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="Patologia",nullable=false)
	private Patologia patologia;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Sintoma",nullable=false)
	private Sintoma sintoma;

	public PatologiaSintoma() {
		super();
	}

	public PatologiaSintoma(Patologia patologia, Sintoma sintoma) {
		super();
		this.patologia = patologia;
		this.sintoma = sintoma;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public Sintoma getSintoma() {
		return sintoma;
	}

	public void setSintoma(Sintoma sintoma) {
		this.sintoma = sintoma;
	}
	
	

}
