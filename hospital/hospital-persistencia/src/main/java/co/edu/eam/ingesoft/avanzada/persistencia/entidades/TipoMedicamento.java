package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_MEDICAMENTO")
public class TipoMedicamento implements Serializable{
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idTipoMedicamento;
	
	@Column(name="Tipo_med",nullable=false,length=30)
	private String tipoMedicamento;
	
	
	@Column(name="presentacion_med")
	private String presentacion;
	

	public TipoMedicamento() {
		super();
	}


	public TipoMedicamento(Integer idTipoMedicamento, String tipoMedicamento, String presentacion) {
		super();
		this.idTipoMedicamento = idTipoMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.presentacion = presentacion;
	}


	public Integer getIdTipoMedicamento() {
		return idTipoMedicamento;
	}


	public void setIdTipoMedicamento(Integer idTipoMedicamento) {
		this.idTipoMedicamento = idTipoMedicamento;
	}


	public String getTipoMedicamento() {
		return tipoMedicamento;
	}


	public void setTipoMedicamento(String tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}


	public String getPresentacion() {
		return presentacion;
	}


	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}
		
}
