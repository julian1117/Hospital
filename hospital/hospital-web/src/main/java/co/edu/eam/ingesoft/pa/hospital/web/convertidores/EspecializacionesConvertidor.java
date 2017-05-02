package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Especializacione;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@FacesConverter(value = "EspecializacionesConver", forClass = Especializacione.class)
@Named("EspecializacionesConver")
public class EspecializacionesConvertidor implements Converter {

	@EJB
	private GeneralEJB generalEJB;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || value.trim().length()==0 || value.equals("Seleccion...")){
			return null;
		}
		return generalEJB.buscarEspecializacione(Integer.parseInt(value));
	
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value instanceof Especializacione){
			Especializacione especializacion = (Especializacione) value;
			return String.valueOf(especializacion.getIdEspecializacion());
		}
		return null;
	}
	
	

}
