package quinielasocial.lab.domain.entity;

public class Mensaje {
	private String contenido;
	private String estadomsg;
	
	
	public Mensaje(String contenido, String estadomsg) {
		super();
		this.contenido = contenido;
		this.estadomsg = estadomsg;
	}
	public Mensaje() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public String getEstadomsg() {
		return estadomsg;
	}
	public void setEstadomsg(String estadomsg) {
		this.estadomsg = estadomsg;
	}
	
	
}
