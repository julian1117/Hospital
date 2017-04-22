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
@Table(name="RESULTADOS_EXAMENES")
public class ResultadoExamen implements Serializable{

	@Id
	@Column(name="Id",nullable=false)
	private Integer idResultado;
	
	@Column(name="Detalle",nullable=false,length=2000)
	private String detalle;
	
	@Column(name="Fecha",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="ORDEN_MEDICINAS_Id", referencedColumnName = "MEDICINAS_Id"),
		@JoinColumn(name="ORDEN_PROCE_Id", referencedColumnName = "PROCE_Id")
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
