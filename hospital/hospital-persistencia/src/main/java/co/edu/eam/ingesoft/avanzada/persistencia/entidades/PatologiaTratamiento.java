package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Patologias_Trartamientos")
@IdClass(PatologiaSintomaPK.class)
public class PatologiaTratamiento implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="patologia_tratamiento")
	private Patologia patologia;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Tratamiento")
	private Tratamiento tratamiento;

	public PatologiaTratamiento() {
		super();
	}

	public PatologiaTratamiento(Patologia patologia, Tratamiento tratamiento) {
		super();
		this.patologia = patologia;
		this.tratamiento = tratamiento;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}
	
	

}
