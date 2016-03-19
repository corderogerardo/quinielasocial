package quinielasocial.lab.controller;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.entity.Jugador;
import quinielasocial.lab.entity.*;
import quinielasocial.lab.services.JugadorServicio;
import quinielasocial.lab.services.*;
public class ControladorLogin extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	private JugadorServicio serv = new JugadorServicio();
	private List<Jugador> todosUsuarios;
	//wire components
	@Wire
	Textbox usuario;
	@Wire
	Textbox password;
	@Wire
	Label message;
	
	//services

	
	public ControladorLogin() {
		super();
		try {
			todosUsuarios=serv.getAllJugadores();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Listen("onClick=#login; onOK=#loginWin")
	public void doLogin(){
		String nm = usuario.getValue().toString();
		String pd = password.getValue().toString();
		Session miSession = Sessions.getCurrent();
		Boolean s=false;

		
		for (int i=0;i<todosUsuarios.size();i++){
			if(todosUsuarios.get(i).getCorreo().equals(nm)) {
//				if (todosUsuarios.get(i).getTipo().equals("admin") && todosUsuarios.get(i).getClave().equals(pd)){
//					miSession.setAttribute("usuario", "Administrador");	
//					Executions.sendRedirect("/administradorPagina/indexSesionAdmin.zul");					
//					s=true;
//				}
//				else
//				if (todosUsuarios.get(i).getTipo().equals("player") && todosUsuarios.get(i).getClave().equals(pd)){
//
//					miSession.setAttribute("usuario", nm);					
//					Executions.sendRedirect("/indexSesion.zul");		
//					s=true;
//				}
					
			}
							
		}
		if (s==false){
			 Messagebox.show("Clave o Usuario Incorrecto, por favor verifique.", "Error", Messagebox.OK, Messagebox.ERROR);
		}
//		Executions.sendRedirect("/indexSesion.zul");
		
	}
}
