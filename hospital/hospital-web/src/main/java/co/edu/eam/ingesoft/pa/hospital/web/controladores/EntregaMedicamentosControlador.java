package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.ItemMedicamento;
import co.edu.eam.ingesoft.pa.negocio.beans.EntregaMedEJB;

@Named("entregaMed")
@ViewScoped
public class EntregaMedicamentosControlador implements Serializable{

	
	@Pattern(regexp = "[0-9]*", message = "Solo numeros")
	@Length(min = 5, max = 10, message = "Campo cedula -Longitud de 5 a 10")
	private String cedulaPacienteLis;
	
	private List<ItemMedicamento> listaItemMedicamentos;

	@EJB
	private EntregaMedEJB entregaMedEJB;
	
	/**
	 * lista de medicamentos de un paciente
	 */
	public void buscarMedicamentosPac(){		
		listaItemMedicamentos=entregaMedEJB.listaMedPac(Long.parseLong(cedulaPacienteLis));	
		if(listaItemMedicamentos.isEmpty()){
			Messages.addFlashGlobalError("El usuario no tiene ordenes pendientes por medicamentos");
		}
	}
		
	
	public void entregaMed(ItemMedicamento itMed){
		
		entregaMedEJB.entregaMedicamentos(itMed);
		listaItemMedicamentos=entregaMedEJB.listaMedPac(Long.parseLong(cedulaPacienteLis));	
		
	}
	
	
	
	
	
	
	public String getCedulaPacienteLis() {
		return cedulaPacienteLis;
	}

	public void setCedulaPacienteLis(String cedulaPacienteLis) {
		this.cedulaPacienteLis = cedulaPacienteLis;
	}

	public List<ItemMedicamento> getListaItemMedicamentos() {
		return listaItemMedicamentos;
	}

	public void setListaItemMedicamentos(List<ItemMedicamento> listaItemMedicamentos) {
		this.listaItemMedicamentos = listaItemMedicamentos;
	}

}
