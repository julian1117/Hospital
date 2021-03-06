package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CITAS")
@NamedQuery(name=Cita.LISTA_CITA,query="SELECT c FROM Cita c WHERE c.persona.idPersona =?1")
public class Cita implements Serializable{
	
	public static final  String LISTA_CITA = "Cita.listaCita";
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CIT_SEQ")
    @SequenceGenerator(sequenceName = "CITAS_SEQ", allocationSize = 1, name = "CIT_SEQ")
	@Column(name="Id",nullable=false)
	private Integer idCita;
	
	@ManyToOne
	@JoinColumn(name="AGENDAS_Id",nullable=false)
	private Agenda agenda;
	
	@ManyToOne
	@JoinColumn(name="TIPOS_CITAS_Id",nullable=false)
	private TipoCita tipoCita;
	
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=true)
	private Cita cita;
	
	@ManyToOne
	@JoinColumn(name="PACIENTES_PERSONA_Id",nullable=false)
	private Paciente persona;
	
	@Column(name="esteado")
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="HORAS_CITAS_id",nullable=false)
	private HoraCita horaCita;

	public Cita() {
		super();
	}

	public Cita(Integer idCita, Agenda agenda, TipoCita tipoCita, Cita cita, Paciente persona, boolean estado,
			HoraCita horaCita) {
		super();
		this.idCita = idCita;
		this.agenda = agenda;
		this.tipoCita = tipoCita;
		this.cita = cita;
		this.persona = persona;
		this.estado = estado;
		this.horaCita = horaCita;
	}
	

	public Integer getIdCita() {
		return idCita;
	}



	public void setIdCita(Integer idCita) {
		this.idCita = idCita;
	}



	public Agenda getAgenda() {
		return agenda;
	}



	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}



	public TipoCita getTipoCita() {
		return tipoCita;
	}



	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}



	public Cita getCita() {
		return cita;
	}



	public void setCita(Cita cita) {
		this.cita = cita;
	}



	public Paciente getPersona() {
		return persona;
	}



	public void setPersona(Paciente persona) {
		this.persona = persona;
	}



	public boolean isEstado() {
		return estado;
	}



	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public HoraCita getHoraCita() {
		return horaCita;
	}



	public void setHoraCita(HoraCita horaCita) {
		this.horaCita = horaCita;
	}






	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCita == null) ? 0 : idCita.hashCode());
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
		Cita other = (Cita) obj;
		if (idCita == null) {
			if (other.idCita != null)
				return false;
		} else if (!idCita.equals(other.idCita))
			return false;
		return true;
	}

	
	
	
	
}
