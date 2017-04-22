package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
@FacesConverter(value="MedicoConver", forClass=Medico.class)
public class MedicoConvertidor implements Converter{

	private MedicoEJB medicoEJB;
	
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value == null || value.trim().length()==0 || value.equals("Seleccion...")){
			return null;
		}
		return medicoEJB.buscarMedico(Long.parseLong(value));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value instanceof Medico){
			Medico medico = (Medico) value;
			return medico.getNombre();
		}
		return null;
	}

}
