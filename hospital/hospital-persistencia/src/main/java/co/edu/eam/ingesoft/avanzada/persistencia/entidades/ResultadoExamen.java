package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="Resultados_Examenes")
@IdClass(OrdenProcedimientoPK.class)
public class ResultadoExamen implements Serializable{

	
	@Column(name="Id_Resultado")
	private int idResultado;
	
	@Column(name="Detalle")
	private String detalle;
	
	@Column(name="Fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Procedimiento")
	private Procedimiento procedimiento;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Orden_Medicina")
	private OrdenMedica ordenMedicina;

	public ResultadoExamen() {
		super();
	}

	public ResultadoExamen(int idResultado, String detalle, Date fecha, Procedimiento procedimiento,
			OrdenMedica ordenMedicina) {
		super();
		this.idResultado = idResultado;
		this.detalle = detalle;
		this.fecha = fecha;
		this.procedimiento = procedimiento;
		this.ordenMedicina = ordenMedicina;
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

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public OrdenMedica getOrdenMedicina() {
		return ordenMedicina;
	}

	public void setOrdenMedicina(OrdenMedica ordenMedicina) {
		this.ordenMedicina = ordenMedicina;
	}
	
	
	
}
