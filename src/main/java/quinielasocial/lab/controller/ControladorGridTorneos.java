package quinielasocial.lab.controller;


import java.util.List;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;

public class ControladorGridTorneos {

//		private torneoServicio torneoData = new torneoServicio();
		@WireVariable
		protected CRUDService serviciotorneos = (CRUDService) SpringUtil.getBean("CRUDService");
		
		private List<Torneo> torneos;
		private Torneo torneo;

		public ControladorGridTorneos() {
			super();
			torneos = serviciotorneos.getAll(Torneo.class);
		}

		public List<Torneo> getObtenerTorneos() {
			return torneos;
		}
	

	
	
}
