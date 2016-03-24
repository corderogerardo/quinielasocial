package quinielasocial.lab.controller;
import controlador.ControladorCamposRegistrarTorneo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Div;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.MouseEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;


public class ControladorIndex extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;

	//wire components

	@Wire
	private Window registrarTorneo;
	@Wire
	private Window agregarPartidos;
	@Wire
	private org.zkoss.zul.Button visible;
	
	
	
	void RegistroTorneoExitoso()
	{
		registrarTorneo.setVisible(false);
		agregarPartidos.setVisible(true);
		
	}


}