package quinielasocial.lab.domain.entity;

public class JugadorTorneo {
	
	private int idtor;
	private String cedulajugador;
	private int puntor;
	private String estadojt;
	
	
	public JugadorTorneo(int idtor, String cedulajugador, int puntor, String estadojt) {
		super();
		this.idtor = idtor;
		this.cedulajugador = cedulajugador;
		this.puntor = puntor;
		this.estadojt = estadojt;
	}


	public JugadorTorneo() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdtor() {
		return idtor;
	}


	public void setIdtor(int idtor) {
		this.idtor = idtor;
	}


	public String getCedulajugador() {
		return cedulajugador;
	}


	public void setCedulajugador(String cedulajugador) {
		this.cedulajugador = cedulajugador;
	}


	public int getPuntor() {
		return puntor;
	}


	public void setPuntor(int puntor) {
		this.puntor = puntor;
	}


	public String getEstadojt() {
		return estadojt;
	}


	public void setEstadojt(String estadojt) {
		this.estadojt = estadojt;
	}
	
	
	

}
