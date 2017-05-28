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
@Table(name="CAUSAS_PATOLIGIA")
public class CausaPatologia implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAUSA_PATOLIGIA_SEQ")
    @SequenceGenerator(sequenceName = "CAUSAS_PATOLIGIA_SEQ", allocationSize = 1, name = "CAUSA_PATOLIGIA_SEQ")
	@Column(name="ID",nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CAUSAS_Id",nullable=false)
	private Causa causaPatologia;
	
	
	@ManyToOne
	@JoinColumn(name="PATOLOGIAS_Id",nullable=false)
	private Patologia patologia;

	public CausaPatologia() {
		super();
	}
	

	public CausaPatologia(Causa causaPatologia, Patologia patologia) {
		super();
		this.causaPatologia = causaPatologia;
		this.patologia = patologia;
	}



	public CausaPatologia(Integer id, Causa causaPatologia, Patologia patologia) {
		super();
		this.id = id;
		this.causaPatologia = causaPatologia;
		this.patologia = patologia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Causa getCausaPatologia() {
		return causaPatologia;
	}

	public void setCausaPatologia(Causa causaPatologia) {
		this.causaPatologia = causaPatologia;
	}

	public Patologia getPatologia() {
		return patologia;
	}

	public void setPatologia(Patologia patologia) {
		this.patologia = patologia;
	}

	

	
	
	
	
}
