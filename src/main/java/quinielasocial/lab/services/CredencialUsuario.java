package quinielasocial.lab.services;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CredencialUsuario implements Serializable {
	
		private static final long serialVersionUID = 1L;
		
		String usuario;
		String nombre;
		
		Set<String> roles = new HashSet<String>();

		public CredencialUsuario(String usuario, String nombre) {
			this.usuario = usuario;
			this.nombre = nombre;
		}

		public CredencialUsuario() {
			this.usuario = "anonymous";
			this.nombre = "Anonymous";
			roles.add("anonymous");
		}

		public boolean isAnonymous() {
			return hasRole("anonymous") || "anonymous".equals(usuario);
		}

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		
		public boolean hasRole(String role){
			return roles.contains(role);
		}
		
		public void addRole(String role){
			roles.add(role);
		}

}
