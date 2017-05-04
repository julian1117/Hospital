package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AGENDAS")
public class Agenda implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENDA_SEQ")
    @SequenceGenerator(sequenceName = "AGENDAS_SEQ", allocationSize = 1, name = "AGENDA_SEQ")
	@Column(name="Id",nullable=false)
	private Integer id;
	
	@Column(name="Hora_inicio",nullable=false)
	private String horaInicio;
	
	
	@Column(name="Hora_final",nullable=false)
	private String horaFinal;
	
	@ManyToOne
	@JoinColumn(name="MEDICOS_PERSONAS_Id",nullable=false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="CONSULTORIOS_id")
	private Consultorio consultorio;
	
	public Agenda() {
		super();
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}


	public String getHoraFinal() {
		return horaFinal;
	}


	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}


	public Medico getMedico() {
		return medico;
	}


	public void setMedico(Medico medico) {
		this.medico = medico;
	}


	public Consultorio getConsultorio() {
		return consultorio;
	}


	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}


	public Agenda(Integer id, String horaInicio, String horaFinal, Medico medico, Consultorio consultorio) {
		super();
		this.id = id;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
		this.medico = medico;
		this.consultorio = consultorio;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Agenda other = (Agenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

	

}
