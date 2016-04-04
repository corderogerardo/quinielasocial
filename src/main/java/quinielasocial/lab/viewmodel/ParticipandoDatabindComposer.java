package quinielasocial.lab.viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.Predicate;
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
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Equipo;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;
import quinielasocial.lab.business.services.CRUDService;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import quinielasocial.lab.controller.*;
import quinielasocial.lab.domain.entity.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import quinielasocial.lab.domain.entity.Torneo;
import java.util.ArrayList;
import java.util.List;
import org.zkoss.bind.annotation.Init;
	 
	 
public class ParticipandoDatabindComposer {

		private List<Torneo> torneosparticipando;
		private List<Torneo> torneosaux;
		private List<Torneo> part;
		private List<Jugadortorneo> jugtor;
		//public Torneo torneo;
		@WireVariable
		protected CRUDService servicioParticipandoDatabindComposer = (CRUDService) SpringUtil.getBean("CRUDService");
	    private Torneo selected;
		
		public ParticipandoDatabindComposer() {
		super();
		Session session = Sessions.getCurrent();
		Usuario usr = (Usuario) session.getAttribute("usuario");
		jugtor = servicioParticipandoDatabindComposer.getAll(Jugadortorneo.class);
		Jugador jugador = servicioParticipandoDatabindComposer.findByPrimaryKey(Jugador.class, usr.getUsuarioId());
		String cedula = jugador.getCedulajugador();
		//torneos = servicioParticipandoDatabindComposer.getAll(Torneo.class);
	     torneosparticipando=servicioParticipandoDatabindComposer.getAll(Torneo.class);
	     int tamano=torneosparticipando.size();
	     int a=0;
	     while (a<=tamano){
		     for (int i = 0; i < torneosparticipando.size(); i++) {
					if(existe(torneosparticipando.get(i).getTorneoId())==false) torneosparticipando.remove(i);
				}
		     a=a+1;
	     }
	     int tamano1=torneosparticipando.size();
	     a=0;
	     while (a<=tamano1){
		     for (int i = 0; i < torneosparticipando.size(); i++) {
					if(existeParticipando(torneosparticipando.get(i).getTorneoId())==false) torneosparticipando.remove(i);
				}
		     a=a+1;
	     }


	}
		
		@Init
	    public void init() {    // Initialize
	        //if (!torneos.isEmpty())selected = torneos.get(0); // Selected First One
	    }
		
		public boolean existe(long cod){
			for (int i = 0; i < jugtor.size(); i++) {
				if (jugtor.get(i).getIdtorneo()==cod) return true;
			}
			return false;
		}
		
		public boolean existeParticipando(long cod){
			for (int i = 0; i < jugtor.size(); i++) {
				if (jugtor.get(i).getIdtorneo()==cod && jugtor.get(i).getEstado().equals("PARTICIPANDO")) return true;
			}
			return false;
		}
	 
//	    public List<String> getTorneoTitles() {
//	        return titles;
//	    }
//	 
	    public List<Torneo> getTorneoList() {
	        return torneosparticipando;
	    }
	 
	    public void setSelectedTorneo(Torneo selected) {
	        this.selected = selected;
	    }
	 
	    public Torneo getSelectedTorneo() {
	        return selected;
	    }
	}