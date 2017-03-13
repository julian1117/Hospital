package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipos_Cirugias")
public class TipoCirugia implements Serializable{
	
	@Id
	@Column(name="Id_Tipo_Cirugia")
	private int idTipoCirugia;
	
	@Column(name="Detalle")
	private String detallesHospitalizacion;
	
	@Column(name="Motivo")
	private String motivo;

	public TipoCirugia() {
		super();
	}

	public TipoCirugia(int idTipoCirugia, String detallesHospitalizacion, String motivo) {
		super();
		this.idTipoCirugia = idTipoCirugia;
		this.detallesHospitalizacion = detallesHospitalizacion;
		this.motivo = motivo;
	}

	public int getIdTipoCirugia() {
		return idTipoCirugia;
	}

	public void setIdTipoCirugia(int idTipoCirugia) {
		this.idTipoCirugia = idTipoCirugia;
	}

	public String getDetallesHospitalizacion() {
		return detallesHospitalizacion;
	}

	public void setDetallesHospitalizacion(String detallesHospitalizacion) {
		this.detallesHospitalizacion = detallesHospitalizacion;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	

}
