package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Especializacione;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Roll;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PersonaEJB;

@Named("MedicoControler")
@ViewScoped
public class MedicoControlador implements Serializable {

	@Pattern(regexp = "[0-9]*", message = "El numero de  identificacion solo puede llevar caracteres numericos")
	@Length(min = 4, max = 10, message = "Cedula - longitud entre 5 y 10")
	private String idPersona;
	
    @Pattern(regexp = "[A-Za-z ]*", message = "nomre solo permites caracteres alfabetico")
	@Length(min = 5, max = 50, message = "Nombre - longitud entre 5 y 50")
	private String nombre;
	
	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
	@Length(min=5,max=50,message="Apellido - longitud entre 5 y 50")
	private String apellido;
	
	private Date fechaNacimiento;
	
	@Pattern(regexp="[0-9]*",message="solo numeros")
	@Length(min=7,max=10,message="Telefono - longitud entre 7 y 10")
	private String telefono;
	
	
	private String direccion;
	
	private String tipoUsu;
	
	@Email
	private String email;
	
	private String sexo;
	
	private Ciudad ciudad;
	
	private List<Ciudad> listarCiudad;
	
	private String fechastr;
	
	private Especializacione especializacion;
	
	private List<Especializacione> listarEspecializaciones;
	
	private Roll roles;

	
	
	public Roll getRoles() {
		return roles;
	}

	public void setRoles(Roll roles) {
		this.roles = roles;
	}

	@EJB
	private GeneralEJB generalEJB;
	
	@EJB
	private PersonaEJB personaEJB;
	
	@EJB
	private MedicoEJB medicoEJB;
	
	@PostConstruct
	public void inicializar(){
		listarEspecializaciones = generalEJB.listarEspecializacione();
		listarCiudad = generalEJB.listarCiudad();
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
		return listarCiudad;
	}

	public void setNombreCiudad(List<Ciudad> nombreCiudad) {
		this.listarCiudad = nombreCiudad;
	}

	public String getFechastr() {
		return fechastr;
	}

	public void setFechastr(String fechastr) {
		this.fechastr = fechastr;
	}

	public Especializacione getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(Especializacione especializacion) {
		this.especializacion = especializacion;
	}

	public List<Especializacione> getListarEspecializaciones() {
		return listarEspecializaciones;
	}

	public void setListarEspecializaciones(List<Especializacione> listarEspecializaciones) {
		this.listarEspecializaciones = listarEspecializaciones;
	}

	public GeneralEJB getGeneralEJB() {
		return generalEJB;
	}

	public void setGeneralEJB(GeneralEJB generalEJB) {
		this.generalEJB = generalEJB;
	}
	
	
	
	public List<Ciudad> getListarCiudad() {
		return listarCiudad;
	}

	public void setListarCiudad(List<Ciudad> listarCiudad) {
		this.listarCiudad = listarCiudad;
	}

	public PersonaEJB getPersonaEJB() {
		return personaEJB;
	}

	public void setPersonaEJB(PersonaEJB personaEJB) {
		this.personaEJB = personaEJB;
	}

	public MedicoEJB getMedicoEJB() {
		return medicoEJB;
	}

	public void setMedicoEJB(MedicoEJB medicoEJB) {
		this.medicoEJB = medicoEJB;
	}

	public void crarMedico(){
		try {
			Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
// 			fechaNacimiento=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Especializacione especi = generalEJB.buscarEspecializacione(especializacion.getIdEspecializacion());
			Roll roll = generalEJB.buscarRol(3);
 			
 			Medico medico = new Medico(Long.parseLong(idPersona), nombre, apellido, fechaNacimiento, telefono, direccion, roll, email, sexo, ciu, especi);
 			medicoEJB.crearMedico(medico);
 			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

 			
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}
	
	public void buscar(){
		Medico me = medicoEJB.buscarMedico(Long.parseLong(idPersona));
		if(me != null){
			nombre=me.getNombre();
 			apellido= me.getApellido();
 			fechaNacimiento=me.getFechaNacimiento();
 			telefono=me.getTelefono();
 			direccion=me.getDireccion();
 		//	tipoUsu=me.getTipoUsuario();
 			email=me.getEmail();
 			sexo=me.getSexo();
 			especializacion = me.getEspecializaciones();
 			ciudad=me.getCiudad();
		}else{
			Messages.addFlashGlobalInfo("El medico no se encuentra registardo");

		}
	}
	
	public void editarMedico(){
		try {
			
			Medico medico = medicoEJB.buscarMedico(Long.parseLong(idPersona));
			Ciudad ciud = generalEJB.buscarCiudad(ciudad.getIdCiuad());
//	 		fechaNacimiento=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Especializacione especi = generalEJB.buscarEspecializacione(especializacion.getIdEspecializacion());

			Roll roll = generalEJB.buscarRol(3);

	 		
	 		if(medico!=null){
	 			Medico medi = new Medico(Long.parseLong(idPersona), nombre, apellido, fechaNacimiento, telefono, direccion, roll, email, sexo, ciud, especi);
	 			medicoEJB.editarMedico(medi);
	 			Messages.addFlashGlobalInfo("Editado con exito!!");
	 			
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
			
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}
	}
	
	public void eliminar(){
 		Persona per = personaEJB.buscarPersona(Long.parseLong(idPersona));
 		personaEJB.eliminar(per);
 		Messages.addFlashGlobalInfo("eliminado con exito!!");
 	}
}
