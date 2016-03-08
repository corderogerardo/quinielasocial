package quinielasocial.lab.controller;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;


public class ControladorModificarPerfil extends SelectorComposer<Component>{
	
	@Wire 
	private Include middle;
	
	@Wire
	private Button nuevo;
		
@Listen("onClick=#guardar,#salir; onOk=#modificarPerfil")
public void exito(){
	Executions.sendRedirect("/indexSesion.zul");
	
}

@Listen("onClick=#guardarAdmin,#salirAdmin")
public void guardarSalir(){
	Executions.sendRedirect("/administradorPagina/indexSesionAdmin.zul");

	
}
}