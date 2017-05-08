package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Agenda;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;

@FacesConverter(value = "agendaConver", forClass = Agenda.class)
@Named("agendaConver")
public class AgendaConverter implements Converter {

	@EJB
	private CitaEJB citaEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seleccion...")) {
			return null;
		}
		return citaEJB.buscarAgenda(Integer.parseInt(value));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value instanceof Agenda) {
			Agenda agenda = (Agenda) value;
			return String.valueOf(agenda.getId());
		}
		return null;
	}

}
