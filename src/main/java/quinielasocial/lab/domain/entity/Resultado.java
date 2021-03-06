package quinielasocial.lab.domain.entity;
// Generated 23/03/2016 01:44:51 AM by Hibernate Tools 4.3.1.Final

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

/**
 * Resultado generated by hbm2java
 */
@Entity
@Table(name = "resultado", schema = "public")
public class Resultado implements java.io.Serializable {

	private long resultadoId;
	private long scorelocal;
	private long scorevisitante;


	private String estado;

	public Resultado() {
	}

	public Resultado(long resultadoId, long scorelocal, long scorevisitante, String estado) {
		this.resultadoId = resultadoId;
		this.scorelocal = scorelocal;
		this.scorevisitante = scorevisitante;
		this.estado = estado;

	}



	@Id

	@Column(name = "resultado_id", unique = true, nullable = false)
	public long getResultadoId() {
		return this.resultadoId;
	}

	public void setResultadoId(long resultadoId) {
		this.resultadoId = resultadoId;
	}

	@Column(name = "scorelocal", nullable = true)
	public long getScorelocal() {
		return this.scorelocal;
	}

	public void setScorelocal(long scorelocal) {
		this.scorelocal = scorelocal;
	}

	@Column(name = "scorevisitante", nullable = true)
	public long getScorevisitante() {
		return this.scorevisitante;
	}

	public void setScorevisitante(long scorevisitante) {
		this.scorevisitante = scorevisitante;
	}
	@Column(name = "estado", nullable = false)
	public final String getEstado() {
		return estado;
	}

	public final void setEstado(String estado) {
		this.estado = estado;
	}

}
