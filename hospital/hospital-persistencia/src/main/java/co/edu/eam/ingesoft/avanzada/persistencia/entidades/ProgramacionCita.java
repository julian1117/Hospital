package co.edu.eam.ingesoft.avanzada.persistencia.entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Programaciones_Citas")
@IdClass(OrdenProcedimientoPK.class)
public class ProgramacionCita implements Serializable{
	
	

}
