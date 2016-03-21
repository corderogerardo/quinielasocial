package quinielasocial.lab.controller;
import java.util.List;

import quinielasocial.lab.business.services.JugadorServicio;
import quinielasocial.lab.domain.entity.Jugador;


public class ControladorGridJugadores {
	private JugadorServicio jugadorData = new JugadorServicio();

	public ControladorGridJugadores() {
		super();
	}

	public List<Jugador> getObtenerJugadores() {
		return jugadorData.getAllJugadores();
	}
}
