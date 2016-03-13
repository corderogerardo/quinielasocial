package quinielasocial.lab.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import quinielasocial.lab.entity.Jugador;
public class jugadorServicio {
	// relacion de asociacion de la clase jugadorServicio con jugador, o algo parecido.
	private List<Jugador> jugadores = new ArrayList<Jugador>();

		public jugadorServicio(){
			jugadores.add(new Jugador("19450235", "Pedro", "Ortiz", null, "player@gmail.com", "imagenes/fea.jgp", 111));
			jugadores.add(new Jugador("19450235", "Pedro", "Ortiz", null, "player@gmail.com", "imagenes/fea.jgp", 111));
			jugadores.add(new Jugador("19450235", "Pedro", "Ortiz", null, "player@gmail.com", "imagenes/fea.jgp", 111));
			
			agregarJugador("19450235", "Pedro", "Ortiz", null, "player@gmail.com", "imagenes/fea.jgp", 111);
			Collections.sort(jugadores, new Comparator<Jugador>() {
				public int compare(Jugador j1, Jugador j2) {
					return new Float(j2.getPuntaje()).compareTo(new Float(j1.getPuntaje()));
			}
			
					});
		}
			
		public void agregarJugador(String ced, String nom, String Ape, Date fechana, String correo, String foto, int pto){
			jugadores.add(new Jugador(ced, nom, Ape, fechana, correo, foto, pto));
		}
		
		public List<Jugador> getAllJugadores() {
			return jugadores;
		}
		
		public Jugador buscar(String palabraClave){
			if (palabraClave!=null ||  palabraClave!=""){
				for (Jugador e: jugadores){
					if (e.getNombre().toLowerCase().contains(palabraClave.toLowerCase())
						||e.getApellido().toLowerCase().contains(palabraClave.toLowerCase())){
						return e;
					}
				}
			}
			return jugadores.get(0);
						
		}

	

}