package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="HORAS_CITAS")
@NamedQuery(name=HoraCita.LISTA_HORAS,query="SELECT h FROM HoraCita h")
public class HoraCita {

	public static final String LISTA_HORAS = "HorasCita.listaHoras";
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="hora",nullable=false, length=10)
	private String hora;

	public HoraCita() {
		super();
	}

	public HoraCita(Integer id, String hora) {
		super();
		this.id = id;
		this.hora = hora;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		HoraCita other = (HoraCita) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
