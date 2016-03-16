package quinielasocial.lab.entity;

import java.io.Serializable;
import java.util.Date;




public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private String correo;
	private String clave;
	private Date fechaingreso;
	private boolean estado;
	private int idrol;
		
	public Usuario(String correo,String clave, Date fechaingreso, boolean estado, int idrol) {
		this.correo = correo;
		this.clave = clave;
		this.fechaingreso = fechaingreso;
		this.estado = estado;
		this.idrol = idrol;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
   
	
}
