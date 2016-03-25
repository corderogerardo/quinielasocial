package quinielasocial.lab.domain.entity;
// Generated 23/03/2016 01:44:51 AM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
import javax.persistence.UniqueConstraint;

/**
 * Jugador generated by hbm2java
 */
@Entity
@Table(name = "jugador", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "cedulajugador"))
public class Jugador implements java.io.Serializable {

	private long jugadorId;
	private Persona persona;
	private Float puntajetotal;
	private Date fechaIngreso;
	private String jugadorcedula;
	private Set<Jugadortorneo> jugadortorneos = new HashSet<Jugadortorneo>(0);
	private Set<Prediccion> prediccions = new HashSet<Prediccion>(0);

	public Jugador() {
	}
	
	

	public Jugador(long jugadorId, Float puntajetotal, Date fechaIngreso, String jugadorcedula) {
		super();
		this.jugadorId = jugadorId;
		this.puntajetotal = puntajetotal;
		this.fechaIngreso = fechaIngreso;
		this.jugadorcedula = jugadorcedula;
	}


	public Jugador(long jugadorId, Persona persona, Float puntajetotal, Date fechaIngreso,
			Set<Jugadortorneo> jugadortorneos, Set<Prediccion> prediccions) {
		this.jugadorId = jugadorId;
		this.persona = persona;
		this.puntajetotal = puntajetotal;
		this.fechaIngreso = fechaIngreso;
		this.jugadortorneos = jugadortorneos;
		this.prediccions = prediccions;
	}

	@Id

	@Column(name = "jugador_id", unique = true, nullable = false)
	public long getJugadorId() {
		return this.jugadorId;
	}

	public void setJugadorId(long jugadorId) {
		this.jugadorId = jugadorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cedulajugador", unique = true,insertable=false, updatable=false)
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "puntajetotal", precision = 8, scale = 8)
	public Float getPuntajetotal() {
		return this.puntajetotal;
	}

	public void setPuntajetotal(Float puntajetotal) {
		this.puntajetotal = puntajetotal;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso", nullable = false, length = 29)
	public Date getFechaIngreso() {
		return this.fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugador")
	public Set<Jugadortorneo> getJugadortorneos() {
		return this.jugadortorneos;
	}

	public void setJugadortorneos(Set<Jugadortorneo> jugadortorneos) {
		this.jugadortorneos = jugadortorneos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jugador")
	public Set<Prediccion> getPrediccions() {
		return this.prediccions;
	}

	public void setPrediccions(Set<Prediccion> prediccions) {
		this.prediccions = prediccions;
	}



	public String getCedulajugador() {
		return jugadorcedula;
	}



	public void setCedulajugador(String jugadorcedula) {
		this.jugadorcedula = jugadorcedula;
	}
	
	

}
