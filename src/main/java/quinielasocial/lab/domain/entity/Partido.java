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

/**
 * Partido generated by hbm2java
 */
@Entity
@Table(name = "partido", schema = "public")
public class Partido implements java.io.Serializable {

	private long partidoId;
	private Resultado resultado;
	private long idtor;
	private long idequiloc;
	private long idequvis;
	private String lugar;
	private Date fecha;
	private String estado;
	private long idResultado;
	private Set<Prediccion> prediccions = new HashSet<Prediccion>(0);

	public Partido() {
	}
	
	public Partido(long partidoId, long idtor, long idequiloc, long idequvis, String lugar, Date fecha, String estado,
			long idResultado) {
		super();
		this.partidoId = partidoId;
		this.idtor = idtor;
		this.idequiloc = idequiloc;
		this.idequvis = idequvis;
		this.lugar = lugar;
		this.fecha = fecha;
		this.estado = estado;
		this.idResultado = idResultado;
	}




	@Id

	@Column(name = "partido_id", unique = true, nullable = false)
	public long getPartidoId() {
		return this.partidoId;
	}

	public void setPartidoId(long partidoId) {
		this.partidoId = partidoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idresultado", nullable = false)
	public Resultado getResultado() {
		return this.resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Column(name = "idtor", nullable = false)
	public long getIdtor() {
		return this.idtor;
	}

	public void setIdtor(long idtor) {
		this.idtor = idtor;
	}

	@Column(name = "idequiloc", nullable = false)
	public long getIdequiloc() {
		return this.idequiloc;
	}

	public void setIdequiloc(long idequiloc) {
		this.idequiloc = idequiloc;
	}

	@Column(name = "idequvis", nullable = false)
	public long getIdequvis() {
		return this.idequvis;
	}

	public void setIdequvis(long idequvis) {
		this.idequvis = idequvis;
	}

	@Column(name = "lugar", nullable = false)
	public String getLugar() {
		return this.lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha", nullable = false, length = 29)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "estado")
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "partido")
	public Set<Prediccion> getPrediccions() {
		return this.prediccions;
	}

	public void setPrediccions(Set<Prediccion> prediccions) {
		this.prediccions = prediccions;
	}

	public long getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(long idResultado) {
		this.idResultado = idResultado;
	}
	
	

}
