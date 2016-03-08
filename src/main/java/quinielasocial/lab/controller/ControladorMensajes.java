package quinielasocial.lab.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;
public class ControladorMensajes extends SelectorComposer<Component> {
	@Wire
	public Button leer;
	@Wire
	public Button enviar;
	@Wire
	public Window leerMensaje;
	@Wire
	public Button cerrar;
	
	@Listen("onClick = #leer,#leer1;#leer2;#leer3;#leer4; onOk=mensajes" )
    public void showModal(Event e) {
        //create a window programmatically and use it as a modal dialog.
        Window window = (Window)Executions.createComponents("/componentes/leerMensaje.zul", null, null);
        window.doModal();
    }
	
	@Listen("onClick = #enviar; onOk=leerMensaje" )
    public void salir(Event e) {
        //create a window programmatically and use it as a modal dialog.
		leerMensaje.setVisible(false);
    }
	
	@Listen("onClick = #cerrar; onOk=leerMensaje" )
    public void cerrar(Event e) {

		    leerMensaje.detach() ;
    }

}
