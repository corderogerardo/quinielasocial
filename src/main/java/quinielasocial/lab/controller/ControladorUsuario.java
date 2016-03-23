package quinielasocial.lab.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Usuario;


public class ControladorUsuario extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	
	@WireVariable
	protected CRUDService serviciojugador = (CRUDService) SpringUtil.getBean("CRUDService");
	protected CRUDService serviciousuario = (CRUDService) SpringUtil.getBean("CRUDService");
	protected CRUDService serviciorol = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Jugador> jugadores;
	private List<Usuario> usuarios;
	private List<Rol> roles;
	
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
	//Registrar
	private String txtCedula = cedula.getValue().toString();
	private String txtNombre= nombre.getValue().toString();
	private String txtApellido = apellido.getValue().toString();
	private String txtCorreo = correo.getValue().toString();
	private Date txtFechanacimiento = fechanacimiento;
	private String txtClave =clave.getValue().toString();
	private String txtConfcontrasena = confcontrasena.getValue().toString();
	private String txtUrlfoto = urlfoto.getValue().toString();
	//Login
	private String txtUser = usuario.getValue().toString();
	private String txtPass = password.getValue().toString();
	private Session miSession = Sessions.getCurrent();
		
		public ControladorUsuario(){
			super();
			try{
				

			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		@Listen("onClick=#login; onOK=#loginWin")
		public void doLogin(){
			
			//Paso 1 Buscar usuario con ese correo
			//Paso 2 si existe validad que la contraseña sea la correcta.
			//Paso 3 setear variable de sesion
			//Paso 4 si es valido redireccionar
			
			Boolean s=false;
						
			for (int i=0;i<usuarios.size();i++){
				//Paso 1 Buscar usuario con ese correo
				if(txtUser.equals(usuarios.get(i).getCorreo())) {
					//Paso 2 si existe validad que la contraseña sea la correcta.
					if (txtPass.equals(usuarios.get(i).getClave()) && usuarios.get(i).getRols().getId()== 1 ){ //si es jugador
						//Paso 3 setear variable de sesion
						miSession.setAttribute("usuario", usuarios.get(i));	
						//Paso 4 si es valido redireccionar
						Executions.sendRedirect("/administradorPagina/indexSesionAdmin.zul");					
						s=true;
					}
					else
					if (txtPass.equals(usuarios.get(i).getClave()) && usuarios.get(i).getRols().getId()== 2){ //si es admin
	
						miSession.setAttribute("usuario", usuarios.get(i));					
						Executions.sendRedirect("/indexSesion.zul");		
						s=true;
					}
						
				}
								
			}
			if (s==false){
				 Messagebox.show("Clave o Usuario Incorrecto, por favor verifique.", "Error", Messagebox.OK, Messagebox.ERROR);
			}
			Executions.sendRedirect("/indexSesion.zul");
			
		}
		
		@Listen("onClick=#saved; onOK=#registrarWin")
		public void saved(){
			
			//Paso 1 validad campos no vacios
			//Paso 2 si todo el formulario esta completo guardar
			
			
			Rol rolm;
			rolm = new Rol("Jugador");
			
			
			Usuario usuariom;
			usuariom = new Usuario(txtCorreo, txtClave, txtFechanacimiento, true, rolm);
			Jugador jugadorm;
			jugadorm = new Jugador(txtCedula, txtNombre, txtApellido, txtFechanacimiento, txtUrlfoto, true, usuariom, 0, new Date());
			serviciojugador.Save(jugadorm);
						
		}
}
