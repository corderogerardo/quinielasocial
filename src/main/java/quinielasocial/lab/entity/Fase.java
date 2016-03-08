package quinielasocial.lab.entity;

public class Fase {

		private String idfase;
		private String nombref;
		private String estado;
		private String idtorneo;

		
		public Fase(String idfase, String nombref, String estado, String idtorneo ) {
			super();
			this.idfase = idfase;
			this.nombref = nombref;
			this.estado = estado;
			this.idtorneo = idtorneo;
			
		}
		
		public Fase() {
			super();
	  }
		
		public String getIdfase() {
			return idfase;
		}


		public String getNombref() {
			return nombref;
		}


		public String getEstado() {
			return estado;
		}


		public String getIdtorneo() {
			return idtorneo;
		}
		
			
		public void setIdfase(String idfase) {
			this.idfase = idfase;
		}

		public void setNombref(String nombref) {
			this.nombref = nombref;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

			
		public void setIdtorneo(String idtorneo) {
			this.idtorneo = idtorneo;
		}

}	
