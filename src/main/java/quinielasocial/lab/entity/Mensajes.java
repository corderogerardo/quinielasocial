package quinielasocial.lab.entity;

public class Mensajes {
	private String idRemitente;
	private String idDestinatario;
	private String mensaje;
	private String estado;
	
	public Mensajes(String idRemitente, String idDestinatario, String mensaje,
			String estado) {
		super();
		this.idRemitente = idRemitente;
		this.idDestinatario = idDestinatario;
		this.mensaje = mensaje;
		this.estado = estado;
	}
	public Mensajes() {
		super();
  }
	
	
	public String getIdRemitente() {
		return idRemitente;
	}
	public void setIdRemitente(String idRemitente) {
		this.idRemitente = idRemitente;
	}
	public String getIdDestinatario() {
		return idDestinatario;
	}
	public void setIdDestinatario(String idDestinatario) {
		this.idDestinatario = idDestinatario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
