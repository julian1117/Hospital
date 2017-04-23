package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TIPOS_CITAS")
@NamedQuery(name=TipoCita.LISTA_TIPO_CITAS,query="SELECT tp FROM TipoCita tp")
public class TipoCita implements Serializable {

	public static final String LISTA_TIPO_CITAS = "TipoCita.ListaTipo";
	
	@Id
	@Column(name="Id",nullable=false)
	private Integer idTipoCita;
	
	@Column(name="Nombre",unique= false,nullable=false,length=40)
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
