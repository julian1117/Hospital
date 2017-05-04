package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="INVENTARIOS")
public class Inventario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INVENTARIO_SEQ")
    @SequenceGenerator(sequenceName = "INVENTARIOS_SEQ", allocationSize = 1, name = "INVENTARIO_SEQ")
	@Column(name="Id",nullable=false)
	private Integer idInventario;
	
	@Column(name="Cantidad_disponible",nullable=false)
	private Integer cantidadDisponible;
	
	@Column(name="Nombre_medicamento",nullable=false,length=40)
	private String nombreMedicamento;
	
	@ManyToOne
	@JoinColumn(name="TIPO_MEDICAMENTO_Id",nullable=false)
	private TipoMedicamento tipoMedicamento;

	@Column(name="precio")
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
