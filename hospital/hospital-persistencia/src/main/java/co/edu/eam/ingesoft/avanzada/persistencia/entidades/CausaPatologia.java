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
@Table(name="Causas_Patologias")
@IdClass(CausaPatologiaPK.class)
public class CausaPatologia implements Serializable {

	@Id
	@ManyToOne
	@JoinColumn(name="Causa_Patologia")
	private CausaPatologia causaPatologia;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Patologia")
	private Patologia idPatologia;

	public CausaPatologia() {
		super();
	}


	
	
}
