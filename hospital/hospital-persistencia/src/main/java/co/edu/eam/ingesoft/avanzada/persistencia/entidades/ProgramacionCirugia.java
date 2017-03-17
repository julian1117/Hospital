package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Programaciones_Citas")
@IdClass(OrdenProcedimientoPK.class)
public class ProgramacionCirugia implements Serializable{
	
	@Id
	@Column(name="Id_Programacion_Cirugia")
	private int idProgramacionCi;
	
	@ManyToOne
	@JoinColumn(name="Id_Quirofano")
	private Quirofano idQuirofano;
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="IdOrden_Procedimiento", referencedColumnName = "IdOrden_Procedimiento"),
		@JoinColumn(name="Id_Procedimiento", referencedColumnName = "Id_Procedimiento")
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
