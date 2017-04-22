package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@FacesConverter(value="ciudadConver",forClass=Ciudad.class)
@Named("ciudadConver")
public class CiudadConvertidor implements Converter{
	
	@EJB
	private GeneralEJB generalEJB;

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if(value == null || value.trim().length()==0 || value.equals("Seleccion...")){
			return null;
		}
		return generalEJB.buscarCiudad(Integer.parseInt(value));
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		// TODO Auto-generated method stub
		if(value instanceof Ciudad){
			Ciudad ciu = (Ciudad) value;
			return ciu.getNombre();
		}
		return null;
	}

}
