package quinielasocial.lab.viewmodel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Messagebox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Mensaje;
import quinielasocial.lab.domain.entity.Mensajejugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Usuario;

public class VMMensaje {
	
	@WireVariable
	protected CRUDService servicio = (CRUDService) SpringUtil.getBean("CRUDService");
	
	
	private List<Persona> personas;
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	private List<Mensaje> mensajes;
	private List<Mensaje> mismensajes = new ArrayList<Mensaje>();
	private List<Mensajejugador> mensajesjugador;
	private List<String> correousuarios= new ArrayList<String>();
	private List<String> correoremitentes= new ArrayList<String>();
	
	Persona personam = new Persona();
	Jugador jugadorm = new Jugador();
	Mensaje mensajem = new Mensaje();
	Mensaje mensajeenviar = new Mensaje();
	Mensajejugador mensajejugadorm = new Mensajejugador();
	
	private String cedula, nombre, idmensaje,mensajetxt,destinatario, remitente,cadenaUsuarios;
	private Date nacimiento;
	
	Session session = Sessions.getCurrent();
	Usuario usr = (Usuario) session.getAttribute("usuario");
	
	public VMMensaje() {
		super();
		personas = servicio.getAll(Persona.class);
		usuarios = servicio.getAll(Usuario.class);
		mensajes = servicio.getAll(Mensaje.class);
		mensajesjugador = servicio.getAll(Mensajejugador.class);
		
		cargarCorreos();
		for(int p = 0;p<personas.size();p++){
			if(usr.getCorreo().equals(personas.get(p).getCorreo())){
				remitente = personas.get(p).getCedula();
			}
		}
		cargarMisMensajes();
	}
	
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdmensaje() {
		return idmensaje;
	}
	public void setIdmensaje(String idmensaje) {
		this.idmensaje = idmensaje;
	}
	public String getMensaje() {
		return mensajetxt;
	}
	public void setMensaje(String mensajetxt) {
		this.mensajetxt = mensajetxt;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	//Llenar combo de usuarios con un arraylist
	public List<String> getCorreousuarios() {
		return correousuarios;
	}
	public void setCorreousuarios(List<String> correousuarios) {
		this.correousuarios = correousuarios;
	}

	public String getCadenaUsuarios() {
		return cadenaUsuarios;
	}

	public void setCadenaUsuarios(String cadenaUsuarios) {
		this.cadenaUsuarios = cadenaUsuarios;
	}
	//Metodo para cargar arraylist solo con los correos.
	public void cargarCorreos(){
		for(int i=0;i<usuarios.size();i++){
			correousuarios.add(usuarios.get(i).getCorreo());
		}
	}
	
	//Metodo para cargar mis mensajes
	public void cargarMisMensajes(){
		mensajesjugador.clear();
		mensajesjugador = servicio.getAll(Mensajejugador.class);
		for(int i = 0;i<mensajesjugador.size();i++){
			if(remitente.equals(mensajesjugador.get(i).getCedulades())){
				for(int j=0;j<mensajes.size();j++){
					if(mensajesjugador.get(i).getIdmensaje()==mensajes.get(j).getMensajeId()){
						mismensajes.add(mensajes.get(j));
					}
				}
			}
		}
	}
	// cargar mensajes desde el list
	public Mensaje getMensajem() {
		return mensajem;
	}

	public void setMensajem(Mensaje mensajem) {
		this.mensajem = mensajem;
	}
	public List<Mensaje> getMensajesUsuario() {
		return mismensajes;
	}
	public void setMensajesUsuario(List<Mensaje> mismensajes) {
		this.mismensajes = mismensajes;
	}
	
	@Command
	@NotifyChange("message")
	public void enviar(){
		Messagebox.show("Mensaje "+getMensaje());
		mensajeenviar = new Mensaje((long)mensajes.size()+1, getMensaje() , 'N');
		servicio.Save(mensajeenviar);
		mensajes.clear();
		mensajes = servicio.getAll(Mensaje.class);
		
		for(int p = 0;p<personas.size();p++){
			if(cadenaUsuarios.equals(personas.get(p).getCorreo())){
				destinatario = personas.get(p).getCedula();
			}
		}
		Messagebox.show("Mensaje "+getDestinatario()+" "+getRemitente());
		mensajejugadorm = new Mensajejugador((long)mensajesjugador.size()+1, (long)mensajes.size(), destinatario, remitente);
		servicio.Save(mensajejugadorm);
		mismensajes.clear();
		cargarMisMensajes();
		
	}
}
