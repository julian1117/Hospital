package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Quirofano;
import co.edu.eam.ingesoft.pa.negocio.beans.QuirofanoEJB;


@FacesConverter(value="quirofanoConver",forClass=Quirofano.class)
@Named("quirofanoConver")
public class QuirofanoConvertidor implements Converter{

	@EJB
	private QuirofanoEJB quirofanoEJB;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.trim().length()==0 || value.equals("Seleccion...")){
			return null;
		}
		return quirofanoEJB.buscarQuirofano(Integer.parseInt(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Quirofano){
			Quirofano qui = (Quirofano) value;
			return String.valueOf(qui.getId());
		}
		return null;
	}

}
