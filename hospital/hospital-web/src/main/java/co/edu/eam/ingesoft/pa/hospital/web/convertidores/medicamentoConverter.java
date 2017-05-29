package co.edu.eam.ingesoft.pa.hospital.web.convertidores;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.HoraCita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoMedicamento;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;


@FacesConverter(value = "medConverter", forClass =  TipoMedicamento.class)
@Named("medConverter")
public class medicamentoConverter implements Converter{

	@EJB
	private GeneralEJB generalEJB;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if (value == null || value.trim().length() == 0 || value.equals("Seccion...")) {
			return null;
		}	
		return generalEJB.buscarMedicamento(Integer.parseInt(value));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if(value instanceof TipoMedicamento){
			TipoMedicamento tpm = (TipoMedicamento) value;
			return tpm.getIdTipoMedicamento().toString();
		}
		return null;
	}

}
