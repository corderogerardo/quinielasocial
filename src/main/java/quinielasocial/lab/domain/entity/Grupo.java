package quinielasocial.lab.domain.entity;


public class Grupo {

	private int idgrupo;
	private String nombreg;
	private String idpartido;

	
	public Grupo(int idgrupo, String nombreg, String idpartido ) {
		super();
		this.idgrupo = idgrupo;
		this.nombreg = nombreg;
		this.idpartido = idpartido;		
	}
	
	public Grupo() {
		super();
  }
	
	public int getIdgrupo() {
		return idgrupo;
	}


	public String getNombreg() {
		return nombreg;
	}


	public String getIdpartido() {
		return idpartido;
	}


			
	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public void setNombreg(String nombreg) {
		this.nombreg = nombreg;
	}

	public void setIdpartido(String idpartido) {
		this.idpartido = idpartido;
	}


	
}	
