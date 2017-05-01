package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.HoraCita;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@FacesConverter(value = "horasConverter", forClass =  HoraCita.class)
@Named("horasConverter")
public class HorasConvertidor implements Converter {

	@EJB
	private GeneralEJB generalEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seccion...")) {
			return null;
		}
		return generalEJB.buscarHoraCita(Integer.parseInt(value));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {

		if (value instanceof HoraCita) {
			HoraCita horCi = (HoraCita) value;
			return horCi.getId().toString();
		}
		return null;
	}

}
