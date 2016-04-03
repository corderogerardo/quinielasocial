package quinielasocial.lab.domain.entity;
// Generated 23/03/2016 01:44:51 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Torneo generated by hbm2java
 */
@Entity
@Table(name = "torneo", schema = "public")
public class Torneo implements java.io.Serializable {

	private long torneoId;
	private Persona persona;
	private String nombre;
	private String cedula_administrador;
	private String descripcion;
	private Date fechainicio;
	private Date fechafin;
	private Long topepredicion;
	private String logotorneo;
	private Long punpreace;
	private Long punmarloc;
	private Long punmarvic;
	private Boolean estadi;

	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="equipo_id")
	private Set<Equipo> equipos;
	
	public Torneo() {
	}

	

	public Torneo(long torneoId, String nombre, String cedula_administrador, String descripcion, Date fechainicio,
			Date fechafin, Long topepredicion, String logotorneo, Long punpreace, Long punmarloc, Long punmarvic,
			Boolean estadi) {
		super();
		this.torneoId = torneoId;
		this.nombre = nombre;
		this.cedula_administrador = cedula_administrador;
		this.descripcion = descripcion;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.topepredicion = topepredicion;
		this.logotorneo = logotorneo;
		this.punpreace = punpreace;
		this.punmarloc = punmarloc;
		this.punmarvic = punmarvic;
		this.estadi = estadi;
	}



	@Id

	@Column(name = "torneo_id", unique = true, nullable = false)
	public long getTorneoId() {
		return this.torneoId;
	}

	public void setTorneoId(long torneoId) {
		this.torneoId = torneoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedula_administrador", unique=true, insertable = false, updatable = false)
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechainicio", nullable = false, length = 29)
	public Date getFechainicio() {
		return this.fechainicio;
	}

	public void setFechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechafin", nullable = false, length = 29)
	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	@Column(name = "topepredicion")
	public Long getTopepredicion() {
		return this.topepredicion;
	}

	public void setTopepredicion(Long topepredicion) {
		this.topepredicion = topepredicion;
	}

	@Column(name = "logotorneo")
	public String getLogotorneo() {
		return this.logotorneo;
	}

	public void setLogotorneo(String logotorneo) {
		this.logotorneo = logotorneo;
	}

	@Column(name = "punpreace")
	public Long getPunpreace() {
		return this.punpreace;
	}

	public void setPunpreace(Long punpreace) {
		this.punpreace = punpreace;
	}

	@Column(name = "punmarloc")
	public Long getPunmarloc() {
		return this.punmarloc;
	}

	public void setPunmarloc(Long punmarloc) {
		this.punmarloc = punmarloc;
	}

	@Column(name = "punmarvic")
	public Long getPunmarvic() {
		return this.punmarvic;
	}

	public void setPunmarvic(Long punmarvic) {
		this.punmarvic = punmarvic;
	}

	@Column(name = "estadi")
	public Boolean getEstadi() {
		return this.estadi;
	}

	public void setEstadi(Boolean estadi) {
		this.estadi = estadi;
	}
	public String getCedula_administrador() {
		return cedula_administrador;
	}
	public void setCedula_administrador(String cedula_administrador) {
		this.cedula_administrador = cedula_administrador;
	}
}
