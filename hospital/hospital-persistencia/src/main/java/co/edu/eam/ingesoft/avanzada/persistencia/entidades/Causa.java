package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CAUSAS")
@NamedQuery(name=Causa.LISTA_CAUSAS,query="SELECT c FROM Causa c")
public class Causa implements Serializable {
	
	public static final String LISTA_CAUSAS = "Causa.listaCausa";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idCausasPa;
	
	@Column(name="Nombre_causa",nullable=false,length=40)
	private String nombre;

	public Causa() {
		super();
	}

	public Causa(int idCausasPa, String nombre) {
		super();
		this.idCausasPa = idCausasPa;
		this.nombre = nombre;
	}

	public int getIdCausasPa() {
		return idCausasPa;
	}

	public void setIdCausasPa(int idCausasPa) {
		this.idCausasPa = idCausasPa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCausasPa == null) ? 0 : idCausasPa.hashCode());
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
		Causa other = (Causa) obj;
		if (idCausasPa == null) {
			if (other.idCausasPa != null)
				return false;
		} else if (!idCausasPa.equals(other.idCausasPa))
			return false;
		return true;
	}
	
	

}
