package quinielasocial.lab.controller;
import java.util.List;

import quinielasocial.lab.entity.Jugador;
import quinielasocial.lab.services.jugadorServicio;


public class ControladorGridJugadores {
	private jugadorServicio jugadorData = new jugadorServicio();

	public ControladorGridJugadores() {
		super();
	}

	public List<Jugador> getObtenerJugadores() {
		return jugadorData.getAllJugadores();
	}
}
