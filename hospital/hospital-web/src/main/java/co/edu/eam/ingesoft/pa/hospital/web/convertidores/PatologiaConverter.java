package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Patologia;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@FacesConverter(value = "patologiaConver", forClass = Patologia.class)
@Named("patologiaConver")
public class PatologiaConverter implements Converter {

	@EJB
	private GeneralEJB generalEJB;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seleccion...")) {
			return null;
		}
		return generalEJB.buscarPatologia(Integer.parseInt(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Patologia) {
			Patologia patologia = (Patologia) value;
			return String.valueOf(patologia.getIdPatologia());
		}
		return null;
	}

}
