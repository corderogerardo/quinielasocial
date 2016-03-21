package quinielasocial.lab.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.ForeignKey;



@SuppressWarnings("deprecation")
@Entity
@Table(name = "usuarios", schema="public")
@ForeignKey(name="correo")
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	@Column(name="correo",unique=true)
	private String correo;
	private String clave;
	@Temporal(TemporalType.DATE)
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
