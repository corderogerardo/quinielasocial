package quinielasocial.lab.controller;
import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Torneo;



public class ControladorGridTorneos {

		@WireVariable
		protected CRUDService serviciocrud = (CRUDService) SpringUtil.getBean("CRUDService");
	

		public ControladorGridTorneos() {
			super();
		}

		public List<Torneo> getObtenerTorneos() {
			return serviciocrud.getAll(Torneo.class);
		}
	

	
	
}
