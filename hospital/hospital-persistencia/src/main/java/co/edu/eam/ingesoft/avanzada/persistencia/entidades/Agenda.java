package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="AGENDAS")
public class Agenda implements Serializable{
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer id;
	
	@Column(name="fecha_cita",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaCita;
	
	@ManyToOne
	@JoinColumn(name="HORA",nullable=false)
	private HoraCita hora;
	
	@ManyToOne
	@JoinColumn(name="MEDICOS_PERSONAS_Id",nullable=false)
	private Medico medico;
	
	@ManyToOne
	@JoinColumn(name="CONSULTORIOS_id",nullable=false)
	private Consultorio consultorio;
	
	public Agenda() {
		super();
	}

	public Agenda(Integer id, Date fechaCita, HoraCita hora, Medico medico, Consultorio consultorio) {
		super();
		this.id = id;
		this.fechaCita = fechaCita;
		this.hora = hora;
		this.medico = medico;
		this.consultorio = consultorio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public HoraCita getHora() {
		return hora;
	}

	public void setHora(HoraCita hora) {
		this.hora = hora;
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
