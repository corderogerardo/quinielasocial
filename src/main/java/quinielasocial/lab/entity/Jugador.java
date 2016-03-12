package quinielasocial.lab.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="jugador", schema="public")
@PrimaryKeyJoinColumn(name="persona_cedula")
public class Jugador extends Persona implements Serializable {

	private static final long serialVersionUID = 1L;
	private float puntaje;
	
	@Column
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
