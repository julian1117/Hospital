package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Tipos_Citas")
public class TipoCita implements Serializable {

	@Id
	@Column(name="Id_TipoCita",nullable=false)
	private int idTipoCita;
	
	@Column(name="Nombre",unique= false,nullable=false)
	private String nombre;

	public TipoCita() {
		super();
	}

	public TipoCita(int idTipoCita, String nombre) {
		super();
		this.idTipoCita = idTipoCita;
		this.nombre = nombre;
	}

	public int getIdTipoCita() {
		return idTipoCita;
	}

	public void setIdTipoCita(int idTipoCita) {
		this.idTipoCita = idTipoCita;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
