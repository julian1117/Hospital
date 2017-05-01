package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;

@FacesConverter(value = "citaConver", forClass = Cita.class)
@Named("citaConver")
public class CitaConvertidor implements Converter {

	@EJB
	private CitaEJB citaEJB;

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seleccion...")) {
			return null;
		}
		return citaEJB.buscarCita(Integer.parseInt(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Cita) {
			Cita cita = (Cita) value;
			return String.valueOf(cita.getIdCita());
		}
		return null;
	}

}
