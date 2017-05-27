package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ITEM_MEDICAMENTOS")
public class ItemMedicamento implements Serializable{

	
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita idCita;
	
	
	@ManyToOne
	@JoinColumn(name="tipo_medicamento_id",nullable=false)
	private TipoMedicamento tipoMedicamento;
	
	@Column(name="cantidad_resetada",nullable=false)
	private Integer cantidadResetada;
	
	@Column(name="formula",nullable=false)
	private String formula;
	
	@Column(name="estado")
	private boolean estado;

	public ItemMedicamento() {
		super();
	}

	
	public ItemMedicamento(Integer id, Cita idCita, TipoMedicamento tipoMedicamento, Integer cantidadResetada,
			String formula, boolean estado) {
		super();
		this.id = id;
		this.idCita = idCita;
		this.tipoMedicamento = tipoMedicamento;
		this.cantidadResetada = cantidadResetada;
		this.formula = formula;
		this.estado = estado;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Cita getIdCita() {
		return idCita;
	}


	public void setIdCita(Cita idCita) {
		this.idCita = idCita;
	}


	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}


	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}


	public Integer getCantidadResetada() {
		return cantidadResetada;
	}


	public void setCantidadResetada(Integer cantidadResetada) {
		this.cantidadResetada = cantidadResetada;
	}


	public String getFormula() {
		return formula;
	}


	public void setFormula(String formula) {
		this.formula = formula;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ItemMedicamento other = (ItemMedicamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	
}
