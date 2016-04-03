package quinielasocial.lab.viewmodel;

import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Div;
import org.zkoss.zul.Window;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.controller.ControladorNavegacion;
import quinielasocial.lab.controller.ControladorServicios;
import quinielasocial.lab.domain.entity.Equipo;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Jugadortorneo;
import quinielasocial.lab.domain.entity.Mensaje;
import quinielasocial.lab.domain.entity.Mensajejugador;
import quinielasocial.lab.domain.entity.Partido;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Prediccion;
import quinielasocial.lab.domain.entity.Resultado;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;

public class VMTorneo extends ControladorNavegacion {
	@WireVariable
	protected CRUDService servicio = (CRUDService) SpringUtil.getBean("CRUDService");
		
	private List<Torneo> torneos;
	private List<Torneo> torneosquinielas;
	private List<Jugadortorneo> jugadortorneos;
	private List<Jugadortorneo> jugadortorneosfiltro;
		
	private List<Persona> personas;
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	
	Persona personau;
	private Torneo torneoselected;
	
	
	private String nombretorneo, descripciontorneo,topeprediccion,puntoganado,puntomarcadorlocal,puntomarcadorvisitante;
	private Date fechainicio, fechafin;
	
	Session session = Sessions.getCurrent();
	Usuario usr = (Usuario) session.getAttribute("usuario");
	
	public String getNombretorneo() {
		return nombretorneo;
	}
	public void setNombretorneo(String nombretorneo) {
		this.nombretorneo = nombretorneo;
	}
	public String getDescripciontorneo() {
		return descripciontorneo;
	}
	public void setDescripciontorneo(String descripciontorneo) {
		this.descripciontorneo = descripciontorneo;
	}
	public String getTopeprediccion() {
		return topeprediccion;
	}
	public void setTopeprediccion(String topeprediccion) {
		this.topeprediccion = topeprediccion;
	}
	public String getPuntoganado() {
		return puntoganado;
	}
	public void setPuntoganado(String puntoganado) {
		this.puntoganado = puntoganado;
	}
	public String getPuntomarcadorlocal() {
		return puntomarcadorlocal;
	}
	public void setPuntomarcadorlocal(String puntomarcadorlocal) {
		this.puntomarcadorlocal = puntomarcadorlocal;
	}
	public String getPuntomarcadorvisitante() {
		return puntomarcadorvisitante;
	}
	public void setPuntomarcadorvisitante(String puntomarcadorvisitante) {
		this.puntomarcadorvisitante = puntomarcadorvisitante;
	}
	public Date getFechainicio() {
		return fechainicio;
	}
	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}
	public Date getFechafin() {
		return fechafin;
	}
	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
		
	public VMTorneo() {
		super();
		torneos = servicio.getAll(Torneo.class);
		personas = servicio.getAll(Persona.class);
	}
	@Command
	@NotifyChange("message")
	public void guardartorneo(){
		for(int i=0;i<personas.size();i++){
			if(usr.getCorreo().equals(personas.get(i).getCorreo())){
				personau = personas.get(i);
			}
		}
		Torneo newone = new Torneo((long)torneos.size()+1, nombretorneo, personau.getCedula(), descripciontorneo, 
				fechainicio, fechafin, Long.valueOf(topeprediccion), "/logo.png", Long.valueOf(puntoganado), 
				Long.valueOf(puntomarcadorlocal), Long.valueOf(puntomarcadorvisitante), true);
		servicio.Save(newone);
		session.setAttribute("torneo",newone);
		guardartorneopartido();
		
	}

}
