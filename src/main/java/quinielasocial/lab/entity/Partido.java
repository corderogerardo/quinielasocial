package quinielasocial.lab.entity;

import java.util.Date;


public class Partido {

	//idpar en el archivo de mapeo de hibernate, en la tabla, cuando es autoincrement no es necesario colocarlo aca, ya que no es un dato que se escribe.
	// en el dao cuando insertas de hecho no es necesario especificarlo, tener en mente que el DAO y el atributo a guardar en la tabla.
	//idtor, idequloc, idequvis son claves foraneas aqui, claves primarias en sus respectivas tablas.
	private int idtor;
	private int idequloc;
	private int idequvis;
	private String lugpar;
	private Date fecpar;
	private int resequloc;
	private int resequvis;
	private String estadopar;
		
	
	public Partido(int idtor, int idequloc, int idequvis, String lugpar, Date fecpar, int resequloc, int resequvis,
			String estadopar) {
		super();
		this.idtor = idtor;
		this.idequloc = idequloc;
		this.idequvis = idequvis;
		this.lugpar = lugpar;
		this.fecpar = fecpar;
		this.resequloc = resequloc;
		this.resequvis = resequvis;
		this.estadopar = estadopar;
	}

	public Partido() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdtor() {
		return idtor;
	}
	public void setIdtor(int idtor) {
		this.idtor = idtor;
	}
	public int getIdequloc() {
		return idequloc;
	}
	public void setIdequloc(int idequloc) {
		this.idequloc = idequloc;
	}
	public int getIdequvis() {
		return idequvis;
	}
	public void setIdequvis(int idequvis) {
		this.idequvis = idequvis;
	}
	public String getLupar() {
		return lugpar;
	}
	public void setLupar(String lugpar) {
		this.lugpar = lugpar;
	}
	public Date getFecpar() {
		return fecpar;
	}
	public void setFecpar(Date fecpar) {
		this.fecpar = fecpar;
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
	public String getEstadopar() {
		return estadopar;
	}
	public void setEstadopar(String estadopar) {
		this.estadopar = estadopar;
	}
	
	
	
	
	
}	

	

