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
import org.zkoss.zk.ui.util.Composer;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import quinielasocial.lab.domain.entity.Torneo;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.annotation.Init;
		 
		 
	public class PrediccionesDatabindComposer extends SelectorComposer<Component> {
			
			private List<Partido> partidos;
			private List<Partido> partidosaux;
			private List<Partido> partaux2;
			//public Torneo torneo;
			@WireVariable
			protected CRUDService servicioPrediccionesDatabindComposer = (CRUDService) SpringUtil.getBean("CRUDService");
		    private Partido selected;
			public PrediccionesDatabindComposer() {
			super();
			Session session = Sessions.getCurrent();
			Usuario usr = (Usuario) session.getAttribute("usuario");
			Torneo tor = (Torneo) session.getAttribute("torneo");
			Jugador jugador = servicioPrediccionesDatabindComposer.findByPrimaryKey(Jugador.class, usr.getUsuarioId());
			//partidos = servicioPrediccionesDatabindComposer.getAll(Partido.class);
			partidos = servicioPrediccionesDatabindComposer.getPartidosUnTorneo(Partido.class, tor.getTorneoId());
			
			for (int i = 0; i < partidos.size(); i++) {
				long parid= partidos.get(i).getPartidoId();
				long idt= partidos.get(i).getIdtor();
				long idloc = partidos.get(i).getIdequiloc();
				long idvis = partidos.get(i).getIdequvis();
				Date fecha = partidos.get(i).getFecha();
				long idres= partidos.get(i).getIdResultado();
				String esta= partidos.get(i).getEstado();
				String eqLoc, eqVis;
				Equipo  eql= servicioPrediccionesDatabindComposer.findByPrimaryKey(Equipo.class, partidos.get(i).getIdequiloc());
				eqLoc = eql.getNombre();
				Equipo  eqv= servicioPrediccionesDatabindComposer.findByPrimaryKey(Equipo.class, partidos.get(i).getIdequvis());
				eqVis = eqv.getNombre();
				partidos.set(i, new Partido(parid, idt, idloc, idvis,eqLoc+" vs "+eqVis, fecha,idres,esta));
			}


		}
			
			@Init
		    public void init() {    // Initialize
		        if (!partidos.isEmpty())selected = partidos.get(0); // Selected First One
		    }
		
		    public List<Partido> getPartidoList() {
		        return partidos;
		    }
		    public void setSelectedPartidos(Partido selected){
		    	this.selected = selected;
		    }
		    public Partido getSelectedPartidos(){
		    	return selected;
		    }
		 
//		    public void setSelectedPartido(Partido selected) {
//		        this.selected = selected;
//		    }
//		 
//		    public Partido getSelectedPartidos() {
//		        return selected;
//		    }
		}