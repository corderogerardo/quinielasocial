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
	 
	 
	public class MisQuinielasDatabindComposer {
		@WireVariable
		protected CRUDService servicioMisQuinielasDatabindComposer = (CRUDService) SpringUtil.getBean("CRUDService");
	    private Torneo selected;
	   // private List<String> titles = new ArrayList<String>(new ContributorData().getTitles());
		Session session = Sessions.getCurrent();
		Usuario usr = (Usuario) session.getAttribute("usuario");
		Jugador jugador = servicioMisQuinielasDatabindComposer.findByPrimaryKey(Jugador.class, usr.getUsuarioId());
		String cedula = jugador.getCedulajugador();
		private List<Torneo> torneos = servicioMisQuinielasDatabindComposer.getUnTorneobyIdAdmin(Torneo.class, cedula);
	    @Init
	    public void init() {    // Initialize
	        if (!torneos.isEmpty())selected = torneos.get(0); // Selected First One
	    }
	 
//	    public List<String> getTorneoTitles() {
//	        return titles;
//	    }
//	 
	    public List<Torneo> getTorneoList() {
	        return torneos;
	    }
	 
	    public void setSelectedTorneo(Torneo selected) {
	        this.selected = selected;
	    }
	 
	    public Torneo getSelectedTorneo() {
	        return selected;
	    }
	}