package quinielasocial.lab.entity;

import java.util.Date;


public class Persona {
	private String cedula;
	private String nombre;
	private String apellido;
	private Date fechanacimiento;
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
