package quinielasocial.lab.services;


public interface ServicioAutenticacion {

	/**login with account and password**/
	public boolean login(String correo, String password);
	
	/**logout current user**/
	public void logout();
	
	/**get current user credential**/
	public CredencialUsuario getCredencialUsuario();
	
}
