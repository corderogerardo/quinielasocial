
package quinielasocial.lab.controller;


import servicio.ServicioAutenticacion;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.ClickEvent;

public class ControladorLogout extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
	//services
	ServicioAutenticacion authService = new ImplementacionAutenticacionServicios();
	
	@Listen("onClick=#lblCerrarSesion")
	public void cerrarSesion(){
		EventListener<ClickEvent> clickListener = new EventListener<Messagebox.ClickEvent>(){
			public void onEvent(ClickEvent event) throws Exception{
				if(Messagebox.Button.YES.equals(event.getButton())){
					Session miSession = Sessions.getCurrent();
					miSession.invalidate();
					Executions.sendRedirect("index.zul");
				}
			}
		};
		Messagebox.show("Realmente desea cerrar sesion? ","Mensaje de Confirmacion", new Messagebox.Button[]{
				Messagebox.Button.YES,Messagebox.Button.NO},Messagebox.QUESTION,clickListener);
		
	}
}
