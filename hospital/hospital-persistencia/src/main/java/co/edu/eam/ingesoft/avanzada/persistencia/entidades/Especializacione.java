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
@Table(name="ESPECIALIZACIONES")
@NamedQuery(name=Especializacione.LISTAR_ESPECIALIZACIONES,query="SELECT e FROM Especializacione e")
public class Especializacione implements Serializable{
	
	public static final String LISTAR_ESPECIALIZACIONES="Especializacione.listar";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESPECIALIZACIONE_SEQ")
    @SequenceGenerator(sequenceName = "ESPECIALIZACIONES_SEQ", allocationSize = 1, name = "ESPECIALIZACIONE_SEQ")
	@Column(name="Id",nullable=false)
	private Integer idEspecializacion;
	
	@Column(name="Nombre_especializacion",nullable=false,length=40)
	private String nombre;

	public Especializacione() {
		super();
	}

	public Especializacione(int idEspecializacion, String nombre) {
		super();
		this.idEspecializacion = idEspecializacion;
		this.nombre = nombre;
	}

	public int getIdEspecializacion() {
		return idEspecializacion;
	}

	public void setIdEspecializacion(int idEspecializacion) {
		this.idEspecializacion = idEspecializacion;
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
		result = prime * result + ((idEspecializacion == null) ? 0 : idEspecializacion.hashCode());
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
		Especializacione other = (Especializacione) obj;
		if (idEspecializacion == null) {
			if (other.idEspecializacion != null)
				return false;
		} else if (!idEspecializacion.equals(other.idEspecializacion))
			return false;
		return true;
	}
	
	
	
	
	
}
