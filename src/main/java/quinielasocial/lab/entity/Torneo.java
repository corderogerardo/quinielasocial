package quinielasocial.lab.entity;

import java.util.Date;

public class Torneo {
	
	private String cedadmin;
	private String nomtor;
	private String destor;
	private Date fecinitor;
	private Date fecfintor;
	private int topepre;
	private String logotor;
	private int punpreace;
	private int punmarloc;
	private int punmarvic;
	private String estadotor;
	
	
	
	public Torneo(String cedadmin, String nomtor, String destor, Date fecinitor, Date fecfintor, int topepre,
			String logotor, int punpreace, int punmarloc, int punmarvic, String estadotor) {
		super();
		this.cedadmin = cedadmin;
		this.nomtor = nomtor;
		this.destor = destor;
		this.fecinitor = fecinitor;
		this.fecfintor = fecfintor;
		this.topepre = topepre;
		this.logotor = logotor;
		this.punpreace = punpreace;
		this.punmarloc = punmarloc;
		this.punmarvic = punmarvic;
		this.estadotor = estadotor;
	}
	public Torneo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCedadmin() {
		return cedadmin;
	}
	public void setCedadmin(String cedadmin) {
		this.cedadmin = cedadmin;
	}
	public String getNomtor() {
		return nomtor;
	}
	public void setNomtor(String nomtor) {
		this.nomtor = nomtor;
	}
	public String getDestor() {
		return destor;
	}
	public void setDestor(String destor) {
		this.destor = destor;
	}
	public Date getFecinitor() {
		return fecinitor;
	}
	public void setFecinitor(Date fecinitor) {
		this.fecinitor = fecinitor;
	}
	public Date getFecfintor() {
		return fecfintor;
	}
	public void setFecfintor(Date fecfintor) {
		this.fecfintor = fecfintor;
	}
	public int getTopepre() {
		return topepre;
	}
	public void setTopepre(int topepre) {
		this.topepre = topepre;
	}
	public String getLogotor() {
		return logotor;
	}
	public void setLogotor(String logotor) {
		this.logotor = logotor;
	}
	public int getPunpreace() {
		return punpreace;
	}
	public void setPunpreace(int punpreace) {
		this.punpreace = punpreace;
	}
	public int getPunmarloc() {
		return punmarloc;
	}
	public void setPunmarloc(int punmarloc) {
		this.punmarloc = punmarloc;
	}
	public int getPunmarvic() {
		return punmarvic;
	}
	public void setPunmarvic(int punmarvic) {
		this.punmarvic = punmarvic;
	}
	public String getEstadotor() {
		return estadotor;
	}
	public void setEstadotor(String estadotor) {
		this.estadotor = estadotor;
	}
	
	
	
	
}	



