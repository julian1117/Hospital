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
	private Integer idInventario;
	
	@Column(name="Cantidad_Disponible",nullable=false)
	private Integer cantidadDisponible;
	
	@Column(name="Nombre_Medicamento",nullable=false,length=40)
	private String nombreMedicamento;
	
	@Column(name="Tipo_Medicamento",nullable=false)
	private TipoMedicamento tipoMedicamento;

	@Column(name="Precio_medicamento")
	private Double precioMedicamento;
	
	public Inventario(int idInventario, int cantidadDisponible, String nombreMedicamento,
			TipoMedicamento tipoMedicamento, double precioMedicamento) {
		super();
		this.idInventario = idInventario;
		this.cantidadDisponible = cantidadDisponible;
		this.nombreMedicamento = nombreMedicamento;
		this.tipoMedicamento = tipoMedicamento;
		this.precioMedicamento = precioMedicamento;
	}

	public Inventario() {
		super();
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

	public double getPrecioMedicamento() {
		return precioMedicamento;
	}

	public void setPrecioMedicamento(double precioMedicamento) {
		this.precioMedicamento = precioMedicamento;
	}

	
	
}
