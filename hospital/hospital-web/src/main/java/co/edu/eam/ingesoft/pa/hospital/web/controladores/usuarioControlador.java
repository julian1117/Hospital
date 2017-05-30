package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.inject.Named;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Persona;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa.negocio.beans.GeneralEJB;

@ViewScoped
@Named("usuarioController")
public class usuarioControlador implements Serializable {

	private String cedula;

	private String nombreUs;

	private String contrasena;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreUs() {
		return nombreUs;
	}

	public void setNombreUs(String nombreUs) {
		this.nombreUs = nombreUs;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@EJB
	private GeneralEJB general;

	public void crearUs() {
		try {
			Persona per = general.buscarPersona(Long.parseLong(cedula));

			if (per != null) {
				Usuario us = new Usuario();
				us.setContrasenia(contrasena);
				us.setNombreUsuario(nombreUs);
				us.setIdPersona(per);

				general.crearUsu(us);
				Messages.addFlashGlobalInfo("Usuario creado con exito");
			} else {
				Messages.addFlashGlobalError("No existe la persona");
			}
		} catch (Exception e) {
			Messages.addFlashGlobalError(e.getMessage());
		}

	}
	
	public String atras(){
		return "/paginas/publico/login.xhtml?faces-redirect=true";

	}

}
