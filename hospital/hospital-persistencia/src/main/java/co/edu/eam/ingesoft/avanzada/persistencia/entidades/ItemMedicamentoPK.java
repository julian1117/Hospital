package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class ItemMedicamentoPK implements Serializable{
	
	private int idInventario;
	
	private int idOrden;

	public ItemMedicamentoPK() {
		super();
	}

	public ItemMedicamentoPK(int idInventario, int idOrden) {
		super();
		this.idInventario = idInventario;
		this.idOrden = idOrden;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public int getIdOrden() {
		return idOrden;
	}

	public void setIdOrden(int idOrden) {
		this.idOrden = idOrden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idInventario;
		result = prime * result + idOrden;
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
		ItemMedicamentoPK other = (ItemMedicamentoPK) obj;
		if (idInventario != other.idInventario)
			return false;
		if (idOrden != other.idOrden)
			return false;
		return true;
	}
	
	

}
