/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package quinielasocial.lab.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import modelo.Usuario;
import servicio.ServicioInfoUsuario;

public class ServiceUserInfoImplementacion implements ServicioInfoUsuario,Serializable{
	private static final long serialVersionUID = 1L;
	
	static protected List<Usuario> userList = new ArrayList<Usuario>();  
	static{
		userList.add(new Usuario("user@quin.com.ve", "1234", 1));
	}
	
	@Override
	public Usuario encontrarUsuario(String correo) {
		int s = userList.size();
		for(int i=0;i<s;i++){
			Usuario u = userList.get(i);
			if(correo.equals(u.getCorreo())){
				return Usuario.clone(u);
			}
		}
		return null;
	}

	@Override
	public Usuario actualizarUsuario(Usuario user) {
		int s = userList.size();
		for(int i=0;i<s;i++){
			Usuario u = userList.get(i);
			if(user.getCorreo().equals(u.getCorreo())){
				userList.set(i,u = Usuario.clone(user));
				return u;
			}
		}
		throw new RuntimeException("Usuario no encontrado "+user.getCorreo());
	}
}
