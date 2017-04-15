package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="Preocedimientos")
@Inheritance(strategy=InheritanceType.JOINED)
public class Procedimiento implements Serializable{
	
	@Id
	@Column(name="Id_Procedimiento",nullable=false)
	private Integer idProcedimiento;	
	
	@Column(name="Tiempo",nullable=false,length=30)
	private String tiempo;


	public Procedimiento() {
		super();
	}


	public Procedimiento(int idProcedimiento, String tiempo) {
		super();
		this.idProcedimiento = idProcedimiento;
		this.tiempo = tiempo;
	}


	public int getIdProcedimiento() {
		return idProcedimiento;
	}


	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}
	

	public String getTiempo() {
		return tiempo;
	}


	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

}
