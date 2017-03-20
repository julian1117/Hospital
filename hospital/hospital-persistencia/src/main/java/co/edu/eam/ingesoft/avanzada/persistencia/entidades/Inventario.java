package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Inventarios")
public class Inventario implements Serializable {

	@Id
	@Column(name="Id_Inventario",nullable=false)
	private int idInventario;
	
	@Column(name="Cantidad_Disponible",nullable=false)
	private int cantidadDisponible;
	
	@Column(name="Nombre_Medicamento",nullable=false)
	private String nombreMedicamento;
	
	@Column(name="Tipo_Medicamento",nullable=false)
	private TipoMedicamento tipoMedicamento;

	public Inventario() {
		super();
	}

	public Inventario(int idInventario, int cantidadDisponible, String nombreMedicamento,
			TipoMedicamento tipoMedicamento) {
		super();
		this.idInventario = idInventario;
		this.cantidadDisponible = cantidadDisponible;
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
	}

	public int getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public String getNombreMedicamento() {
		return nombreMedicamento;
	}

	public void setNombreMedicamento(String nombreMedicamento) {
		this.nombreMedicamento = nombreMedicamento;
	}

	public TipoMedicamento getTipoMedicamento() {
		return tipoMedicamento;
	}

	public void setTipoMedicamento(TipoMedicamento tipoMedicamento) {
		this.tipoMedicamento = tipoMedicamento;
	}
	
	
}
