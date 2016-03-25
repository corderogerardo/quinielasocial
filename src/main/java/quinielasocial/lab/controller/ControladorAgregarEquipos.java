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
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.impl.Attribute;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Messagebox.ClickEvent;
import org.zkoss.zk.ui.event.EventListener;

	public class ControladorAgregarEquipos extends SelectorComposer<Component>{
		private static final long serialVersionUID = 1L;

		@Listen("onClick=#saveTimesheetDetails; onOK=#registrarTorneoWin")
		public void guardar(){	
			 EventListener<ClickEvent> clickListener = new EventListener<Messagebox.ClickEvent>() {
		            public void onEvent(ClickEvent event) throws Exception {
		                if(Messagebox.Button.YES.equals(event.getButton())) {
		            			Executions.sendRedirect("sesionAgregarPartidos.zul");
		            	/**		 String template = "agregarEquipos.zul";
		            	            Window window = (Window)Executions.createComponents(template, null, null);
		            	            window.doModal(); **/
		                }
		            }
		        };
		        Messagebox.show("Desea Agregar Los Equipos Participantes al Torneo?", "Confirmacion", new Messagebox.Button[]{
		                Messagebox.Button.YES, Messagebox.Button.NO },Messagebox.QUESTION,clickListener);        
		} 		
	}		
		
		
	

		
		
