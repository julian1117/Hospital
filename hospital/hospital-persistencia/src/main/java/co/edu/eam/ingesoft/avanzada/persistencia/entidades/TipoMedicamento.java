package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_MEDICAMENTO")
@NamedQuery(name=TipoMedicamento.LISTA_MEDICAMENTOS,query="SELECT T FROM TipoMedicamento T")
public class TipoMedicamento implements Serializable{
	
	public static final String LISTA_MEDICAMENTOS = "TipoMedicamento.tipoMed";
	
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoMedicamento == null) ? 0 : idTipoMedicamento.hashCode());
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
		TipoMedicamento other = (TipoMedicamento) obj;
		if (idTipoMedicamento == null) {
			if (other.idTipoMedicamento != null)
				return false;
		} else if (!idTipoMedicamento.equals(other.idTipoMedicamento))
			return false;
		return true;
	}
	
	
		
}
