
package quinielasocial.lab.controller;

import controlador.ImplementacionAutenticacionServiciosDos;
import controlador.ServiceUserInfoImplementacion;

import modelo.Usuario;

import servicio.CredencialUsuario; 
import servicio.ServicioInfoUsuario;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

public class ImplementacionAutenticacionServicios extends ImplementacionAutenticacionServiciosDos{
	private static final long serialVersionUID = 1L;
	
	ServicioInfoUsuario servicioInfoUsr = new ServiceUserInfoImplementacion();
	
	@Override
	public boolean login(String nm, String pd) {
		Usuario user = servicioInfoUsr.encontrarUsuario(nm);
		//a simple plan text password verification
		if(user==null || !user.getContrasena().equals(pd)){
			return false;
		}
		
		Session sess = Sessions.getCurrent();
		CredencialUsuario cre = new CredencialUsuario(user.getCorreo(),"Anomimo");
		//just in case for this demo.
		if(cre.isAnonymous()){
			return false;
		}
		sess.setAttribute("userCredential",cre);
		
		//TODO handle the role here for authorization
		return true;
	}
	
	@Override
	public void logout() {
		Session sess = Sessions.getCurrent();
		sess.removeAttribute("userCredential");
	}
}
