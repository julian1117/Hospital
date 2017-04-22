package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAMACION_CIRUGIAS")
public class ProgramacionCirugia implements Serializable{
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idProgramacionCi;
	
	@ManyToOne
	@JoinColumn(name="QUIROFANOS_Id",nullable=false)
	private Quirofano idQuirofano;
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ORDEN_MEDICINAS_Id", referencedColumnName = "MEDICINAS_Id"),
		@JoinColumn(name="ORDEN_PROCE_Id", referencedColumnName = "PROCE_Id")
	})
	private OrdenProcedimiento ordenProce;

	public ProgramacionCirugia() {
		super();
	}

	public ProgramacionCirugia(int idProgramacionCi, Quirofano idQuirofano, OrdenProcedimiento ordenProce) {
		super();
		this.idProgramacionCi = idProgramacionCi;
		this.idQuirofano = idQuirofano;
		this.ordenProce = ordenProce;
	}

	public int getIdProgramacionCi() {
		return idProgramacionCi;
	}

	public void setIdProgramacionCi(int idProgramacionCi) {
		this.idProgramacionCi = idProgramacionCi;
	}

	public Quirofano getIdQuirofano() {
		return idQuirofano;
	}

	public void setIdQuirofano(Quirofano idQuirofano) {
		this.idQuirofano = idQuirofano;
	}

	public OrdenProcedimiento getOrdenProce() {
		return ordenProce;
	}

	public void setOrdenProce(OrdenProcedimiento ordenProce) {
		this.ordenProce = ordenProce;
	}
	
	
	
	

}
