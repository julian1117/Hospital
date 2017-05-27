package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="CONSULTORIOS")
@NamedQuery(name=Consultorio.LISTA_CONSULTORIOS,query="SELECT c FROM Consultorio c")
public class Consultorio implements Serializable {
	
	public static final String LISTA_CONSULTORIOS = "Consultorio.lista";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSULTORIO_SEQ")
    @SequenceGenerator(sequenceName = "CONSULTORIOS_SEQ", allocationSize = 1, name = "CONSULTORIO_SEQ")
	@Column(name="id")
	private Integer id;
	
	@Column(name="ubicacion")
	private String ubicacion;

	public Consultorio() {
		super();
	}
	
	public Consultorio(Integer id, String ubicacion) {
		super();
		this.id = id;
		this.ubicacion = ubicacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
		Consultorio other = (Consultorio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
