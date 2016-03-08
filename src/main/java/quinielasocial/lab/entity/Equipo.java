package quinielasocial.lab.entity;


public class Equipo {

	private String idequipo;
	private String nombreeq;
	private String logo;
	private String efectividad;

	
	public Equipo(String idequipo, String nombreeq, String logo, String efectividad ) {
		super();
		this.idequipo = idequipo;
		this.nombreeq = nombreeq;
		this.logo = logo;
		this.efectividad = efectividad;
		
	}
	
	public Equipo() {
		super();
  }
	
	public String getIdequipo() {
		return idequipo;
	}


	public String getNombreeq() {
		return nombreeq;
	}


	public String getLogo() {
		return logo;
	}


	public String getEfectividad() {
		return efectividad;
	}
	
		
	public void setIdequipo(String idequipo) {
		this.idequipo = idequipo;
	}

	public void setNombreeq(String nombreeq) {
		this.nombreeq = nombreeq;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

		
	public void setEfectividad(String efectividad) {
		this.efectividad = efectividad;
	}

	
}	
