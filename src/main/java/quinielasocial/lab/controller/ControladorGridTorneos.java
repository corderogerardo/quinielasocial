package quinielasocial.lab.controller;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;

import quinielasocial.lab.entity.Torneo;
import quinielasocial.lab.services.torneoServicio;;
public class ControladorGridTorneos {

		private torneoServicio torneoData = new torneoServicio();

		public ControladorGridTorneos() {
			super();
		}

		public List<Torneo> getObtenerTorneos() {
			return torneoData.getAllTorneos();
		}
	

	
	
}
