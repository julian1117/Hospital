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

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Eps;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Roll;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PacienteEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PersonaEJB;

@Named("administradorControler")
@ViewScoped
public class AdministradorControlador implements Serializable {

	 @Pattern(regexp="[0-9]*",message="El numero de  identificacion solo puede llevar caracteres numericos")
	 @Length(min=4,max=10,message="Cedula - longitud entre 4 y 10")
	private String idPersona;

	 @Pattern(regexp="[A-Za-z ]*",message="nombre solo permites caracteres alfabetico")
	 @Length(min=3,max=20,message="nombre-longitud entre 3 y 20")
	private String nombre;

	 @Pattern(regexp="[A-Za-z ]*",message="Apellido solo permites caracteres alfabetico")
	 @Length(min=3,max=50,message="Apellido-longitud entre 3 y 50")
	private String apellido;

	private Date fechaNacimiento;

	@Pattern(regexp="[0-9]*",message="telefono solo puede llevar caracteres numericos")
	@Length(min=7,max=10,message="telefono-longitud de 10 ")
	private String telefono;

	private String direccion;

	private String tipoUsu;

	@Email
	private String email;

	private String sexo;

	private Ciudad ciudad;

	private List<Ciudad> nombreCiudad;

	private String fechastr;

	private Eps eps;
	
	private Roll roles;

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

	
	
	public Roll getRoles() {
		return roles;
	}



	public void setRoles(Roll roles) {
		this.roles = roles;
	}



	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
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

	public void crearAdministrador() {
		try {

			Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
//		<	fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Roll roll = generalEJB.buscarRol(1);
			Persona persona = new Persona(Long.parseLong(idPersona), nombre, apellido, fechaNacimiento, telefono, direccion, roll, email, sexo, ciu);
			Persona buscarEmail = personaEJB.buscarPersona(Long.parseLong(idPersona));
			
				personaEJB.crearPersona(persona);
			
			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");
			idPersona = null;
			nombre = "";
			apellido = "";
			fechaNacimiento = null;
			telefono = "";
			email = "";
			sexo = "";
			ciudad = null;
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}
	}

	public void buscar() {

		try {
			Persona persona = personaEJB.buscarPersona(Long.parseLong(idPersona));
			if (persona != null) {
				nombre = persona.getNombre();
				apellido = persona.getApellido();
				fechaNacimiento = persona.getFechaNacimiento();
				telefono = persona.getTelefono();
				direccion = persona.getDireccion();
				email = persona.getEmail();
				sexo = persona.getSexo();
				ciudad = persona.getCiudad();

			} else {
				Messages.addFlashGlobalInfo("El administrador no se encuentra registardo");
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}

	}

	public void editar() {
		try {
			Persona persona = personaEJB.buscarPersona(Long.parseLong(idPersona));
			Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
//			fechaNacimiento = new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Roll roll = generalEJB.buscarRol(1);
			if (persona != null) {
				Persona per = new Persona(Long.parseLong(idPersona), nombre, apellido, fechaNacimiento, telefono, direccion, roll, email, sexo, ciu);
				personaEJB.editar(per);
				Messages.addFlashGlobalInfo("Editado con exito!!");

				idPersona = null;
				nombre = "";
				apellido = "";
				fechaNacimiento = null;
				telefono = "";
				email = "";
				sexo = "";
				ciudad = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));

		}
	}

	public void eliminar() {
		Persona per = personaEJB.buscarPersona(Long.parseLong(idPersona));
		
 		personaEJB.eliminar(per);
 		Messages.addFlashGlobalInfo("eliminado con exito!!");
 	
	}

}
