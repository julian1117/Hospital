package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipos_Medicamentos")
public class TipoMedicamento implements Serializable{
	
	@Id
	@Column(name="Id_Medicamento")
	private int idTipoMedicamento;
	
	@Column(name="Tipo_Medicamento")
	private int tipoMedicamento;
	
	

	public TipoMedicamento() {
		super();
	}



	public TipoMedicamento(int idTipoMedicamento, int tipoMedicamento) {
		super();
		this.idTipoMedicamento = idTipoMedicamento;
		this.tipoMedicamento = tipoMedicamento;
	}



	public int getIdTipoMedicamento() {
		return idTipoMedicamento;
	}



	public void setIdTipoMedicamento(int idTipoMedicamento) {
		this.idTipoMedicamento = idTipoMedicamento;
	}



	public int getTipoMedicamento() {
		return tipoMedicamento;
	}



	public void setTipoMedicamento(int tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	
		
}
