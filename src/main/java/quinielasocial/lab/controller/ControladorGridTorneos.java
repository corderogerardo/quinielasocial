package quinielasocial.lab.controller;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;

import quinielasocial.lab.business.services.torneoServicio;
import quinielasocial.lab.domain.entity.Torneo;;
public class ControladorGridTorneos {

		private torneoServicio torneoData = new torneoServicio();

		public ControladorGridTorneos() {
			super();
		}

		public List<Torneo> getObtenerTorneos() {
			return torneoData.getAllTorneos();
		}
	

	
	
}
