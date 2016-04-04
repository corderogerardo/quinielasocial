package quinielasocial.lab.controller;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.hibernate.Query;
import org.springframework.util.CollectionUtils;
import org.zkoss.bind.annotation.BindingParam;
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
import quinielasocial.lab.domain.entity.Prediccion;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;



public class ControladorTorneoJugador extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	@WireVariable
	protected CRUDService servicioTorneoJugador = (CRUDService) SpringUtil.getBean("CRUDService");
	EquipoDAO equipoDAO;	
	private List<Jugadortorneo> solicitudes;
	private List<Jugadortorneo> actualizar;

	public Persona player;
	public Torneo torneo;
	public Persona personau;
	public List<Persona> personas;
	private static Session factory; 
	@Wire
	Button invitaciones;
	@Wire 
	Menuitem agregarPred;
	@Wire
	Textbox idtor;
	
	//wire components registrar


		public ControladorTorneoJugador(){
			super();
			solicitudes = servicioTorneoJugador.getSolicitudesPendientes(Jugadortorneo.class, "PENDIENTE");
			
			
			//Metodo para Limpiar la tabla
			Session session = Sessions.getCurrent();
			Usuario usr = (Usuario) session.getAttribute("usuario");
			personas = servicioTorneoJugador.getAll(Persona.class);
			for(int i = 0; i<personas.size();i++){
				if(usr.getCorreo().equals(personas.get(i).getCorreo())){
					personau = personas.get(i);
				}
			}	
			int tam =solicitudes.size();
			for (int k = 0; k < tam; k++) {
			for (int i = 0; i < solicitudes.size(); i++) {
				//Persona persona=servicioTorneoJugador.findByPrimaryKey(Persona.class, jugador.getCedulajugador());	// agarrar el nombre
				torneo = servicioTorneoJugador.findByPrimaryKey(Torneo.class, solicitudes.get(i).getIdtorneo());
				if (!torneo.getCedula_administrador().equals(personau.getCedula()))
				{
					String remover = solicitudes.get(i).getCedula();
					for (int j = 0; j < solicitudes.size(); j++) {
						if (remover==solicitudes.get(j).getCedula()) solicitudes.remove(j);
					}
				}
			
			}
			}
			
			//Construir String  el jugador nombre apellido ha solicitado unirse a la quiniela nombre de la quiniela
			for (int i = 0; i < solicitudes.size(); i++) {
				long idsol = solicitudes.get(i).getJugadortorneoId();
				long idtor= solicitudes.get(i).getIdtorneo();
				String ced =solicitudes.get(i).getCedula();
				Persona person = servicioTorneoJugador.findByPrimaryKey(Persona.class, ced);
				torneo = servicioTorneoJugador.findByPrimaryKey(Torneo.class, solicitudes.get(i).getIdtorneo());
				String nombrTor = torneo.getNombre();
				//solicitudes.get(i).setCedula(person.getNombre());
				solicitudes.set(i, new Jugadortorneo(idsol, idtor, person.getNombre()+" "+person.getApellido()+" ha solicitado unirse a la quiniela "+torneo.getNombre(), 0, "PENDIENTE"));
			}
			
			try{}catch(Exception e){e.printStackTrace();}
		}
		
			public List<Jugadortorneo> getsolicitudes(){
		        return solicitudes;
		    }

			 @Listen("onCreate=#invitaciones; onOk=barraTareas1")
			    public void cambiarcolor() {
					if(!solicitudes.isEmpty())invitaciones.setSclass("btn btn-sm button-0 parpadea");
			    }
			
			
			
			@Command
		    @NotifyChange("solicitudes")
		    public void aceptarSolicitud(@BindingParam("solicitud") Jugadortorneo solicitudActual) {
				actualizar = servicioTorneoJugador.getAll(Jugadortorneo.class);
				System.out.println(actualizar.get((int)solicitudActual.getJugadortorneoId()-1).getCedula());
				servicioTorneoJugador.Update(Jugadortorneo.class, solicitudActual.getJugadortorneoId(), "PARTICIPANDO");
				Executions.getCurrent().sendRedirect("");
			}
			@Command
		    @NotifyChange("solicitudes")
		    public void removeSolicitud(@BindingParam("solicitud") Jugadortorneo solicitudActual) {
				actualizar = servicioTorneoJugador.getAll(Jugadortorneo.class);
				System.out.println(actualizar.get((int)solicitudActual.getJugadortorneoId()-1).getCedula());
				servicioTorneoJugador.Update(Jugadortorneo.class, solicitudActual.getJugadortorneoId(), "NEGADO");
				Executions.getCurrent().sendRedirect("");
			}
	  

			@Listen("onClick=#agregarPred; onOK=#quinielasParticipas")
			public void addResult(){
					Session session = Sessions.getCurrent();
					Torneo newone = servicioTorneoJugador.findByPrimaryKey(Torneo.class, Long.valueOf(texto(idtor)));
					session.setAttribute("torneo", newone);
					Executions.sendRedirect("sesionAgregarPrediccion.zul"); 
				
						
			}
			public String texto(Textbox text) {
				return text.getValue().toString();
						}
		
}
