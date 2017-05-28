package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PATOLOGIA_SINTOMAS")
public class PatologiaSintoma implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATOLOGIA_SINTOMA_SEQ")
    @SequenceGenerator(sequenceName = "PATOLOGIA_SINTOMAS_SEQ", allocationSize = 1, name = "PATOLOGIA_SINTOMA_SEQ")
	@Column(name="ID",nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="PATOLOGIAS_Id",nullable=false)
	private Patologia patologia;
	
	
	@ManyToOne
	@JoinColumn(name="SINTOMAS_Id",nullable=false)
	private Sintoma sintoma;

	public PatologiaSintoma() {
		super();
	}
	
	

	public PatologiaSintoma(Patologia patologia, Sintoma sintoma) {
		super();
		this.patologia = patologia;
		this.sintoma = sintoma;
	}



	public PatologiaSintoma(Integer id, Patologia patologia, Sintoma sintoma) {
		super();
		this.id = id;
		this.patologia = patologia;
		this.sintoma = sintoma;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
