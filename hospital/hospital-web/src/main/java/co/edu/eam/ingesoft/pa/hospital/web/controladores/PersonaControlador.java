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

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.avanzada.persistencia.enumeraciones.TipoUsuario;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PersonaEJB;

@Named("personaControler")
@ViewScoped
public class PersonaControlador implements Serializable {
	
	private Long idPersona;
	
	private String nombre;
	
	private String apellido;
	
	private Date fechaNacimiento;
	
	private String telefono;
	
	private String direccion;
	
	private TipoUsuario tipoUsu;
	
	private String email;
	
	private String sexo;
	
	private Ciudad ciudad;
	
	private List<Ciudad> nombreCiudad;
	
	private String fechastr;
	

	
		
	@EJB
	private GeneralEJB generalEJB;
	
	@EJB
	private PersonaEJB personaEJB;
	
	@PostConstruct
	public void inicializar(){
	nombreCiudad = generalEJB.listarCiudad();
	}
	
	
	
	
	public String getFechastr() {
		return fechastr;
	}




	public void setFechastr(String fechastr) {
		this.fechastr = fechastr;
	}




	public TipoUsuario[] getTipoUsuarios(){
		return TipoUsuario.values();
	}
	
	public void buscarPersona(){
		
	}

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

	public TipoUsuario getTipoUsu() {
		return tipoUsu;
	}

	public void setTipoUsu(TipoUsuario tipoUsu) {
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
	
	public void crearPersona(){
		Messages.addFlashGlobalInfo("Exito!!");
		 
		 		try {
		 			Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
		 			fechaNacimiento=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
		 			Persona per = new Persona(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion, tipoUsu, email, sexo, ciu);
		 			personaEJB.crearPersona(per);
		 			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");
		 		} catch (Exception e) {
		 			e.printStackTrace();
		 			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,e.getMessage(), null));
		 		}
		 		
		 		idPersona=null;
		 		nombre="";
		 		apellido="";
		 		fechaNacimiento=null;
		 		telefono="";
		 		tipoUsu=null;
		 	email="";
		 		sexo="";
		 		ciudad=null;
		
		
	}
	
	public void buscar(){
		 		Persona persona = personaEJB.buscarPersona(idPersona);
		 		if(persona != null){
		 			nombre=persona.getNombre();
		 			apellido= persona.getApellido();
		 			fechaNacimiento=persona.getFechaNacimiento();
		 			telefono=persona.getTelefono();
		 			direccion=persona.getDireccion();
		 			tipoUsu=persona.getTipoUsuario();
		 			email=persona.getEmail();
		 			sexo=persona.getSexo();
		 			ciudad=null;
		 		}
		 	}
		 	
		 	
		 	public void editar(){
		 		Persona persona = personaEJB.buscarPersona(idPersona);
		 		Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
		 
		 		if(persona != null){
		 			Persona per = new Persona(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion, tipoUsu, email, sexo, ciu);
		 			personaEJB.editar(per);
		 		}
		 	}
		 	
		 	public void eliminar(Persona persona){
		 		personaEJB.eliminar(persona);
		 	}
	
	

}
