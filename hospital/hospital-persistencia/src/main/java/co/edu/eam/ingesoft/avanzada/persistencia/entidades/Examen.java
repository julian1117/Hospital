package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EXAMENES")
@AttributeOverride(name="PROCEDIMIENTOS_Id_proce",column=@Column(name="PROCEDIMIENTOS_Id"))
public class Examen extends Procedimiento implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="TIPO_EXAMEN_Id",nullable=true)
	private TipoExamen tipoExamen;
	
	@Column(name="Descripcion",nullable=false, length=1000)
	private String descripcion;

	public Examen() {
		super();
	}

	public Examen(TipoExamen tipoExamen, String descripcion) {
		super();
		this.tipoExamen = tipoExamen;
		this.descripcion = descripcion;
	}

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
