package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Causa;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Consultorio;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@FacesConverter(value="consultorioConver",forClass=Ciudad.class)
@Named("consultorioConver")
public class ConsultorioConvertidor implements Converter {

	@EJB
	private GeneralEJB generalEJB;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seleccion...")) {
			return null;
		}	
		return generalEJB.buscarConsultorio(Integer.parseInt(value));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value instanceof Consultorio){
			Consultorio consultorio = (Consultorio) value;
			return String.valueOf(consultorio.getId());
		}
		return null;
	}

}
