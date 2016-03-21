package quinielasocial.lab.business.services;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import quinielasocial.lab.business.dao.JugadorDaoImpl;
import quinielasocial.lab.business.dao.DaoUsuarioImpl;
import quinielasocial.lab.domain.entity.Jugador;
import quinielasocial.lab.domain.entity.Usuario;
public class JugadorServicio {
	// relacion de asociacion de la clase jugadorServicio con jugador, o algo parecido.
	private JugadorDaoImpl jugadorDao;
	private DaoUsuarioImpl usuarioDao;
	private List<Jugador> jugadores = new ArrayList<Jugador>();

		public JugadorServicio(){
			getAllJugadores();
		}
		
		
		public void agregarJugadores(Jugador jugador,Usuario usuario){
			try {
				jugadorDao.agregarJugador(jugador);
				usuarioDao.agregarUsuario(usuario);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		public List<Jugador> getAllJugadores() {
			try {
				jugadores = jugadorDao.obtenerTodos();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return jugadores;
		}
		
		public Jugador buscar(String palabraClave){
			Jugador jug = new Jugador();
			if (palabraClave!=null ||  palabraClave!=""){
				
				try {
					jug = jugadorDao.obtenerJugador(palabraClave);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return jug;			
		}

}