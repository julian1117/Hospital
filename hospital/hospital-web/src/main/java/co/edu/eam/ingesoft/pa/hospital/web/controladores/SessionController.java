package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Acceso;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Roll;
import co.edu.eam.ingesoft.avanzada.persistencia.entidades.Usuario;
import co.edu.eam.ingesoft.pa.negocio.beans.SeguridadEJB;

@Named("sessionController")
@SessionScoped
public class SessionController implements Serializable {

	private String usuario;
	private String contrasena;

	private List<Acceso> accesos;

	private List<Roll> roles;

	private Usuario use;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Usuario getUse() {
		return use;
	}

	public void setUse(Usuario use) {
		this.use = use;
	}

	public List<Acceso> getAccesos() {
		return accesos;
	}

	public void setAccesos(List<Acceso> accesos) {
		this.accesos = accesos;
	}

	public List<Roll> getRoles() {
		return roles;
	}

	public void setRoles(List<Roll> roles) {
		this.roles = roles;
	}

	@EJB
	private SeguridadEJB seguridadEjb;

	/**
	 * Login de usuario
	 */
	public String login() {

		Usuario useBuscar = seguridadEjb.buscar(usuario);

		if (useBuscar != null) {

			if (useBuscar.getContrasenia().equals(contrasena)) {
				use = useBuscar;
				if (use.getIdPersona().getRoll().getId() == 1) {
					Faces.setSessionAttribute("usuario", use);
					Messages.addGlobalInfo("Usuario existe");

					roles = seguridadEjb.listaRoles(useBuscar.getIdPersona().getRoll().getId());
					accesos = seguridadEjb.listaAcc(useBuscar.getIdPersona().getRoll().getId());

					return "/paginas/seguro/Adm/Citas.xhtml?faces-redirect=true";
					
				} else if (use.getIdPersona().getRoll().getId() == 2) {
					Faces.setSessionAttribute("usuario", use);
					Messages.addGlobalInfo("Usuario existe");

					roles = seguridadEjb.listaRoles(useBuscar.getIdPersona().getRoll().getId());
					accesos = seguridadEjb.listaAcc(useBuscar.getIdPersona().getRoll().getId());

					return "/paginas/seguro/paciente/#.xhtml?faces-redirect=true";
				}else if (use.getIdPersona().getRoll().getId() == 3) {
					Faces.setSessionAttribute("usuario", use);
					Messages.addGlobalInfo("Usuario existe");

					roles = seguridadEjb.listaRoles(useBuscar.getIdPersona().getRoll().getId());
					accesos = seguridadEjb.listaAcc(useBuscar.getIdPersona().getRoll().getId());

					return "/paginas/seguro/Medico/AgendaMedico.xhtml?faces-redirect=true";
				}else if (use.getIdPersona().getRoll().getId() == 4) {
					Faces.setSessionAttribute("usuario", use);
					Messages.addGlobalInfo("Usuario existe");

					roles = seguridadEjb.listaRoles(useBuscar.getIdPersona().getRoll().getId());
					accesos = seguridadEjb.listaAcc(useBuscar.getIdPersona().getRoll().getId());

					return "/paginas/seguro/Farmaceuta/#.xhtml?faces-redirect=true";
				}
			} else {
				Messages.addGlobalError("contrasena incorrecta");
			}

		} else {
			Messages.addGlobalError("Usuario o contrasena incorrecta");
		}
		return null;

	}

	/**
	 * Cerrar session
	 * 
	 * @return
	 */
	public String cerrarSession() {
		usuario = null;
		HttpSession sesion;
		sesion = (HttpSession) Faces.getSession();
		sesion.invalidate();
		return "/paginas/publico/login.xhtml?faces-redirect=true";

	}

	public boolean isSesion() {
		return use != null;
	}

}
