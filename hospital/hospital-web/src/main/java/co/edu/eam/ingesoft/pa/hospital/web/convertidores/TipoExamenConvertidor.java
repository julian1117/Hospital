package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Causa;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoExamen;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@FacesConverter(value = "tipoExamenConver", forClass = TipoExamen.class)
@Named("tipoExamenConver")
public class TipoExamenConvertidor implements Converter{
	
	@EJB
	private GeneralEJB generalEJB;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seleccion...")) {
			return null;
		}	
		return generalEJB.buscarTipoExamen(Integer.parseInt(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof TipoExamen){
			TipoExamen tipo = (TipoExamen) value;
			return String.valueOf(tipo.getIdTipoExamenes());
		}
		return null;
	}

}
