package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Eps")
public class Eps implements Serializable{

	@Id
	@Column(name="Id_Eps")
	private int idEps;
	
	@Column(name="Nombre")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="Tipo_eps")
	private TipoEps tipoEps;

	public Eps() {
		super();
	}

	public Eps(int idEps, String nombre, TipoEps tipoEps) {
		super();
		this.idEps = idEps;
		this.nombre = nombre;
		this.tipoEps = tipoEps;
	}

	public int getIdEps() {
		return idEps;
	}

	public void setIdEps(int idEps) {
		this.idEps = idEps;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoEps getTipoEps() {
		return tipoEps;
	}

	public void setTipoEps(TipoEps tipoEps) {
		this.tipoEps = tipoEps;
	}
	
	
}
