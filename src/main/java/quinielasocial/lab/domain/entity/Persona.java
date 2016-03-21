package quinielasocial.lab.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "personas", schema="public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ID;
	@Column(name="cedula",unique=true)
	private String cedula;
	private String nombre;
	private String apellido;
	@Temporal(TemporalType.DATE)
	private Date fechanacimiento;
	@Column(name="correo",unique=true)
	private String correo;
	private String foto;
	
	public Persona(String cedula, String nombre, String apellido, Date fechanacimiento, String correo,
			String foto) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechanacimiento = fechanacimiento;
		this.correo = correo;
		this.foto = foto;
	}
	
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Date getFechanacimiento() {
		return fechanacimiento;
	}
	public void setFechanacimiento(Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
	}	
}
