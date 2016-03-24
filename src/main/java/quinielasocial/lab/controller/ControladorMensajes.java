package quinielasocial.lab.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import modelo.*;
public class ControladorMensajes {
	private final List<String> listaMensajes = new ArrayList<String>();
	private List<Mensajes> todosLosMensajes = new ArrayList<Mensajes>();
	private int TOTAL_MENSAJES = 25;
	private Random randomGenerator = new Random();
	
	public ControladorMensajes() {

		}
	
	public List<Mensajes> getTodosLosMensajes() {
		return this.todosLosMensajes;
	}
		
	public List<String> getAvailableItems() {
		return listaMensajes;
	}
	
	private void generarMnesajes(){
		todosLosMensajes.add(null);

	}
		
		
		
	
}
