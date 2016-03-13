package quinielasocial.lab.entity;


public class Equipo {

	private String nomequ;
	private String logoequ;
	private String descequ;
	
	public Equipo(String nomequ, String logoequ, String descequ) {
		super();
		this.nomequ = nomequ;
		this.logoequ = logoequ;
		this.descequ = descequ;
	}
	public Equipo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNomequ() {
		return nomequ;
	}
	public void setNomequ(String nomequ) {
		this.nomequ = nomequ;
	}
	public String getLogoequ() {
		return logoequ;
	}
	public void setLogoequ(String logoequ) {
		this.logoequ = logoequ;
	}
	public String getDescequ() {
		return descequ;
	}
	public void setDescequ(String descequ) {
		this.descequ = descequ;
	}
	
	
	
}	
