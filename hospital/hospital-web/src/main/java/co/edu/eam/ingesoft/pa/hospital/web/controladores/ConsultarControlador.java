package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.pa.negocio.beans.ConsultaEJB;

@Named("consultaController")
@ViewScoped
public class ConsultarControlador implements Serializable{
	
	
	
	private List<String> listarPaciente;
	
	private Persona paciente;
	
	@EJB
	private ConsultaEJB consultaEJB;
	
	@PostConstruct
	public void inicializar(){
		listarPaciente = consultaEJB.listarPacientesCirugias();
		
		}


	public List<String> getListarPaciente() {
		return listarPaciente;
	}

	public void setListarPaciente(List<String> listarPaciente) {
		this.listarPaciente = listarPaciente;
	}

	public Persona getPaciente() {
		return paciente;
	}

	public void setPaciente(Persona paciente) {
		this.paciente = paciente;
	}
	
	

}
