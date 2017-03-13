package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Causas_Patologias")
public class CausaPatologia implements Serializable {

	@Id
	@Column(name="Id_Causa_Patologia")
	private int idCausasPa;
	
	@Column(name="Nombre")
	private String nombre;

	public CausaPatologia() {
		super();
	}

	public CausaPatologia(int idCausasPa, String nombre) {
		super();
		this.idCausasPa = idCausasPa;
		this.nombre = nombre;
	}

	public int getIdCausasPa() {
		return idCausasPa;
	}

	public void setIdCausasPa(int idCausasPa) {
		this.idCausasPa = idCausasPa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
