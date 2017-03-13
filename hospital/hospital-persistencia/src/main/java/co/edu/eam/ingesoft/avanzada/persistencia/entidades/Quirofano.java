package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Quirofanos")
public class Quirofano implements Serializable{

	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Detalle_Impemento")
	private String detalleImplementos;
	
	@Column(name="Nombre_Quirofano")
	private String nombreQuirofano;
	
	@Column(name="Ocupado")
	private boolean ocupado;
	
	@Column(name="Detalle_Ocupacion")
	private String detalleOcupacion;
	
	@Column(name="Fecha_Ocupado")
	@Temporal(TemporalType.DATE)
	private Date fechaOcupado;

	public Quirofano() {
		super();
	}

	public Quirofano(int id, String detalleImplementos, String nombreQuirofano, boolean ocupado,
			String detalleOcupacion, Date fechaOcupado) {
		super();
		this.id = id;
		this.detalleImplementos = detalleImplementos;
		this.nombreQuirofano = nombreQuirofano;
		this.ocupado = ocupado;
		this.detalleOcupacion = detalleOcupacion;
		this.fechaOcupado = fechaOcupado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalleImplementos() {
		return detalleImplementos;
	}

	public void setDetalleImplementos(String detalleImplementos) {
		this.detalleImplementos = detalleImplementos;
	}

	public String getNombreQuirofano() {
		return nombreQuirofano;
	}

	public void setNombreQuirofano(String nombreQuirofano) {
		this.nombreQuirofano = nombreQuirofano;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public String getDetalleOcupacion() {
		return detalleOcupacion;
	}

	public void setDetalleOcupacion(String detalleOcupacion) {
		this.detalleOcupacion = detalleOcupacion;
	}

	public Date getFechaOcupado() {
		return fechaOcupado;
	}

	public void setFechaOcupado(Date fechaOcupado) {
		this.fechaOcupado = fechaOcupado;
	}
	
	
	
}
