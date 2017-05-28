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
@Table(name="DIGNOSTICO")
@IdClass(DiagnosticoPK.class)
public class Diagnostico implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita idCita;
	
	@Id
	@ManyToOne
	@JoinColumn(name="PATOLOGIAS_Id",nullable=false)
	private Patologia patologiaId;
	
	@Column(name="diagnostico_medico",nullable=false)
	private String diagnostico;

	public Diagnostico() {
		super();
	}

	

	public Diagnostico(Cita idCita, Patologia patologiaId, String diagnostico) {
		super();
		this.idCita = idCita;
		this.patologiaId = patologiaId;
		this.diagnostico = diagnostico;
	}

	

	public String getDiagnostico() {
		return diagnostico;
	}



	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}



	public Cita getIdCita() {
		return idCita;
	}

	public void setIdCita(Cita idCita) {
		this.idCita = idCita;
	}

	public Patologia getPatologiaId() {
		return patologiaId;
	}

	public void setPatologiaId(Patologia patologiaId) {
		this.patologiaId = patologiaId;
	}
	
	

}
