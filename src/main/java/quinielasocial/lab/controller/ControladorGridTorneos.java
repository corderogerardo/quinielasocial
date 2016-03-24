package quinielasocial.lab.controller;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;
import quinielasocial.lab.domain.entity.Rol;
import quinielasocial.lab.domain.entity.Usuario;

import java.util.List;

import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.domain.entity.Torneo;

public class ControladorGridTorneos {

	@WireVariable
	protected CRUDService serviciotorneo = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Torneo> torneos;

		public ControladorGridTorneos() {
			super();
		}

		public List<Torneo> getObtenerTorneos() {
			return serviciotorneo.getAll(Torneo.class);
		}
	

	
	
}
