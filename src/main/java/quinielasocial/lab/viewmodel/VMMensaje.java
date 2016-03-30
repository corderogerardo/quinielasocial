package quinielasocial.lab.viewmodel;

import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Mensaje;
import quinielasocial.lab.domain.entity.Mensajejugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Usuario;

public class VMMensaje {
	
	@WireVariable
	protected CRUDService serviciopersona = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciojugador = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciousuario = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciomensaje = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciomensajejugador = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Persona> personas;
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	private List<Mensaje> mensajes;
	private List<Mensajejugador> mensajesjugador;
	
	Persona personam = new Persona();
	Jugador jugadorm = new Jugador();
	Mensaje mensajem = new Mensaje();
	Mensajejugador mensajejugadorm = new Mensajejugador();
	
	private String cedula, nombre, idmensaje,mensaje;
	private Date nacimiento;
	
	Session session = Sessions.getCurrent();
	Usuario usr = (Usuario) session.getAttribute("usuario");

}
