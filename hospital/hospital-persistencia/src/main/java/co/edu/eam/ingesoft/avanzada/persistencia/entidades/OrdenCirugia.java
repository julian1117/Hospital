package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ORDEN_CIRUGIAS")
public class OrdenCirugia implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDEN_CIRUGIA_SEQ")
    @SequenceGenerator(sequenceName = "ORDEN_CIRUGIAS_SEQ", allocationSize = 1, name = "ORDEN_CIRUGIA_SEQ")
	@Column(name="ID_ORDEN_CIRUGIA",nullable=false)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="CITAS_Id",nullable=false)
	private Cita idCita;
	
	
	@ManyToOne
	@JoinColumn(name="CIRUGIAS_ID_CIRUGIA",nullable=false)
	private Cirugia idCirugia;
	
	

	public OrdenCirugia() {
		super();
	}



	public OrdenCirugia(Integer id, Cita idCita, Cirugia idCirugia) {
		super();
		this.id = id;
		this.idCita = idCita;
		this.idCirugia = idCirugia;
	}



	public OrdenCirugia(Cita idCita, Cirugia idCirugia) {
		super();
		this.idCita = idCita;
		this.idCirugia = idCirugia;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Cita getIdCita() {
		return idCita;
	}



	public void setIdCita(Cita idCita) {
		this.idCita = idCita;
	}



	public Cirugia getIdCirugia() {
		return idCirugia;
	}



	public void setIdCirugia(Cirugia idCirugia) {
		this.idCirugia = idCirugia;
	}


	
	

}
