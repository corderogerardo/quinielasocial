package quinielasocial.lab.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "jugadores", schema="public")
@PrimaryKeyJoinColumn(name="cedula")
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
