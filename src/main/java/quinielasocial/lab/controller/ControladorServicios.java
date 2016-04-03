package quinielasocial.lab.controller;

import java.util.List;

import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;

import quinielasocial.lab.domain.entity.*;

public class ControladorServicios {
	
	@WireVariable
	protected CRUDService servicio = (CRUDService) SpringUtil.getBean("CRUDService");
	
		
	private List<Persona> personas;
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	private List<Rol> roles;
	private List<Torneo> torneos;
	private List<Jugadortorneo> jugadortorneos;
	private List<Equipo> equipos;
	private List<Partido> partidos;
	private List<Prediccion> predicciones;
	private List<Resultado> resultados;
	private List<Mensaje> mensajes;
	private List<Mensajejugador> mensajejugadores;
	
	private Persona unpersona;
	private Jugador unjugador;
	private Usuario unusuario;
	private Torneo untorneo;
	private Jugadortorneo unjugadortorneo;
	private Equipo unequipo;
	private Partido unpartido;
	private Prediccion unprediccion;
	private Resultado unresultado;
	private Mensaje unmensaje;
	private Mensajejugador unmensajejugador;
	
	public ControladorServicios() {
		super();
		personas = servicio.getAll(Persona.class);
		jugadores = servicio.getAll(Jugador.class);
		usuarios = servicio.getAll(Usuario.class);
		torneos = servicio.getAll(Torneo.class);
		jugadortorneos = servicio.getAll(Jugadortorneo.class);
		equipos = servicio.getAll(Equipo.class);
		partidos = servicio.getAll(Partido.class);
		predicciones = servicio.getAll(Prediccion.class);
		resultados = servicio.getAll(Resultado.class);
		mensajes = servicio.getAll(Mensaje.class);
		mensajejugadores = servicio.getAll(Mensajejugador.class);
	}



}
