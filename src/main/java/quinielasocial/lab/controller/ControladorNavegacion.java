package quinielasocial.lab.controller;

import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkmax.zul.Nav;
import org.zkoss.zkmax.zul.Navitem;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

public class ControladorNavegacion extends GenericForwardComposer<Component> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Div contenidos;
	private Window contenedor;
	private String pagina;
	
	
	public void onClick$btnPerfil(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/actualizarDatosUsuario.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	public void onClick$btnNuevo(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/registrarTorneo.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	public void onClick$btnCreadas(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/misQuinielas.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	public void onClick$btnParticipando(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/listaQuinielas.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	public void onClick$btnUnirse(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/listaQuinielas.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	public void onClick$btnMensajes(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/mensajes.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	public void onClick$btnInvitaciones(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/solicitudes.zul";
		contenidos.getChildren().clear();
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	@Command
	public void guardartorneopartido(){
		System.out.println("Entro al metodo");
		pagina = "./componentes/agregarEquipos.zul";
		
		contenedor = (Window) Executions.createComponents(pagina, null, null);
		contenidos.appendChild(contenedor);
	}
	

}
