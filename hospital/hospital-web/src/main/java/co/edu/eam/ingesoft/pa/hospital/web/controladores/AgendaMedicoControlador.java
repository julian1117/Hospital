package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Agenda;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Consultorio;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;

@Named("agendaMedicoControler")
@ViewScoped
public class AgendaMedicoControlador implements Serializable {

	private List<Medico> listaMedicos;

	private static Medico medico;

	@Length(min = 10, max = 10, message = "La longitud debe ser de 10 caracteres")
	private String fechaAgenda;

	private String horaInicio;

	private String horaFinal;
	
	private List<Consultorio> listaConsultio;
	
	private Consultorio consultorio;

	public List<Medico> getListaMedicos() {
		return listaMedicos;
	}

	public void setListaMedicos(List<Medico> listaMedicos) {
		this.listaMedicos = listaMedicos;
	}

	public String getFechaAgenda() {
		return fechaAgenda;
	}

	public void setFechaAgenda(String fechaAgenda) {
		this.fechaAgenda = fechaAgenda;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	public List<Consultorio> getListaConsultio() {
		return listaConsultio;
	}

	public void setListaConsultio(List<Consultorio> listaConsultio) {
		this.listaConsultio = listaConsultio;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}




	@EJB
	private GeneralEJB generalEJB;

	@EJB
	private MedicoEJB medicoEJB;

	@PostConstruct
	public void inicializar() {
		listaMedicos = medicoEJB.listaMedicosCompleta();
		listaConsultio = generalEJB.listaConsultorios();
	}

	public String AgendaMedico(Medico med) {
		medico = med;
		return "/paginas/seguro/Adm/agenda.xhtml?faces-redirect=true";
	}

	public void asignarAgenda(){
		
		Date fec;
		try {
			fec = new SimpleDateFormat("dd-MM-yyyy").parse(fechaAgenda);
			
			Agenda agenda = new Agenda();
			agenda.setConsultorio(consultorio);
			agenda.setFecha(fec);
			agenda.setHoraFinal(horaFinal);
			agenda.setHoraInicio(horaInicio);
			agenda.setMedico(medico);
			
			medicoEJB.crearAgendaMedico(agenda);
			
			Messages.addFlashGlobalInfo("Agenda regsitrada con éxito");
			
			
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}

	}
	
	
}
