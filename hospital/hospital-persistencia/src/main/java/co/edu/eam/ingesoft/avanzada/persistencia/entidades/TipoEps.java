package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipos_Eps")
public class TipoEps implements Serializable{

	@Id
	@Column(name="Id_Eps")
	private int idTipoEps;
	
	@Column(name="Prepagada")
	private boolean prepagada;

	public TipoEps() {
		super();
	}

	public TipoEps(int idEps, boolean prepagada) {
		super();
		this.idTipoEps = idEps;
		this.prepagada = prepagada;
	}

	public int getIdEps() {
		return idTipoEps;
	}

	public void setIdEps(int idEps) {
		this.idTipoEps = idEps;
	}

	public boolean isPrepagada() {
		return prepagada;
	}

	public void setPrepagada(boolean prepagada) {
		this.prepagada = prepagada;
	}
	
	
	
}
