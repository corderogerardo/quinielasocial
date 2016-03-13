package quinielasocial.lab.entity;

import java.io.Serializable;
import java.util.Date;

public class Jugador extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private float puntaje;
	
	
	
	public Jugador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jugador(String cedula, String nombre, String apellido, Date fechanacimiento, String correo,
			String foto, float puntaje) {
		super(cedula, nombre, apellido, fechanacimiento, correo, foto);
		this.puntaje = puntaje;
	}
	public float getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(float puntaje) {
		this.puntaje = puntaje;
	}
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
