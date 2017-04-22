package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="HOSPITALIZACIONES")
@AttributeOverride(name="PROCEDIMIENTOS_Id_proce",column=@Column(name="PROCEDIMIENTOS_Id"))
public class Hospitalizacion extends Procedimiento implements Serializable{
	
	@Column(name="Detalle_hospitalizacion",length=2000)
	private String detalleProce;
	
	@Column(name="Motivo",length=50)
	private String motivo;

	public Hospitalizacion() {
		super();
	}

	public Hospitalizacion(Procedimiento procedimiento, String detalleProce, String motivo) {
		super();
		;
		this.detalleProce = detalleProce;
		this.motivo = motivo;
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
