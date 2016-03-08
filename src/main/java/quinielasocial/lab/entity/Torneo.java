package quinielasocial.lab.entity;

import java.util.Date;

public class Torneo {
	private String deporte;
	private String nombre;
	private Date fechaInicio;
	private Date fechaFin;
	private int cantParticipantes;
	
	
	public Torneo(String deporte, String nombre, Date fechaInicio, Date fechaFin, int cantParticipantes) {
		super();
		this.deporte = deporte;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantParticipantes = cantParticipantes;
	
	}
	
	public Torneo() {
		super();
  }
	
	public String getDeporte() {
		return deporte;
	}


	public String getNombre() {
		return nombre;
	}


	public Date getfechaInicio() {
		return fechaInicio;
	}


	public Date getfechaFin() {
		return fechaFin;
	}
	public String getcantParticipantes() {
		return new Integer(cantParticipantes).toString();
	}

	
	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setCantParticipantes(String cantParticipantes) {
		this.cantParticipantes = Integer.parseInt(cantParticipantes);
	}
	
	
}	



