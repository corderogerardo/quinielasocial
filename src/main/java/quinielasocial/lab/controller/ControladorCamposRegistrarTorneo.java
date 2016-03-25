package quinielasocial.lab.controller;
import java.util.Date;

import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.impl.Attribute;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Messagebox.ClickEvent;
import org.zkoss.zk.ui.event.EventListener;

public class ControladorCamposRegistrarTorneo extends GenericForwardComposer<Window>{
	private ControladorIndex menu = new ControladorIndex();

	
	private static final long serialVersionUID = 1L;
	
	@Wire
	private Textbox txtnombreTor;
	@Wire
	private Datebox dtfecIni;
	@Wire
	private Datebox dtfecFin;
	

	
	public void onClick$btnlimpiar() {
		txtnombreTor.setText("");
		dtfecIni.setText(null);
		dtfecFin.setText(null);	

	}
	
		
	
	public void onClick$btnguardarTorneo() {
		menu.RegistroTorneoExitoso();

			}


	
	
	
	
	
	
	
	
	
	
	
	}
		
		
		

	

