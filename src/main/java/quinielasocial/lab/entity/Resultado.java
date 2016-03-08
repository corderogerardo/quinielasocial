package quinielasocial.lab.entity;

public class Resultado {
	
		private String idresultado;
		private Integer scorelocal;
		private Integer scorevisitante;
		private String idpartido;

		
		public Resultado(String idresultado, Integer scorelocal, Integer scorevisitante, String idpartido ) {
			super();
			this.idresultado = idresultado;
			this.scorelocal = scorelocal;
			this.scorevisitante = scorevisitante;
			this.idpartido = idpartido;
			
		}
		
		public Resultado() {
			super();
	  }
		
		public String getIdresltado() {
			return idresultado;
		}


		public Integer getScorelocal() {
			return scorelocal;
		}


		public Integer getScorevisitante() {
			return scorevisitante;
		}


		public String getIdpartido() {
			return idpartido;
		}
		
			
		public void setIdresultado(String idresultado) {
			this.idresultado = idresultado;
		}

		public void setScorelocal(int scorelocal) {
			this.scorelocal = scorelocal;
		}
			
		public void setScorevisitante(int scorevisitante) {
			this.scorevisitante = scorevisitante;
		}

}	

	

