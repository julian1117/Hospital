package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Eps")
public class Eps implements Serializable {

	@Id
	@Column(name = "Id_Eps")
	private Integer idEps;

	@Column(name = "Nombre", unique = true, nullable = false, length = 40)
	private String nombre;

	@Column(name = "Prepagada", nullable = false, length = 1)
	private boolean prepagada;

	public Eps() {
		super();
	}

	public Eps(int idEps, String nombre, boolean prepagada) {
		super();
		this.idEps = idEps;
		this.nombre = nombre;
		this.prepagada = prepagada;
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

	public boolean isPrepagada() {
		return prepagada;
	}

	public void setPrepagada(boolean prepagada) {
		this.prepagada = prepagada;
	}
	
	

}
