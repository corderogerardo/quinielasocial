package quinielasocial.lab.controller;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;
import org.zkoss.zul.Messagebox;

import quinielasocial.lab.domain.entity.Usuario;


public class ControladorIndexSesion extends SelectorComposer<Component>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ControladorIndexSesion() {
		super();
		Session session = Sessions.getCurrent();
		String usr = (String) session.getAttribute("correo");
		Messagebox.show("Sesiones "+usr);
			try{
				if(usr.equals(null)){
			
				}
			}catch(Exception e){
				if(Executions.getCurrent().getDesktop().getRequestPath().equals("/administradorPagina/indexSesionAdmin.zul")){
					Executions.sendRedirect("/index.zul");}
				if(Executions.getCurrent().getDesktop().getRequestPath().equals("/indexSesion.zul")){
					Executions.sendRedirect("/index.zul");}
			}
		
	}

	@Wire 
	private Include middle;
	
	@Wire
	private Button nuevo;
		
@Listen("onClick=#nuevo; onOk=#indexSesion")
public void ggg(){
	middle.setSrc("registrarTorneo.zul");
	
}
}
