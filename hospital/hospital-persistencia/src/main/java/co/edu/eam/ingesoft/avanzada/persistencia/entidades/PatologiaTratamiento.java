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
@Table(name = "PATOLOGIAS_TRATAMIENTOS")
public class PatologiaTratamiento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PATOLOGIA_TRATAMIENTOS_SEQ")
	@SequenceGenerator(sequenceName = "PATOLOGIAS_TRATAMIENTOS_SEQ", allocationSize = 1, name = "PATOLOGIA_TRATAMIENTOS_SEQ")
	@Column(name = "ID", nullable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "PATOLOGIAS_Id", nullable = false)
	private Patologia patologiaa;

	@ManyToOne
	@JoinColumn(name = "TRATAMIENTOS_Id", nullable = false)
	private Tratamiento tratamient;

	public PatologiaTratamiento() {
		super();
	}
	
	

	public PatologiaTratamiento(Patologia patologiaa, Tratamiento tratamient) {
		super();
		this.patologiaa = patologiaa;
		this.tratamient = tratamient;
	}



	public PatologiaTratamiento(Integer id, Patologia patologiaa, Tratamiento tratamient) {
		super();
		this.id = id;
		this.patologiaa = patologiaa;
		this.tratamient = tratamient;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patologia getPatologiaa() {
		return patologiaa;
	}

	public void setPatologiaa(Patologia patologiaa) {
		this.patologiaa = patologiaa;
	}

	public Tratamiento getTratamient() {
		return tratamient;
	}

	public void setTratamient(Tratamiento tratamient) {
		this.tratamient = tratamient;
	}

}
