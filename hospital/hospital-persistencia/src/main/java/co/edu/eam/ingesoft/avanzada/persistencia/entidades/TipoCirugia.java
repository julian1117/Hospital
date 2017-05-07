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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTipoCirugia == null) ? 0 : idTipoCirugia.hashCode());
		result = prime * result + ((tipoCirugia == null) ? 0 : tipoCirugia.hashCode());
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
		TipoCirugia other = (TipoCirugia) obj;
		if (idTipoCirugia == null) {
			if (other.idTipoCirugia != null)
				return false;
		} else if (!idTipoCirugia.equals(other.idTipoCirugia))
			return false;
		if (tipoCirugia == null) {
			if (other.tipoCirugia != null)
				return false;
		} else if (!tipoCirugia.equals(other.tipoCirugia))
			return false;
		return true;
	}

	
	

}
