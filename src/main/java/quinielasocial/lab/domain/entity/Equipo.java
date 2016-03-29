package quinielasocial.lab.domain.entity;
// Generated 23/03/2016 01:44:51 AM by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Equipo generated by hbm2java
 */
@Entity
@Table(name = "equipo", schema = "public")
public class Equipo implements java.io.Serializable {

	private long equipoId;
	private String nombre;
	private String descripcion;
	private String logo;
	private long torneoid;

	public Equipo() {
	}

	public Equipo(long equipoId, String nombre) {
		this.equipoId = equipoId;
		this.nombre = nombre;
	}

	public Equipo(long equipoId, String nombre, String descripcion, String logo, long torneoid) {
		this.equipoId = equipoId;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.logo = logo;
		this.torneoid = torneoid;
	}

	@Id

	@Column(name = "equipo_id", unique = true, nullable = false)
	public long getEquipoId() {
		return this.equipoId;
	}

	public void setEquipoId(long equipoId) {
		this.equipoId = equipoId;
	}

	@Column(name = "nombre", nullable = false)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "descripcion")
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Column(name = "logo")
	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}
	@Column(name = "torneoid")
	public long getTorneoid() {
		return torneoid;
	}

	public void setTorneoid(long torneoid) {
		this.torneoid = torneoid;
	}
	

}
