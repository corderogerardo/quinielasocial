package quinielasocial.lab.viewmodel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.*;
import org.zkoss.zk.ui.event.*;
import org.zkoss.zk.ui.util.*;
import org.zkoss.zk.ui.ext.*;
import org.zkoss.zk.au.*;
import org.zkoss.zk.au.out.*;
import org.zkoss.zul.*;

import java.util.*;

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
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Equipo;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Partido;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Resultado;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;



public class PartidosVM extends GenericForwardComposer {
	private static final long serialVersionUID = 1L;
	@WireVariable
	protected CRUDService servicioEquiposModeloVista = (CRUDService) SpringUtil.getBean("CRUDService");
	private Grid partidosGrid;

	  
	  
	private List<Partido> partidostorneo;
	private List<Equipo> consultaid;
	private static Session factory; 

	
	public PartidosVM(){
		super();

	} 
	   
	
	
	  public void doAfterCompose(Component comp) throws Exception {
		    super.doAfterCompose(comp);
			Torneo tor = (Torneo) session.getAttribute("torneo");
			partidostorneo = servicioEquiposModeloVista.getPartidosUnTorneo(Partido.class, tor.getTorneoId());
		    partidosGrid.setModel(new ListModelList(getData()));

		  }
	  
	   
	   private List<String[]> getData(){
			Session session = Sessions.getCurrent();
			Torneo tor = (Torneo) session.getAttribute("torneo");
			partidostorneo = servicioEquiposModeloVista.getPartidosUnTorneo(Partido.class, tor.getTorneoId());
		    ArrayList<String[]> list= new ArrayList<String[]>();
		    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		    
		    Long id;
		    if(!partidostorneo.isEmpty()){
		    for (int i = 0; i < partidostorneo.size(); i++) {
		           String fecha = df.format(partidostorneo.get(i).getFecha());
			    Equipo eqloc = servicioEquiposModeloVista.findByPrimaryKey(Equipo.class,partidostorneo.get(i).getIdequiloc());
			    Equipo eqvis = servicioEquiposModeloVista.findByPrimaryKey(Equipo.class,partidostorneo.get(i).getIdequvis());
			    list.add(new String[]{eqloc.getNombre(),eqvis.getNombre(), partidostorneo.get(i).getLugar(), fecha});
				}
		    }
		    return list;
		 }
	   
	

		
}
