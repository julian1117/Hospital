package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_EXAMEN")
@NamedQuery(name=TipoExamen.LISTAR_TIPO_EXAMEN,query="SELECT t FROM TipoExamen t")
public class TipoExamen implements Serializable{
	
	public static final String LISTAR_TIPO_EXAMEN="TipoExamen.listarE";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idTipoExamenes;
	
	@Column(name="Nombre_tipo_examen",nullable=false,length=30)
	private String nomTipoExamen;

	public TipoExamen() {
		super();
	}

	public TipoExamen(int idTipoExamenes, String nomTipoExamen) {
		super();
		this.idTipoExamenes = idTipoExamenes;
		this.nomTipoExamen = nomTipoExamen;
	}

	public int getIdTipoExamenes() {
		return idTipoExamenes;
	}

	public void setIdTipoExamenes(int idTipoExamenes) {
		this.idTipoExamenes = idTipoExamenes;
	}

	public String getNomTipoExamen() {
		return nomTipoExamen;
	}

	public void setNomTipoExamen(String nomTipoExamen) {
		this.nomTipoExamen = nomTipoExamen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoExamenes == null) ? 0 : idTipoExamenes.hashCode());
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
		TipoExamen other = (TipoExamen) obj;
		if (idTipoExamenes == null) {
			if (other.idTipoExamenes != null)
				return false;
		} else if (!idTipoExamenes.equals(other.idTipoExamenes))
			return false;
		return true;
	}
	
	
	
	

}
