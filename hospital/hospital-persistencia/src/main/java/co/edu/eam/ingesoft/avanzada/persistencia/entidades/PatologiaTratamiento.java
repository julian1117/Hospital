package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="PATOLOGIAS_TRATAMIENTOS")
@IdClass(PatologiaTratamientoPK.class)
public class PatologiaTratamiento implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="PATOLOGIAS_Id",nullable=false)
	private Patologia patologiaa;
	
	@Id
	@ManyToOne
	@JoinColumn(name="TRATAMIENTOS_Id",nullable=false)
	private Tratamiento tratamient;

	public PatologiaTratamiento() {
		super();
	}

	public PatologiaTratamiento(Patologia patologia, Tratamiento tratamiento) {
		super();
		this.patologiaa = patologia;
		this.tratamient = tratamiento;
	}

	public Patologia getPatologia() {
		return patologiaa;
	}

	public void setPatologia(Patologia patologia) {
		this.patologiaa = patologia;
	}

	public Tratamiento getTratamiento() {
		return tratamient;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamient = tratamiento;
	}

	
	
	

}
