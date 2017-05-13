package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="rol")
@NamedQuery(name=Roll.listaRoles,query="SELECT r FROM Roll r WHERE r.id=?1")
public class Roll {
	
	public static final String listaRoles = "Roll.listaRoles";
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="tipo_us",nullable=false)
	private String tipoUs;

	public Roll() {
		super();
	}

	public Roll(Integer id, String tipoUs) {
		super();
		this.id = id;
		this.tipoUs = tipoUs;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoUs() {
		return tipoUs;
	}

	public void setTipoUs(String tipoUs) {
		this.tipoUs = tipoUs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Roll other = (Roll) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
