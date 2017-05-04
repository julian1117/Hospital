package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="EXAMENES")
public class Examen implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXAMENE_SEQ")
    @SequenceGenerator(sequenceName = "EXAMENES_SEQ", allocationSize = 1, name = "EXAMENE_SEQ")
	@Column(name="ID_EXAMEN",nullable=false)
	private Integer idExamen;
	
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
		this.idExamen = idExamen;
		this.tipoExamen = tipoExamen;
		this.descripcion = descripcion;
	}

	public Integer getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(Integer idExamen) {
		this.idExamen = idExamen;
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
