package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipo_Examenes")
public class TipoExamen implements Serializable{
	
	@Id
	@Column(name="Id_TipoExamenes",nullable=false)
	private Integer idTipoExamenes;
	
	@Column(name="Nombre_TipoExamen",nullable=false,length=30)
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
	
	

}
