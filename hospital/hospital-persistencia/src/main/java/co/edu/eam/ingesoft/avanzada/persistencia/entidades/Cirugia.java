package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Cirugias")
public class Cirugia extends Procedimiento implements Serializable {
	
	@Column(name="Tiempo_Porcedimiento",nullable=false)
	private String tiempoProcedimiento;
	
	@ManyToOne
	@JoinColumn(name="Tipo_Cirugia",nullable=false)
	private TipoCirugia tipoCirugia;
	
	@Column(name="Descripcion_PacienteIni",nullable=false,length=2000)
	private String descripcionPacienteInicio;
	
	@Column(name="Descripcion_PacienteFinal",nullable=false,length=2000)
	private String descripcionPacienteFinal;

	public Cirugia() {
		super();
	}

	public Cirugia(String tiempoProcedimiento, TipoCirugia tipoCirugia,
			String descripcionPacienteInicio, String descripcionPacienteFinal) {
		super();
		this.tiempoProcedimiento = tiempoProcedimiento;
		this.tipoCirugia = tipoCirugia;
		this.descripcionPacienteInicio = descripcionPacienteInicio;
		this.descripcionPacienteFinal = descripcionPacienteFinal;
	}

	public String getTiempoProcedimiento() {
		return tiempoProcedimiento;
	}

	public void setTiempoProcedimiento(String tiempoProcedimiento) {
		this.tiempoProcedimiento = tiempoProcedimiento;
	}

	public TipoCirugia getTipoCirugia() {
		return tipoCirugia;
	}

	public void setTipoCirugia(TipoCirugia tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	public String getDescripcionPacienteInicio() {
		return descripcionPacienteInicio;
	}

	public void setDescripcionPacienteInicio(String descripcionPacienteInicio) {
		this.descripcionPacienteInicio = descripcionPacienteInicio;
	}

	public String getDescripcionPacienteFinal() {
		return descripcionPacienteFinal;
	}

	public void setDescripcionPacienteFinal(String descripcionPacienteFinal) {
		this.descripcionPacienteFinal = descripcionPacienteFinal;
	}
	
	

}
