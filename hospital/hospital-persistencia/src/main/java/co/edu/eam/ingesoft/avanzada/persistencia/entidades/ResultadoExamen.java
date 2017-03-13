package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Resultados_Examenes")
@IdClass(OrdenProcedimientoPK.class)
public class ResultadoExamen implements Serializable{

	@Id
	@Column(name="Id_Resultado")
	private int idResultado;
	
	@Column(name="Detalle")
	private String detalle;
	
	@Column(name="Fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="IdOrden_Procedimiento", referencedColumnName = "IdOrden_Procedimiento"),
		@JoinColumn(name="Id_Procedimiento", referencedColumnName = "Id_Procedimiento")
	})
	private OrdenProcedimiento ordenProce;
	

	public ResultadoExamen() {
		super();
	}


	public ResultadoExamen(int idResultado, String detalle, Date fecha, OrdenProcedimiento ordenProce) {
		super();
		this.idResultado = idResultado;
		this.detalle = detalle;
		this.fecha = fecha;
		this.ordenProce = ordenProce;
	}


	public int getIdResultado() {
		return idResultado;
	}


	public void setIdResultado(int idResultado) {
		this.idResultado = idResultado;
	}


	public String getDetalle() {
		return detalle;
	}


	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public OrdenProcedimiento getOrdenProce() {
		return ordenProce;
	}


	public void setOrdenProce(OrdenProcedimiento ordenProce) {
		this.ordenProce = ordenProce;
	}

	
	
	
	
}
