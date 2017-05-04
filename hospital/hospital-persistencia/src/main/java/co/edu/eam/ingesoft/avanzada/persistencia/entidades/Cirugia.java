package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="CIRUGIAS")
public class Cirugia  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIRUGIA_SEQ")
    @SequenceGenerator(sequenceName = "CIRUGIAS_SEQ", allocationSize = 1, name = "CIRUGIA_SEQ")
	@Column(name="ID_CIRUGIA",nullable=false)
	private Integer id;
	
	@Column(name="Tiempo_Porcedimiento",nullable=false)
	private String tiempoProcedimiento;
	
	@ManyToOne
	@JoinColumn(name="TIPO_CIRUGIAS_Id",nullable=false)
	private TipoCirugia tipoCirugia;
	
	@Column(name="Descripcion_pasiente_inicio",nullable=false,length=2000)
	private String descripcionPacienteInicio;
	
	@Column(name="Descripcion_pasiente_final",nullable=false,length=2000)
	private String descripcionPacienteFinal;
	
	@ManyToOne
	@JoinColumn(name="PROGRAMACION_CIRUGIAS_Id",nullable=false,unique=true)
	private ProgramacionCirugia programacionCirugia;
	
	

	public Cirugia() {
		super();
	}



	public Cirugia(Integer id, String tiempoProcedimiento, TipoCirugia tipoCirugia, String descripcionPacienteInicio,
			String descripcionPacienteFinal, ProgramacionCirugia programacionCirugia) {
		super();
		this.id = id;
		this.tiempoProcedimiento = tiempoProcedimiento;
		this.tipoCirugia = tipoCirugia;
		this.descripcionPacienteInicio = descripcionPacienteInicio;
		this.descripcionPacienteFinal = descripcionPacienteFinal;
		this.programacionCirugia = programacionCirugia;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
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



	public ProgramacionCirugia getProgramacionCirugia() {
		return programacionCirugia;
	}



	public void setProgramacionCirugia(ProgramacionCirugia programacionCirugia) {
		this.programacionCirugia = programacionCirugia;
	}

	

}
