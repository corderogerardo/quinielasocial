package quinielasocial.lab.controller;
import servicio.jugadorServicio;
import java.util.List;

import modelo.Jugador;


public class ControladorGridJugadores {
	private jugadorServicio jugadorData = new jugadorServicio();

	public ControladorGridJugadores() {
		super();
	}

	public List<Jugador> getObtenerJugadores() {
		return jugadorData.getAllJugadores();
	}
}
