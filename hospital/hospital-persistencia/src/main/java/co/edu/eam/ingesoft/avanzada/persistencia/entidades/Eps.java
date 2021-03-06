package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EPS")
@NamedQuery(name=Eps.LISTAR_EPS,query="SELECT e FROM Eps e")
public class Eps implements Serializable {

	public static final String LISTAR_EPS = "Eps.listar";
	
	@Id
	@Column(name = "Id")
	private Integer idEps;

	@Column(name = "Nombre", unique = true, nullable = false, length = 40)
	private String nombre;

	@Column(name = "Prepagada", nullable = false, length = 1)
	private boolean prepagada;

	public Eps() {
		super();
	}

	public Eps(Integer idEps, String nombre, boolean prepagada) {
		super();
		this.idEps = idEps;
		this.nombre = nombre;
		this.prepagada = prepagada;
	}

	public Integer getIdEps() {
		return idEps;
	}

	public void setIdEps(Integer idEps) {
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

	public static String getListarEps() {
		return LISTAR_EPS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEps == null) ? 0 : idEps.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Eps other = (Eps) obj;
		if (idEps == null) {
			if (other.idEps != null)
				return false;
		} else if (!idEps.equals(other.idEps))
			return false;
		return true;
	}

	
	

}
