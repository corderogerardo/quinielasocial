package quinielasocial.lab.controller;
import quinielasocial.lab.business.services.*;
import java.util.List;

import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Persona;


public class ControladorGridJugadores {
	@WireVariable
	protected CRUDService serviciopersona = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciojugador = (CRUDService) SpringUtil.getBean("CRUDService");
	
	
	public ControladorGridJugadores() {
		super();
	}

	public List<Jugador> getObtenerJugadores() {
		return serviciojugador.getAll(Jugador.class);
	}
}
