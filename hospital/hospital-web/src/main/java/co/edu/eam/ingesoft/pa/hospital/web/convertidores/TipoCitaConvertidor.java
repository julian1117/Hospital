package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

@FacesConverter(value="tipoCitaConver", forClass=TipoCita.class)
@Named("tipoCitaConver")
public class TipoCitaConvertidor implements Converter{

	@EJB
	private CitaEJB citaEJB;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value == null || value.trim().length()==0 || value.equals("Seleccion...")){
			return null;
		}
		return citaEJB.buscarTipoDeCita(Integer.parseInt(value));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value instanceof TipoCita){
			TipoCita tp = (TipoCita) value;
			return String.valueOf(tp.getIdTipoCita()) ;
		}
		return null;
	}

}
