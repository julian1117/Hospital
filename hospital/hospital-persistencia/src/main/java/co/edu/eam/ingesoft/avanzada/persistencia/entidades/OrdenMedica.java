package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Ordenes_Medicas")
public class OrdenMedica implements Serializable{

	@Id
	@Column(name="Id_Orden")
	private int idOrden;
	
	
	@ManyToOne
	@JoinColumn(name="Cita")
	private Cita cita;
	
	@Column(name="Fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;

	public OrdenMedica() {
		super();
	}

	public OrdenMedica(int idOrden, Cita cita, Date fecha) {
		super();
		this.idOrden = idOrden;
		this.cita = cita;
		this.fecha = fecha;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
}
