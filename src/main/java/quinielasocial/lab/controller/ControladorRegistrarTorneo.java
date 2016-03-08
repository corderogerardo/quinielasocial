package quinielasocial.lab.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import quinielasocial.lab.controller.*;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

public class ControladorRegistrarTorneo extends SelectorComposer<Component>{

	private static final long serialVersionUID = 1L;
	private ControladorIndex menu = new ControladorIndex();

	//wire components
	@Wire
	Textbox txtnombreTor;
	@Wire
	Date dtfecIni;
	@Wire
	Date dtfecFin;
	
	@Listen("onClick=#btnguardarTorneo; onOK=#registrarTorneoWin")
	public void agregarEquipos() throws InterruptedException{
		Executions.sendRedirect("sesionAgregarEquipos.zul");

	}
	
	/***
	 
		if(txtnombreTor.getText()=="") 	{Messagebox.show("El campo Nombre no puede estar vac�o"); txtnombreTor.setFocus(true);} 
		else {
		 EventListener<ClickEvent> clickListener = new EventListener<Messagebox.ClickEvent>() {
	            public void onEvent(ClickEvent event) throws Exception {
	                if(Messagebox.Button.YES.equals(event.getButton())) { **/
	                	/**		Session miSession = Sessions.getCurrent();
	            			miSession.invalidate();**/
	            		//	Executions.sendRedirect("agregarEquipos.zul");
	         /**   			 String template = "agregarEquipos.zul";
	            	            Window window = (Window)Executions.createComponents(template, null, null);
	            	            window.doModal(); 
	                }
	            }
	        };
	        Messagebox.show("Desea Agregar Los Equipos Participantes al Torneo?", "Confirmacion", new Messagebox.Button[]{
	                Messagebox.Button.YES, Messagebox.Button.NO },Messagebox.QUESTION,clickListener);        
	}  
	
	**/
	

}
