package quinielasocial.lab.viewmodel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.WrongValueException;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Button;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Usuario;

public class VMUsuario {
	
	@WireVariable
	protected CRUDService serviciopersona = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciojugador = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciousuario = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciorol = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Persona> personas;
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	
	Persona personau = new Persona();
	Jugador jugadoru = new Jugador();
	
	private String cedula, nombre,apellido,correo,passuno, passdos, urlfoto;
	private Date nacimiento;
	
	Session session = Sessions.getCurrent();
	Usuario usr = (Usuario) session.getAttribute("usuario");
	
			
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
			public String getApellido() {
				return apellido;
			}
			public void setApellido(String apellido) {
				this.apellido = apellido;
			}
			public String getCorreo() {
				return correo;
			}
			public void setCorreo(String correo) {
				this.correo = correo;
			}
			public String getPassuno() {
				return passuno;
			}
			public void setPassuno(String passuno) {
				this.passuno = passuno;
			}
			public String getPassdos() {
				return passdos;
			}
			public void setPassdos(String passdos) {
				this.passdos = passdos;
			}
			public Date getNacimiento() {
				return nacimiento;
			}
			public void setNacimiento(Date nacimiento) {
				this.nacimiento = nacimiento;
			}
			
			
			public String getUrlfoto() {
				return urlfoto;
			}
			public void setUrlfoto(String urlfoto) {
				this.urlfoto = urlfoto;
			}
			@Init
			public void CargarPerfil(){
				
				try{
					personau = new Persona();
					jugadoru = new Jugador();
					personas = serviciopersona.getAll(Persona.class);
					jugadores = serviciojugador.getAll(Jugador.class);
					//Paso 1 buscar lo que tiene sesion
					Session session = Sessions.getCurrent();
					Usuario usr = (Usuario) session.getAttribute("usuario");
					for(int i = 0; i<personas.size();i++){
						if(usr.getCorreo().equals(personas.get(i).getCorreo())){
							personau = personas.get(i);
						}
					}
					for(int j = 0; j<jugadores.size();j++){
						if(personau.getCedula().equals(jugadores.get(j).getCedulajugador())){
							jugadoru = jugadores.get(j);
						}
					}
//					Messagebox.show("Sesiones "+usr.getCorreo().toString());
//					Messagebox.show("Sesiones "+personau.getCedula().toString());
					//Paso 2 asignarlo a las cajas de texto
					//Registrar
					
					cedula = personau.getCedula();
					apellido= personau.getApellido();
					nombre = personau.getNombre();
					correo = usr.getCorreo();
					nacimiento = personau.getFechanacimiento();
					passuno = usr.getContrasena();
					passdos = usr.getContrasena();
					
				
					}catch(Exception e){
						e.printStackTrace();
					}
				
			}
			//Fin CargarPerfil
			
			@Command
			@NotifyChange("message")
			public void update(){
			//Tomando la fecha de nacimiento y dandole formato correcto
				SimpleDateFormat smFechanacimiento = new SimpleDateFormat("dd/MM/yyyy");
				Date txtFechanacimientou = getNacimiento();
				try {
					txtFechanacimientou = smFechanacimiento.parse(getNacimiento().toString());
				} catch (WrongValueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//Paso 1 validad campos no vacios
				//Paso 2 Valida contraseñas iguales
				if(getPassuno().equals(getPassdos()) ){
					//Paso 3 si todo el formulario esta completo guardar
					Persona personac = new Persona(getCedula(), personau.getPersonaId(), getNombre(), getApellido(),txtFechanacimientou, getUrlfoto(), true, getCorreo());
					serviciopersona.Save(personac);
					Usuario usuarioc = new Usuario(usr.getUsuarioId(), getPassuno(), new Date(), true, 2, getCorreo());
					serviciousuario.Save(usuarioc);
					Jugador jugadorc = new Jugador(jugadoru.getJugadorId(), (float)0, new Date(), getCedula());
					serviciojugador.Save(jugadorc);		
				}else{
					 Messagebox.show("Contreñas no son iguales, por favor verifique.", "Error", Messagebox.OK, Messagebox.ERROR);
				}
			}//fin actualizar
			
			
			
	

}
