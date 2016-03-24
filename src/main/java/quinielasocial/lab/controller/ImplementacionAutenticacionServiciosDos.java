/* 
	Description:
		ZK Essentials
	History:
		Created by dennis

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package quinielasocial.lab.controller;

import java.io.Serializable;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import servicio.ServicioAutenticacion;
import servicio.CredencialUsuario;

public class ImplementacionAutenticacionServiciosDos implements ServicioAutenticacion,Serializable{
	private static final long serialVersionUID = 1L;

	public CredencialUsuario getCredencialUsuario(){
		Session sess = Sessions.getCurrent();
		CredencialUsuario cre = (CredencialUsuario)sess.getAttribute("userCredential");
		if(cre==null){
			cre = new CredencialUsuario();//new a anonymous user and set to session
			sess.setAttribute("userCredential",cre);
		}
		return cre;
	}
	

	public boolean login(String nm, String pd) {
		// will be implemented in chapter 8
		return false;
	}


	public void logout() {
		// will be implemented in chapter 8
	}
}
