package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Preocedimientos")
public class Procedimiento implements Serializable{
	
	@Id
	@Column(name="Id-Procedimiento",nullable=false)
	private int idProcedimiento;
	
	
	@Column(name="Tipo",nullable=false)
	private String tipo;
	
	
	@Column(name="Tiempo",nullable=false)
	private String tiempo;


	public Procedimiento() {
		super();
	}


	public Procedimiento(int idProcedimiento, String tipo, String tiempo) {
		super();
		this.idProcedimiento = idProcedimiento;
		this.tipo = tipo;
		this.tiempo = tiempo;
	}


	public int getIdProcedimiento() {
		return idProcedimiento;
	}


	public void setIdProcedimiento(int idProcedimiento) {
		this.idProcedimiento = idProcedimiento;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTiempo() {
		return tiempo;
	}


	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	
	

}
