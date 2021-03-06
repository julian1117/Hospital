package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROGRAMACION_CIRUGIAS")
public class ProgramacionCirugia implements Serializable{
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idProgramacionCi;
	
	@ManyToOne
	@JoinColumn(name="QUIROFANOS_Id",nullable=false)
	private Quirofano idQuirofano;
	


	public ProgramacionCirugia() {
		super();
	}



	public ProgramacionCirugia(Integer idProgramacionCi, Quirofano idQuirofano) {
		super();
		this.idProgramacionCi = idProgramacionCi;
		this.idQuirofano = idQuirofano;
	}



	public Integer getIdProgramacionCi() {
		return idProgramacionCi;
	}



	public void setIdProgramacionCi(Integer idProgramacionCi) {
		this.idProgramacionCi = idProgramacionCi;
	}



	public Quirofano getIdQuirofano() {
		return idQuirofano;
	}



	public void setIdQuirofano(Quirofano idQuirofano) {
		this.idQuirofano = idQuirofano;
	}

	
	

}
