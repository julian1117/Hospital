package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
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

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Ciudad;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Especializacione;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Medico;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.MedicoEJB;
import co.edu.eam.ingesoft.pa.negocio.beans.PersonaEJB;

@Named("MedicoControler")
@ViewScoped
public class MedicoControlador implements Serializable {

//	@Pattern(regexp="[0-9]*",message="solo numeros")
//	@Length(min=4,max=10,message="longitud entre 5 y 10")
	private Long idPersona;
	
//	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
//	@Length(min=4,max=10,message="longitud entre 5 y 50")
	private String nombre;
	
//	@Pattern(regexp="[A-Za-z ]*",message="solo Letras")
//	@Length(min=4,max=10,message="longitud entre 5 y 50")
	private String apellido;
	
	private Date fechaNacimiento;
	
//	@Pattern(regexp="[0-9]*",message="solo numeros")
//	@Length(min=10,max=10,message="longitud entre 10 y 15")
	private String telefono;
	
	
	private String direccion;
	
	private String tipoUsu;
	
	private String email;
	
	private String sexo;
	
	private Ciudad ciudad;
	
	private List<Ciudad> listarCiudad;
	
	private String fechastr;
	
	private Especializacione especializacion;
	
	private List<Especializacione> listarEspecializaciones;
	
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
	
	public void crarMedico(){
		try {
			Ciudad ciu = generalEJB.buscarCiudad(ciudad.getIdCiuad());
 			fechaNacimiento=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
			Especializacione especi = generalEJB.buscarEspecializacione(especializacion.getIdEspecializacion());
 			
// 			Medico medico = new Medico(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion, "Medico", email, sexo, ciu, especi);
// 			medicoEJB.crearMedico(medico);
 			
 			Messages.addFlashGlobalInfo("Registro Creado Con Exito!!");

 			
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());

		}
	}
	
	public void buscar(){
		Medico me = medicoEJB.buscarMedico(idPersona);
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
		}
	}
	
	public void editarMedico(){
		try {
			
			Medico medico = medicoEJB.buscarMedico(idPersona);
			Ciudad ciud = generalEJB.buscarCiudad(ciudad.getIdCiuad());
	 		fechaNacimiento=new SimpleDateFormat("dd-MM-yyyy").parse(fechastr);
	 		
	 		if(medico!=null){
//	 			Medico medi = new Medico(idPersona, nombre, apellido, fechaNacimiento, telefono, direccion, "Medico", email, sexo, ciud, especializacion);
//	 			medicoEJB.editarMedico(medi);
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
 		Persona per = personaEJB.buscarPersona(idPersona);
 		personaEJB.eliminar(per);
 		Messages.addFlashGlobalInfo("eliminado con exito!!");
 	}
}
