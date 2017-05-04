package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

public class ItemMedicamentoPK implements Serializable{
	
	private Integer idInventario;
	
	private Integer idCita;

	public ItemMedicamentoPK() {
		super();
	}

	public ItemMedicamentoPK(int idInventario, int idOrden) {
		super();
		this.idInventario = idInventario;
		this.idCita = idOrden;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public int getIdOrden() {
		return idCita;
	}

	public void setIdOrden(int idOrden) {
		this.idCita = idOrden;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idInventario;
		result = prime * result + idCita;
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
		if (idCita != other.idCita)
			return false;
		return true;
	}
	
	

}
