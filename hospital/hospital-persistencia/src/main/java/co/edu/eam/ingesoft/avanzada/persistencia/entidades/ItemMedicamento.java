package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Items_Medicamentos")
@IdClass(ItemMedicamentoPK.class)
public class ItemMedicamento implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="Orden_Medicina")
	private OrdenMedica ordenMedicina;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Inventario")
	private Inventario inventario;

	public ItemMedicamento() {
		super();
	}

	public ItemMedicamento(OrdenMedica ordenMedicina, Inventario inventario) {
		super();
		this.ordenMedicina = ordenMedicina;
		this.inventario = inventario;
	}

	public OrdenMedica getOrdenMedicina() {
		return ordenMedicina;
	}

	public void setOrdenMedicina(OrdenMedica ordenMedicina) {
		this.ordenMedicina = ordenMedicina;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	
	
	
}
