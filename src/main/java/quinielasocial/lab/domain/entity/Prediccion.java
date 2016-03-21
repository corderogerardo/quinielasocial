package quinielasocial.lab.domain.entity;

public class Prediccion {
	
	private int idpar;
	private String cedulajugador;
	private int resequloc;
	private int resequvis;
	private String estadopre;
	
	
	public Prediccion(int idpar, String cedulajugador, int resequloc, int resequvis, String estadopre) {
		super();
		this.idpar = idpar;
		this.cedulajugador = cedulajugador;
		this.resequloc = resequloc;
		this.resequvis = resequvis;
		this.estadopre = estadopre;
	}


	public Prediccion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdpar() {
		return idpar;
	}


	public void setIdpar(int idpar) {
		this.idpar = idpar;
	}


	public String getCedulajugador() {
		return cedulajugador;
	}


	public void setCedulajugador(String cedulajugador) {
		this.cedulajugador = cedulajugador;
	}


	public int getResequloc() {
		return resequloc;
	}


	public void setResequloc(int resequloc) {
		this.resequloc = resequloc;
	}


	public int getResequvis() {
		return resequvis;
	}


	public void setResequvis(int resequvis) {
		this.resequvis = resequvis;
	}


	public String getEstadopre() {
		return estadopre;
	}


	public void setEstadopre(String estadopre) {
		this.estadopre = estadopre;
	}
	
	
	

}
