package quinielasocial.lab.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Usuario;

public class ControladorLogin extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
	
	@WireVariable
	protected CRUDService serviciousuario = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciorol = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Usuario> usuarios;
	private List<Rol> roles;
	private Usuario unusuario;
	
	//wire components
	@Wire
	Textbox txtUsuario;
	@Wire
	Textbox txtPassword;
	@Wire
	Label lblMessage;
	
	//services

	
	@Listen("onClick=#btnLogin; onOK=#loginWin")
	public void doLogin(){
		String usuario = txtUsuario.getValue().toString();
		String contrasenna = txtPassword.getValue().toString();
			if(usuario.equals("usuario@correo.com") && contrasenna.equals("1234")){
				Session miSession = Sessions.getCurrent();
				
				miSession.setAttribute("rolUsuario","Administrador del Sistema");
				miSession.setAttribute("nombreUsuario",txtUsuario.getValue());
				Executions.sendRedirect("/indexSesion.zul");
			}
			else{
				Messagebox.show("Usuario o contrasena incorrecta");
			}
//		if(!authService.login(nm,pd)){
//			message.setValue("usuario o password no son correctos.");
//			return;
//		}
//		CredencialUsuario cre= authService.getCredencialUsuario();
//		message.setValue("Bienvenido, "+cre.getNombre().toString());
//		message.setSclass("");
		
		
		
	}
}
