package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Hospitalizaciones")
public class Hospitalizacion implements Serializable{
	
	@Id
	@OneToOne
	@JoinColumn(name="Procedimiento")
	private Procedimiento procedimiento;
	
	@Column(name="Detalle_Procedimiento",length=2000)
	private String detalleProce;
	
	@Column(name="Motivo",length=50)
	private String motivo;

	public Hospitalizacion() {
		super();
	}

	public Hospitalizacion(Procedimiento procedimiento, String detalleProce, String motivo) {
		super();
		this.procedimiento = procedimiento;
		this.detalleProce = detalleProce;
		this.motivo = motivo;
	}

	public Procedimiento getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(Procedimiento procedimiento) {
		this.procedimiento = procedimiento;
	}

	public String getDetalleProce() {
		return detalleProce;
	}

	public void setDetalleProce(String detalleProce) {
		this.detalleProce = detalleProce;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

}
