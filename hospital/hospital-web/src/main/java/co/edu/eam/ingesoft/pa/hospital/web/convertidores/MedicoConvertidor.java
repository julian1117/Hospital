package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

@FacesConverter(value="MedicoConver", forClass=Medico.class)
@Named("MedicoConver")
public class MedicoConvertidor implements Converter{

	@EJB
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
			return medico.getIdPersona()+"";
		}
		return null;
	}

}
