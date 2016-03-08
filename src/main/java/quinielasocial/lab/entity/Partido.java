package quinielasocial.lab.entity;

import java.util.Date;


public class Partido {

	private int idpartido;
	private String fechaP;
	private String hora;
	private String lugar;
	private String idEquipLocal;
	private String idEquipVisitante;
	private String idfase;
	
	
	public Partido(int idpartido, String fechaP, String hora, String lugar, String idequilocal, String idequivisitante, String idfase ) {
		super();
		this.idpartido = idpartido;
		this.fechaP = fechaP;
		this.hora = hora;
		this.lugar = lugar;
		this.idEquipLocal = idequilocal;
		this.idEquipVisitante = idequivisitante;
		this.idfase = idfase;
	
	}
	
	public Partido() {
		super();
  }
	public int getIdpartido() {
		return idpartido;
	}
	
	public String getFechaP() {
		return fechaP;
	}


	public String getHora() {
		return hora;
	}


	public String getLugar() {
		return lugar;
	}



	public String getIdfase() {
		return idfase;
	}
	
	public String getIdEquipLocal() {
		return idEquipLocal;
	}

	public void setIdEquipLocal(String idEquipLocal) {
		this.idEquipLocal = idEquipLocal;
	}

	public String getIdEquipVisitante() {
		return idEquipVisitante;
	}

	public void setIdEquipVisitante(String idEquipVisitante) {
		this.idEquipVisitante = idEquipVisitante;
	}
	
	
	public void setIdpartido(int idpartido) {
		this.idpartido = idpartido;
	}

	public void setFechaP(String fechaP) {
		this.fechaP = fechaP;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	

	public void setIdfase(String idfase) {
		this.idfase = idfase;
	}
	
	
}	

	

