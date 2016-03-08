package quinielasocial.lab.entity;

public class Jugador {

	private String cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String clave;
	private String foto;
	private int puntaje;
	private String tipo;
	private String estado;
	
	
	public Jugador(String cedula, String nombre, String apellido,
			String correo, String clave, String foto, int puntaje,String tipo, String estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.clave = clave;
		this.foto = foto;
		this.setPuntaje(puntaje);
		this.tipo = tipo;
		this.estado = estado;
	}
	
	
	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public int getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

}
