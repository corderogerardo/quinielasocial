package quinielasocial.lab.entity;

public class MensajeJugador {
	
	private int idmenjug;
	private String cedularem;
	private String cedulades;
	
	
	
	public MensajeJugador(int idmenjug, String cedularem, String cedulades) {
		super();
		this.idmenjug = idmenjug;
		this.cedularem = cedularem;
		this.cedulades = cedulades;
	}

	public MensajeJugador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdmenjug() {
		return idmenjug;
	}

	public void setIdmenjug(int idmenjug) {
		this.idmenjug = idmenjug;
	}

	public String getCedularem() {
		return cedularem;
	}

	public void setCedularem(String cedularem) {
		this.cedularem = cedularem;
	}

	public String getCedulades() {
		return cedulades;
	}

	public void setCedulades(String cedulades) {
		this.cedulades = cedulades;
	}
	
	

}
