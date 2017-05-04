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
@IdClass(ItemMedicamentoPK.class)
public class ItemMedicamento implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita ordenMedicina;
	
	
	@ManyToOne
	@JoinColumn(name="INVENTARIOS_Id",nullable=false)
	private Inventario inventario;
	
	@Column(name="cantidad_Resetada",nullable=false)
	private String cantidadResetada;
	
	@Column(name="formula",nullable=false)
	private String formula;

	public ItemMedicamento() {
		super();
	}

	public ItemMedicamento(Cita ordenMedicina, Inventario inventario, String cantidadResetada, String formula) {
		super();
		this.ordenMedicina = ordenMedicina;
		this.inventario = inventario;
		this.cantidadResetada = cantidadResetada;
		this.formula = formula;
	}

	public Cita getOrdenMedicina() {
		return ordenMedicina;
	}

	public void setOrdenMedicina(Cita ordenMedicina) {
		this.ordenMedicina = ordenMedicina;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public String getCantidadResetada() {
		return cantidadResetada;
	}

	public void setCantidadResetada(String cantidadResetada) {
		this.cantidadResetada = cantidadResetada;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	
	
	
	
	
}
