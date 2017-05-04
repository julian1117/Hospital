package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="HOSPITALIZACIONES")
public class Hospitalizacion  implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "HOSPITALIZACION_SEQ")
    @SequenceGenerator(sequenceName = "HOSPITALIZACIONES_SEQ", allocationSize = 1, name = "HOSPITALIZACION_SEQ")
	@Column(name="ID_CIRUGIA",nullable=false)
	private Integer id;
	
	@Column(name="Detalle_hospitalizacion",length=2000)
	private String detalleHospi;
	
	@Column(name="Motivo",length=50)
	private String motivo;

	public Hospitalizacion() {
		super();
	}

	public Hospitalizacion(Integer id, String detalleHospi, String motivo) {
		super();
		this.id = id;
		this.detalleHospi = detalleHospi;
		this.motivo = motivo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDetalleHospi() {
		return detalleHospi;
	}

	public void setDetalleHospi(String detalleHospi) {
		this.detalleHospi = detalleHospi;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	
	
	

}
