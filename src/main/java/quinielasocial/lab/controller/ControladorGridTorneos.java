package quinielasocial.lab.controller;
import servicio.torneoServicio;
import java.util.List;

import modelo.Torneo;;
public class ControladorGridTorneos {

		private torneoServicio torneoData = new torneoServicio();

		public ControladorGridTorneos() {
			super();
		}

		public List<Torneo> getObtenerTorneos() {
			return torneoData.getAllTorneos();
		}
	

	
	
}
