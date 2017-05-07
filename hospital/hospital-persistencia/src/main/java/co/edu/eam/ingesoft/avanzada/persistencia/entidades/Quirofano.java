package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Quirofanos")
@NamedQuery(name=Quirofano.LISTAR_QUIROFANO,query="SELECT q FROM Quirofano q")
public class Quirofano implements Serializable{

	public static final String LISTAR_QUIROFANO="Quirofano.listarq";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer id;
	
	@Column(name="Detalle_implementos",nullable=false,length=2000)
	private String detalleImplementos;
	
	@Column(name="Nombre_quirofano",nullable=false,length=30)
	private String nombreQuirofano;
	
	@Column(name="Ocupado",nullable=false)
	private boolean ocupado;
	
	@Column(name="Detalle_ocupacion",nullable=false,length=2000)
	private String detalleOcupacion;
	
	@Column(name="Fecha_ocupado",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaOcupado;

	public Quirofano() {
		super();
	}
	
	





	public Quirofano(Integer id, String detalleImplementos, String nombreQuirofano, boolean ocupado) {
		super();
		this.id = id;
		this.detalleImplementos = detalleImplementos;
		this.nombreQuirofano = nombreQuirofano;
		this.ocupado = ocupado;
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







	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detalleImplementos == null) ? 0 : detalleImplementos.hashCode());
		result = prime * result + ((detalleOcupacion == null) ? 0 : detalleOcupacion.hashCode());
		result = prime * result + ((fechaOcupado == null) ? 0 : fechaOcupado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombreQuirofano == null) ? 0 : nombreQuirofano.hashCode());
		result = prime * result + (ocupado ? 1231 : 1237);
		return result;
	}







	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quirofano other = (Quirofano) obj;
		if (detalleImplementos == null) {
			if (other.detalleImplementos != null)
				return false;
		} else if (!detalleImplementos.equals(other.detalleImplementos))
			return false;
		if (detalleOcupacion == null) {
			if (other.detalleOcupacion != null)
				return false;
		} else if (!detalleOcupacion.equals(other.detalleOcupacion))
			return false;
		if (fechaOcupado == null) {
			if (other.fechaOcupado != null)
				return false;
		} else if (!fechaOcupado.equals(other.fechaOcupado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombreQuirofano == null) {
			if (other.nombreQuirofano != null)
				return false;
		} else if (!nombreQuirofano.equals(other.nombreQuirofano))
			return false;
		if (ocupado != other.ocupado)
			return false;
		return true;
	}
	
	
	
}
