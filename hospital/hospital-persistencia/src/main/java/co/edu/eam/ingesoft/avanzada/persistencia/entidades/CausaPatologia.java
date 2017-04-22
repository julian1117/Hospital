package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="CAUSAS_PATOLIGIA")
@IdClass(CausaPatologiaPK.class)
public class CausaPatologia implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="CAUSAS_Id",nullable=false)
	private Causa causaPatologia;
	
	@Id
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
