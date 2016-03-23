package quinielasocial.lab.controller;
import java.util.List;

import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Jugador;



public class ControladorGridJugadores {
	@WireVariable
	protected CRUDService serviciocrud = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private Jugador jugador;
	private List<Jugador> jugadores;

	public ControladorGridJugadores() {
		super();
	}

	public List<Jugador> getObtenerJugadores() {
		return jugadores=serviciocrud.getAll(Jugador.class);
	}
}
