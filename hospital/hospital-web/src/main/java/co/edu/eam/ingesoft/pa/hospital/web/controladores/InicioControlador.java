package co.edu.eam.ingesoft.pa.hospital.web.controladores;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.text.DefaultEditorKit.CutAction;

import org.omnifaces.cdi.ViewScoped;


@Named("inicioController")
@ViewScoped
public class InicioControlador implements Serializable{
	
	
	
	
	
	@Inject
	private SessionController sesionUs;
	
	

	@PostConstruct
	public void inicializar(){
		
	}

}
