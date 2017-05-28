package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="RESULTADOS_EXAMENES")
public class ResultadoExamen implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESULTADOS_SEQ")
    @SequenceGenerator(sequenceName = "RESULTADOS_EXAMENES_SEQ", allocationSize = 1, name = "RESULTADOS_SEQ")
	@Column(name="Id",nullable=false)
	private Integer idResultado;
	
	@Column(name="Detalle",nullable=false,length=2000)
	private String detalle;
	
	@Column(name="Fecha",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name="ORDEN_EXAMENES_ID_CITA")
	private OrdenExamen ordenExam;
	

	public ResultadoExamen() {
		super();
	}


	public ResultadoExamen(Integer idResultado, String detalle, Date fecha, OrdenExamen ordenExam) {
		super();
		this.idResultado = idResultado;
		this.detalle = detalle;
		this.fecha = fecha;
		this.ordenExam = ordenExam;
	}


	public ResultadoExamen(String detalle, Date fecha, OrdenExamen ordenExam) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.ordenExam = ordenExam;
	}


	public Integer getIdResultado() {
		return idResultado;
	}


	public void setIdResultado(Integer idResultado) {
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


	public OrdenExamen getOrdenExam() {
		return ordenExam;
	}


	public void setOrdenExam(OrdenExamen ordenExam) {
		this.ordenExam = ordenExam;
	}


	
	
}
