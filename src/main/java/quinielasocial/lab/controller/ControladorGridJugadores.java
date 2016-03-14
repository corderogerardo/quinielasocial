package quinielasocial.lab.controller;
import java.util.List;

import quinielasocial.lab.entity.Jugador;
import quinielasocial.lab.services.JugadorServicio;


public class ControladorGridJugadores {
	private JugadorServicio jugadorData = new JugadorServicio();

	public ControladorGridJugadores() {
		super();
	}

	public List<Jugador> getObtenerJugadores() {
		return jugadorData.getAllJugadores();
	}
}
