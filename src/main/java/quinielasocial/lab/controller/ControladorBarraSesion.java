package quinielasocial.lab.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;

import quinielasocial.lab.domain.entity.Usuario;

public class ControladorBarraSesion extends SelectorComposer<Component> {
@Wire
private Button cerrarSesion;
@Wire
private Button inicio;

public ControladorBarraSesion() {
	super();
	try{

		Session session = Sessions.getCurrent();
		Usuario usr = (Usuario) session.getAttribute("usuario");
		//Messagebox.show("Sesiones "+usr.getCorreo().toString());
		if(usr.getCorreo().isEmpty()){}
		
	}catch(Exception e){
		if(Executions.getCurrent().getDesktop().getRequestPath().equals("/administradorPagina/indexSesionAdmin.zul")){
			Executions.sendRedirect("/index.zul");}
		if(Executions.getCurrent().getDesktop().getRequestPath().equals("/indexSesion.zul")){
			Executions.sendRedirect("/index.zul");}
	}
}
@Listen("onClick=#cerrarSesion; onOk=#barraSesion")
public void cerrarSesion(){
	Executions.sendRedirect("/index.zul");
	Session miSession = Sessions.getCurrent();
	miSession.invalidate();
	
}
@Listen("onClick=#inicio; onOk=#barraSesion")
public void irInicio(){
	Executions.sendRedirect("/indexSesion.zul");
	
}

@Listen("onClick=#inicioAdmin")
public void irInicioAdmin(){
	Executions.sendRedirect("/administradorPagina/indexSesionAdmin.zul");
	
}
@Listen("onClick=#perfil; onOk=#barraSesion")
public void perfil(){
	Executions.sendRedirect("/sesionEditarPerfil.zul");
	
}

}
