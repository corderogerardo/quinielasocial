package quinielasocial.lab.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.Predicate;

import org.springframework.util.CollectionUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Usuario;


public class ControladorUsuario extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
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
	private List<Rol> roles;
	private Usuario unusuario;
	

	
	//wire components registrar
	@Wire
	Textbox cedula;
	@Wire
	Textbox nombre;
	@Wire
	Textbox apellido;
	@Wire
	Textbox correo;
	@Wire
	Date fechanacimiento;
	@Wire
	Textbox clave;
	@Wire
	Textbox confcontrasena;
	@Wire
	Textbox urlfoto;
	//wire components login
		@Wire
		Textbox usuario;
		@Wire
		Textbox password;
	//Mensajes
	@Wire
	Label message;
		
		public ControladorUsuario(){
			super();
			try{
			personas = serviciopersona.getAll(Persona.class);
			roles = serviciorol.getAll(Rol.class);
			usuarios = serviciousuario.getAll(Usuario.class);
			jugadores = serviciojugador.getAll(Jugador.class);

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@Listen("onClick=#login; onOK=#loginWin")
		public void doLogin(){
		
			
			
			//Login
			String txtUser = usuario.getValue().toString();
			String txtPass = password.getValue().toString();
			
			Session miSession = Sessions.getCurrent();
			
			//Paso 1 Buscar usuario con ese correo: Hay dos formas, 1. con una consulta SQL, 2. En los servicios.
			
			usuarios = serviciousuario.getAll(Usuario.class);
			
			
			
			//Paso 2 si existe validad que la contraseña sea la correcta.
			//Paso 3 setear variable de sesion
			//Paso 4 si es valido redireccionar
			
			Boolean s=false;
						
//			for (int i=0;i<usuarios.size();i++){
//				Messagebox.show("Usuario actual: "+usuarios.toString(), "Error", Messagebox.OK, Messagebox.ERROR);
//				
//				//Paso 1 Buscar usuario con ese correo
//				if(txtUser.equals(usuarios.get(i).getPersona().getCorreo())) {
//
//					//Paso 2 si existe validad que la contraseña sea la correcta.
//					if (txtPass.equals(usuarios.get(i).getContrasena()) && usuarios.get(i).getRol().getRolId()== 1 ){ //si es jugador
//						//Paso 3 setear variable de sesion
//						miSession.setAttribute("usuario", usuarios.get(i));	
//						//Paso 4 si es valido redireccionar
//						Executions.sendRedirect("/administradorPagina/indexSesionAdmin.zul");					
//						s=true;
//					}
//					else
//					if (txtPass.equals(usuarios.get(i).getContrasena()) && usuarios.get(i).getRol().getRolId()== 2){ //si es admin
//	
//						miSession.setAttribute("usuario", usuarios.get(i));					
//						Executions.sendRedirect("/indexSesion.zul");		
//						s=true;
//					}
//						
//				}
//								
//			}
		
			long cant = usuarios.size();
			Messagebox.show("Usuario actual: "+cant);

//			if (s==false){
//				 Messagebox.show("Clave o Usuario Incorrecto, por favor verifique.", "Error", Messagebox.OK, Messagebox.ERROR);
//			}
			//Executions.sendRedirect("/indexSesion.zul");
			
		}
		
		@Listen("onClick=#saved; onOK=#registrarWin")
		public void saved(){
			//Registrar
			String txtCedula = cedula.getValue().toString();
			String txtNombre= nombre.getValue().toString();
			String txtApellido = apellido.getValue().toString();
			String txtCorreo = correo.getValue().toString();
			Date txtFechanacimiento = fechanacimiento;
			String txtClave =clave.getValue().toString();
			String txtConfcontrasena = confcontrasena.getValue().toString();
			String txtUrlfoto = urlfoto.getValue().toString();
			
			//Paso 1 validad campos no vacios
			//Paso 2 si todo el formulario esta completo guardar
			
			Persona personac = new Persona(txtCedula, txtNombre, txtApellido, txtFechanacimiento, txtCorreo);
			serviciopersona.Save(personac);
			Usuario usuarioc = new Usuario(txtCorreo, txtClave, txtFechanacimiento, true,2);
			serviciousuario.Save(usuarioc);
			Jugador jugadorc = new Jugador(personac, (float) 0, new Date());
			serviciojugador.Save(jugadorc);		
		}
}
