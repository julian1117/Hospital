package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TIPO_CIRUGIAS")
@NamedQuery(name=TipoCirugia.LISTAR_TIPO_CIRUGIAS,query="SELECT t FROM TipoCirugia t")
public class TipoCirugia implements Serializable{
	
	public static final String LISTAR_TIPO_CIRUGIAS ="TipoCirugia.listarC";
	
	@Id
	@Column(name="Id")
	private Integer idTipoCirugia;
	
	@Column(name="Tipo_cirugia")
	private String tipoCirugia;
	
	
	public TipoCirugia() {
		super();
	}


	public TipoCirugia(int idTipoCirugia, String tipoCirugia) {
		super();
		this.idTipoCirugia = idTipoCirugia;
		this.tipoCirugia = tipoCirugia;
	}


	public int getIdTipoCirugia() {
		return idTipoCirugia;
	}


	public void setIdTipoCirugia(int idTipoCirugia) {
		this.idTipoCirugia = idTipoCirugia;
	}


	public String getTipoCirugia() {
		return tipoCirugia;
	}


	public void setTipoCirugia(String tipoCirugia) {
		this.tipoCirugia = tipoCirugia;
	}

	
	

}
