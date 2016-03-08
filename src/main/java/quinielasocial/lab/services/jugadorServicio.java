package quinielasocial.lab.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import quinielasocial.lab.entity.Jugador;
public class jugadorServicio {
	private List<Jugador> jugadores = new ArrayList<Jugador>();

		public jugadorServicio(){
			jugadores.add(new Jugador("19450235","Pedro", "Ortiz", "player@gmail.com", "1234", "imagenes/fea.jgp",111,"player","habilitado"));
			jugadores.add(new Jugador("19450235","Maria", "Gomez", "mariag@gmail.com", "1234", "imagenes/fea.jgp",111,"player","habilitado"));
			jugadores.add(new Jugador("28750235","Jose", "Gomez", "admin@gmail.com", "admin", "imagenes/fea.jgp",111,"admin","habilitado"));
			jugadores.add(new Jugador("12312315","Juan", "Arango", "arango@gmail.com", "1234", "imagenes/gol.jgp",120,"player","habilitado"));
			jugadores.add(new Jugador("12315","Luis", "Figo", "figo@gmail.com", "1234", "imagenes/gol.jgp",109,"player","habilitado"));
			agregarJugador("585675","Francisco", "Franco", "franco@gmail.com", "1234", "imagenes/espana.jgp",115,"player","habilitado");
			Collections.sort(jugadores, new Comparator<Jugador>() {
				public int compare(Jugador j1, Jugador j2) {
					return new Integer(j2.getPuntaje()).compareTo(new Integer(j1.getPuntaje()));
			}
			
					});
		}
			
		public void agregarJugador(String ced, String nom, String Ape, String corr, String clav, String foto, int pto, String tip, String est){
			jugadores.add(new Jugador(ced, nom, Ape, corr, clav, foto, pto,tip,est));
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