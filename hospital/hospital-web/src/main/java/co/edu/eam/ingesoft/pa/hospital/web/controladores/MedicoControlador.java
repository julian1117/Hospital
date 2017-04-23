package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Cita;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.TipoCita;
import co.edu.eam.ingesoft.pa.negocio.beans.CitaEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

@Named(value = "medicoController")
@ViewScoped
public class MedicoControlador implements Serializable{
	
	@Pattern(regexp="[0-9]*",message="Solo numeros")
	@Length(min=1,max=10,message="Longitus de 1 a 10")
	private Long cedulaPaciente;
	
	private Medico medico;
	
	private List<Medico> listaMedicos;
	
	private TipoCita tipoCita;
	
	private List<TipoCita> listTipoCita;
	
	private List<Cita> listaCita;
	
	



	@EJB
	private MedicoEJB medicoEJB;
	
	@EJB
	private CitaEJB citaEJB;
	
	
	@PostConstruct
	public void inicializar(){
		listaMedicos=medicoEJB.listaMedicos();
		listTipoCita=citaEJB.listaTipoCita();
	}
	
	
	public void buscarPaciente(){
		listaCita= citaEJB.listCitaPaciente(cedulaPaciente);
	}
	
	
	public void asignarCita(){
		
	}
	
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}	

	public TipoCita getTipoCita() {
		return tipoCita;
	}

	public void setTipoCita(TipoCita tipoCita) {
		this.tipoCita = tipoCita;
	}

	public List<TipoCita> getListTipoCita() {
		return listTipoCita;
	}

	public void setListTipoCita(List<TipoCita> listTipoCita) {
		this.listTipoCita = listTipoCita;
	}

	public Long getCedulaPaciente() {
		return cedulaPaciente;
	}

	public void setCedulaPaciente(Long cedulaPaciente) {
		this.cedulaPaciente = cedulaPaciente;
	}

	public List<Cita> getListaCita() {
		return listaCita;
	}

	public void setListaCita(List<Cita> listaCita) {
		this.listaCita = listaCita;
	}
	
	

}
