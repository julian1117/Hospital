package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Examenes")
@IdClass(ExamenPK.class)
public class Examen  implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="Tipo_Examne",nullable=true)
	private TipoExamen tipoExamen;
	
	@Id
	@OneToOne
	@JoinColumn(name="Id_procedimiento",nullable=true)
	private Procedimiento procedimiento;
	
	@Column(name="Descripcion",nullable=false, length=1000)
	private String descripcion;

	public Examen() {
		super();
	}

	public Examen(TipoExamen tipoExamen, Procedimiento procedimiento, String descripcion) {
		super();
		this.tipoExamen = tipoExamen;
		this.procedimiento = procedimiento;
		this.descripcion = descripcion;
	}

	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}

	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}



}
