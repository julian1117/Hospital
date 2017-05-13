package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Eps;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Paciente;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.avanzada.persistencia.enumeraciones.TipoUsuario;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PacienteEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PersonaEJB;

@Named("pacienteControler")
@ViewScoped
public class PacienteControlador implements Serializable {

	// @Pattern(regexp="[0-9]*",message="solo numeros")
	// @Length(min=4,max=10,message="longitud entre 5 y 10")
	private Long idPersona;

	// @Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	// @Length(min=4,max=10,message="longitud entre 5 y 50")
	private String nombre;

	// @Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	// @Length(min=4,max=10,message="longitud entre 5 y 50")
	private String apellido;

	private Date fechaNacimiento;

	// @Pattern(regexp="[0-9]*",message="solo numeros")
	// @Length(min=10,max=10,message="longitud entre 10 y 15")
	private String telefono;

	private String direccion;

	private String tipoUsu;

	private String email;

	private String sexo;

	private Ciudad ciudad;

	private List<Ciudad> nombreCiudad;

	private String fechastr;

	private Eps eps;

	private List<Eps> listaEps;

	@EJB
	private GeneralEJB generalEJB;

	@EJB
	private PersonaEJB personaEJB;

	@EJB
	private PacienteEJB pacienteEJB;

	@PostConstruct
	public void inicializar() {
		nombreCiudad = generalEJB.listarCiudad();
		listaEps = generalEJB.listarEps();
	}

	// public TipoUsuario[] getTipoUsuarios(){
	// return TipoUsuario.values();
	// }

	// public TipoUsuario getTipoUsu() {
	// return tipoUsu;
	// }
	//
	// public void setTipoUsu(TipoUsuario tipoUsu) {
	// this.tipoUsu = tipoUsu;
	// }

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipoUsu() {
		return tipoUsu;
	}

	public void setTipoUsu(String tipoUsu) {
		this.tipoUsu = tipoUsu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public List<Ciudad> getNombreCiudad() {
		return nombreCiudad;
	}

	public void setNombreCiudad(List<Ciudad> nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}

	public String getFechastr() {
		return fechastr;
	}

	public void setFechastr(String fechastr) {
		this.fechastr = fechastr;
	}

	public Eps getEps() {
		return eps;
	}

	public void setEps(Eps eps) {
		this.eps = eps;
	}

	public List<Eps> getListaEps() {
		return listaEps;
	}

	public void setListaEps(List<Eps> listaEps) {
		this.listaEps = listaEps;
	}

	public GeneralEJB getGeneralEJB() {
		return generalEJB;
	}

	public void setGeneralEJB(GeneralEJB generalEJB) {
		this.generalEJB = generalEJB;
	}

	public PersonaEJB getPersonaEJB() {
		return personaEJB;
	}

	public void setPersonaEJB(PersonaEJB personaEJB) {
		this.personaEJB = personaEJB;
	}

	public PacienteEJB getPacienteEJB() {
		return pacienteEJB;
	}

	public void setPacienteEJB(PacienteEJB pacienteEJB) {
		this.pacienteEJB = pacienteEJB;
	}


	public void crearPersona() {

		try {
			Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
			fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);

			
			
			Eps epsB = generalEJB.buscarEps(eps.getIdEps());

			Paciente paciente = new Paciente(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion,
					"Paciente", email, sexo, ciu, epsB);
			pacienteEJB.crearPaciente(paciente);
			idPersona = null;
			nombre = "";
			apellido = "";
			fechaNacimiento = null;
			telefono = "";
			tipoUsu = "";
			email = "";
			sexo = "";
			ciudad = null;
			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}

	}

	public void buscar() {

		Paciente persona = pacienteEJB.buscarPaciente(idPersona);
		if (persona != null) {
			nombre = persona.getNombre();
			apellido = persona.getApellido();
			fechaNacimiento = persona.getFechaNacimiento();
			telefono = persona.getTelefono();
			direccion = persona.getDireccion();
			// tipoUsu=persona.getTipoUsuario();
			email = persona.getEmail();
			sexo = persona.getSexo();
			eps = persona.getEps();
			ciudad = persona.getCiudad();
		} else {
			Messages.addFlashGlobalInfo("El paciente no se encuentra registardo");
		}
	}

	public void editar() {
		try {

			Paciente paciente = pacienteEJB.buscarPaciente(idPersona);
			Ciudad ciud = generalEJB.buscarCiudad(ciudad.getIdCiuad());
			fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);

			if (paciente != null) {
				Paciente pa = new Paciente(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion,
						"Paciente", email, sexo, ciud, eps);
				pacienteEJB.editarPaciente(pa);

				idPersona = null;
				nombre = "";
				apellido = "";
				fechaNacimiento = null;
				telefono = "";
				tipoUsu = null;
				email = "";
				sexo = "";
				ciudad = null;
				eps = null;

				Messages.addFlashGlobalInfo("Editado con exito!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}

	}

	public void eliminar() {
		Persona per = personaEJB.buscarPersona(idPersona);
		personaEJB.eliminar(per);
		Messages.addFlashGlobalInfo("eliminado con exito!!");
	}

}
