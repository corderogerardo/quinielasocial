package quinielasocial.lab.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.hibernate.Query;
import org.springframework.util.CollectionUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.dao.EquipoDAO;
import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Equipo;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Jugadortorneo;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Prediccion;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;



public class ControladorPrediccion extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	@WireVariable
	protected CRUDService servicioprediccion = (CRUDService) SpringUtil.getBean("CRUDService");
	private List<Prediccion> predicciones;


	


	   private static Session factory; 

	//wire components 
	   Persona personau;
	   List<Persona> personas;
	   @Wire 
	   Textbox idpar;
	   @Wire
	   Intbox puntajeLoc;
	   @Wire
	   Intbox puntajeVis;
	   @Wire
	   Menuitem guardarPrediccion;
		public ControladorPrediccion(){
			super();
			predicciones = servicioprediccion.getAll(Prediccion.class);

			try{
			//Buscamos y llenamos nuestras listas con la data en nuestras tablas en la base de datos.


			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@Listen("onClick=#guardarPrediccion; onOK=#agregarPrediccion")
		public void addResult(){


			Session session = Sessions.getCurrent();
			Usuario usr = (Usuario) session.getAttribute("usuario");
			personas = servicioprediccion.getAll(Persona.class);
			for(int i = 0; i<personas.size();i++){
				if(usr.getCorreo().equals(personas.get(i).getCorreo())){
					personau = personas.get(i);
				}
			}
				long idpa= (Long.valueOf(texto(idpar)));
				System.out.println(idpa);
				Date date = new Date();
				Prediccion pre = new Prediccion(Long.valueOf(predicciones.size()+1),
						Long.valueOf(texto(idpar)),personau.getCedula(),Long.valueOf(puntajeLoc.getValue()), 
						Long.valueOf(puntajeVis.getValue()), date, true);
				servicioprediccion.Save(pre);
				Executions.sendRedirect(""); 
			
					
		}


		
		public String texto(Textbox text) {
			return text.getValue().toString();
					}


	  
		 
		
		
}
