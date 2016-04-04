package quinielasocial.lab.controller;

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
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;



public class ControladorTorneo extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	@WireVariable
	protected CRUDService serviciotorneo = (CRUDService) SpringUtil.getBean("CRUDService");
	EquipoDAO equipoDAO;	
	private List<Torneo> torneos;
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	private List<Rol> roles;
	private Usuario unusuario;
	private List<Equipo> equipos;
	private Torneo selected;
	private List<Equipo> equiposid;
	private List<Torneo> quinielas;
	private List<Jugadortorneo> jugt;
	private List<Jugadortorneo> filter;
	private List<Persona> personas;
	


	   private static Session factory; 

	//wire components registrar
	@Wire
	Textbox txtnombreTor;
	@Wire
	Datebox dtfecIni;
	@Wire
	Datebox dtfecFin;
	@Wire
	Textbox puntoGanado;
	@Wire
	Textbox puntoMarcadorLocal;
	@Wire
	Textbox puntoMarcadorVisitante;
	@Wire
	Button btnguardarTorneo;
	@Wire
	Textbox topePrediccion;
	@Wire
	Button urlfoto;
	@Wire
	Textbox txtDesc;
	@Wire
	Label message;
	@Wire
	Button btnlimpiar;
	@Wire
	Button btnguardarEquipo;
	@Wire
	Textbox nombreEquipo;
	@Wire
	Textbox descripcionEquipo;
	@Wire
	Textbox idtor;
	@Wire
	Textbox nombreTor;
	@Wire
	Textbox desTor;
	@Wire
	Textbox estadoTor;
	@Wire
	Menuitem agregarResultado;
	@Wire
	Menuitem agregarPartido;
	@Wire
	Menuitem agregarEquipos;
	@Wire
	Menuitem listadoDeJugadores;
	Persona personau;

		public ControladorTorneo(){
			super();
			torneos = serviciotorneo.getAll(Torneo.class);

			try{
			//Buscamos y llenamos nuestras listas con la data en nuestras tablas en la base de datos.


			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		//VISTA REGISTRO TORNEO
		@Listen("onClick=#btnguardarTorneo; onOK=#registrarTorneoWin")
		public void saved(){
			//Registrar
			Session session = Sessions.getCurrent();
			Usuario usr = (Usuario) session.getAttribute("usuario");
			personas = serviciotorneo.getAll(Persona.class);
			for(int i = 0; i<personas.size();i++){
				if(usr.getCorreo().equals(personas.get(i).getCorreo())){
					personau = personas.get(i);
				}
			}		
				Torneo newone = new Torneo(Long.valueOf(torneos.size()+1), 
						personau.getCedula().toString(), texto(txtnombreTor), 
						texto(txtDesc), dtfecIni.getValue(), dtfecFin.getValue(), 
						Long.valueOf(texto(topePrediccion)), "false", Long.valueOf(texto(puntoGanado)),
						Long.valueOf(texto(puntoMarcadorLocal)), Long.valueOf(texto(puntoMarcadorVisitante)), true);
				Long id=Long.valueOf(torneos.size()+1);
				serviciotorneo.Save(newone);
				session.setAttribute("torneo", new Torneo(Long.valueOf(torneos.size()+1), personau.getCedula().toString(), texto(txtnombreTor), texto(txtDesc), dtfecIni.getValue(), dtfecFin.getValue(), Long.valueOf(texto(topePrediccion)), "false", Long.valueOf(texto(puntoGanado)), Long.valueOf(texto(puntoMarcadorLocal)), Long.valueOf(texto(puntoMarcadorVisitante)), true));
				equipos = serviciotorneo.getEquiposUnTorneo(Equipo.class,id);
				
				Executions.sendRedirect("sesionAgregarEquipos.zul");
			
		}
		
		
		
		
		
		
		//VISTA MIS QUINIELAS
		@Listen("onClick=#agregarResultado; onOK=#misQuinielas")
		public void addResult(){
			if (estadoTor.getValue().equalsIgnoreCase("false")) Messagebox.show("Ya este torneo finalizo no se pueden agregar mas resultados pues no quedan mas encuentros", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			else {

				Session session = Sessions.getCurrent();
				Torneo newone = serviciotorneo.findByPrimaryKey(Torneo.class, Long.valueOf(texto(idtor)));
				session.setAttribute("torneo", newone);
				Executions.sendRedirect("sesionAgregarEquipos.zul"); ///OOOJOOOO
				//OJOOOOOOO ARRIBA
			}
					
		}
		
		@Listen("onClick=#agregarPartido; onOK=#misQuinielas")
		public void addPartidos(){
			if (estadoTor.getValue().equalsIgnoreCase("false")) Messagebox.show("Ya este torneo finalizo no se pueden agregar mas partidos", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			else {

				Session session = Sessions.getCurrent();			
				Torneo newone = serviciotorneo.findByPrimaryKey(Torneo.class, Long.valueOf(texto(idtor)));
				session.setAttribute("torneo", newone);
				Executions.sendRedirect("sesionAgregarPartidos.zul");
			}
					
		}
		
		@Listen("onClick=#agregarEquipos; onOK=#misQuinielas")
		public void addTeams(){
			if (estadoTor.getValue().equalsIgnoreCase("false")) Messagebox.show("Ya este torneo finalizo no se pueden agregar mas equipos pues no quedan mas encuentros", "Informacion", Messagebox.OK, Messagebox.INFORMATION);
			else {

				Session session = Sessions.getCurrent();		
				Torneo newone = serviciotorneo.findByPrimaryKey(Torneo.class, Long.valueOf(texto(idtor)));
				session.setAttribute("torneo", newone);
				Executions.sendRedirect("sesionAgregarEquipos.zul");
			}
					
		}
		
		
		public String texto(Textbox text) {
			return text.getValue().toString();
					}
		@Listen("onClick=#btnlimpiar; onOk=#registrarTorneoWin")
		public void limpiarcampos(){
			Executions.sendRedirect("sesionRegistrarTorneo.zul");
			txtnombreTor.setFocus(true);
		}
			

		////Para la vista unirse a quinielas
		//METODOS PARA LA VISTA////
		  public List<Torneo> getTorneoList() {     
				quinielas = serviciotorneo.getAll(Torneo.class);
				Session session = Sessions.getCurrent();
				Usuario usr = (Usuario) session.getAttribute("usuario");
				personas = serviciotorneo.getAll(Persona.class);
				for(int i = 0; i<personas.size();i++){
					if(usr.getCorreo().equals(personas.get(i).getCorreo())){
						personau = personas.get(i);
					}
				}	

				filter = serviciotorneo.getJugadorTorneobyCedulaJugador(Jugadortorneo.class, personau.getCedula());
			  //nombreEquipo.setFocus(true);
				for (int i = 0; i < filter.size(); i++) {
					for (int j = 0; j < quinielas.size(); j++) {
						if (filter.get(i).getIdtorneo() ==quinielas.get(j).getTorneoId())quinielas.remove(j) ;
					}
				}
				
		        return quinielas;      				
		    }
		    public void setSelectedTorneo(Torneo selected) {
		        this.selected = selected;
		        jugt= serviciotorneo.getAll(Jugadortorneo.class);
		        int id= jugt.size()+1;
				Session session = Sessions.getCurrent();
				Usuario usr = (Usuario) session.getAttribute("usuario");
				personas = serviciotorneo.getAll(Persona.class);
				for(int i = 0; i<personas.size();i++){
					if(usr.getCorreo().equals(personas.get(i).getCorreo())){
						personau = personas.get(i);
					}
				}	
		        Jugadortorneo jt=new Jugadortorneo(Long.valueOf(id), selected.getTorneoId(),personau.getCedula(), Long.valueOf(0), "PENDIENTE");
		       serviciotorneo.Save(jt);
				Messagebox.show("Solicitud enviada", "Informacion", Messagebox.OK, Messagebox.INFORMATION);

				Executions.getCurrent().sendRedirect("");

 
		        
		    }
		 
		    public Torneo getSelectedTorneo() {
		        return selected;
		    }
		  
		///////////////////////
	  
		 
		
		
}
