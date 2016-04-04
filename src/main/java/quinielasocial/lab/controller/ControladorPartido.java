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
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Label;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.dao.EquipoDAO;
import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Equipo;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Partido;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Resultado;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;



public class ControladorPartido extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	@WireVariable
	protected CRUDService serviciopartido = (CRUDService) SpringUtil.getBean("CRUDService");
	EquipoDAO equipoDAO;	

	private List<Equipo> equipos;
	private List<Partido> todospartidos;
	private List<Partido> partidostorneo;
	private List<Equipo> consultaid;
	private List<Resultado> resultados;
	private String eqParTor="";
	   private static Session factory; 

	@Wire
	Button btnAgregarPartido;
	@Wire
	Combobox cmbLocal;
	@Wire
	Combobox cmbVisitante;
	@Wire
	Textbox lugar;
	@Wire
	Datebox fecha;
	@Wire
	Button btnFinguardarPartidos;
	

		public ControladorPartido(){
			super();
			Session session = Sessions.getCurrent();
			Torneo tor = (Torneo) session.getAttribute("torneo");
			resultados = serviciopartido.getAll(Resultado.class);
			todospartidos = serviciopartido.getAll(Partido.class);
			equipos = serviciopartido.getEquiposUnTorneo(Equipo.class,tor.getTorneoId());
			partidostorneo = serviciopartido.getPartidosUnTorneo(Partido.class, tor.getTorneoId());
			
				if (!equipos.isEmpty()){
					eqParTor = equipos.get(0).getNombre();
					for (int i = 1; i < equipos.size(); i++) {			
					eqParTor = eqParTor+","+equipos.get(i).getNombre();
				}
				}
		}
		
		
		@Listen("onClick=#btnAgregarPartido; onOk=#agregarPartido")
		public void guardarEquipo(){
			Long local,visitante, resultado;
			resultado = Long.valueOf(resultados.size()+1);
			Session session = Sessions.getCurrent();
			Torneo tor = (Torneo) session.getAttribute("torneo");
			consultaid=serviciopartido.getEquiposbyNombreyTorneo(Equipo.class, textoCombo(cmbLocal), tor.getTorneoId());
			local=consultaid.get(0).getEquipoId();
			consultaid=serviciopartido.getEquiposbyNombreyTorneo(Equipo.class, textoCombo(cmbVisitante), tor.getTorneoId());
			visitante = consultaid.get(0).getEquipoId();
			
			Partido par = new Partido(Long.valueOf(todospartidos.size()+1), tor.getTorneoId(), local, 
					visitante, texto(lugar), fecha.getValue(),resultado, "ACTIVO");
			Resultado res = new Resultado(resultado, Long.valueOf(0), Long.valueOf(0), "NO ASIGNADO");
			serviciopartido.Save(res);
			serviciopartido.Save(par);
			//	Equipo newteam = new Equipo(Long.valueOf(equipos.size()+1), texto(nombreEquipo), texto(descripcionEquipo), "false", tor.getTorneoId());
	//		servicioequipo.Save(newteam);
			Executions.getCurrent().sendRedirect("");
		}	
		
		
		@Listen("onClick=#btnFinguardarPartidos; onOk=#agregarPartido")
		public void salir(){
			Executions.sendRedirect("/indexSesion.zul");	
		}	
		
		
		public String texto(Textbox text) {
			return text.getValue().toString();
					}
		
		public String textoCombo(Combobox cmb){
			return cmb.getValue();
		}
		///PARTE PARA LLENAR LA VISTA 
		
		//LOS COMBOS
		  public void seteqParTor(String eqParTor){
			    this.eqParTor = eqParTor;
			  }
			  
			  public String geteqParTor(){
			   return this.eqParTor;
			  }
		///La tabla de Partidos se llena con el viewModel porque incluye consultas de otras tablas
		// ir a quinielasocial.lab.Modelo.Vista. y buscar la que se relaciones con partido son 2	  
		
}
