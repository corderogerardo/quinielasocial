package quinielasocial.lab.controller;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Usuario;

public class ControladorRegistrarUsuario extends SelectorComposer<Component>{
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
	private Jugador jugador;
	
//	wire components
	@Wire
	private Textbox txtCedula;
	@Wire
	private Textbox txtNombre;
	@Wire
	private Textbox txtApellido;
	@Wire
	private Datebox dtFechaNacimiento;
	@Wire
	private Textbox txtCorreo;
	@Wire
	private Textbox txtContrasena;
	@Wire
	private Textbox txtConfiContrasena;
	@Wire
	private Checkbox checkTermBox;
	@Wire
	private Button btnRegistrar;
	@Wire
	private Button btnCancelar;
	
//	Validacion para el checkbox para confirmar que el usuario acepta los terminos y conficiones.
	@Listen("onCheck=#checkTermBox")
	public void confirmacion(){
		if(checkTermBox.isChecked()){
			btnRegistrar.setDisabled(false);
		}
		else{
			btnRegistrar.setDisabled(true);
		}
		
	}
//	Para limpiar los campos cuando el usuario le de cancelar
	@Listen("onClick=#btnCancelar")
	public void botonCancelar(){
		btnRegistrar.setDisabled(true);
		checkTermBox.setChecked(false);
		dtFechaNacimiento.setValue(null);
		txtCedula.setValue(" ");
		txtNombre.setValue(" ");
		txtApellido.setValue(" ");
		txtCorreo.setValue(" ");
		txtContrasena.setValue(" ");
		txtConfiContrasena.setValue(" ");
	}
//	Para cuanto el usuario invoque al evento onClick del boton registrar
	@Listen("onClick=#btnRegistrar; onOk=#registrarWin")
	public void botonRegistrar(){
		if(txtContrasena.getValue().equals(txtConfiContrasena.getValue())){
			//jugador = new Jugador(jugadorId, persona, puntajetotal, fechaIngreso, jugadortorneos, prediccions);
			
			serviciojugador.Save(jugador);
			Messagebox.show("Usuario registrado correctamente");
			Executions.sendRedirect("/indexSesion.zul");
		}
		else{
			Messagebox.show("Las contraseñas no son iguales, por favor verifica");
			txtContrasena.setValue(" ");
			txtConfiContrasena.setValue(" ");
			txtContrasena.setFocus(true);
			return;
		}
		
		
	}
	
	
	
	
}
