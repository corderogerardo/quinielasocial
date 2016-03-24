package quinielasocial.lab.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Mensaje;

public class ControladorMensajes {
	
	@WireVariable
	protected CRUDService serviciomensajes = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciojugador = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciousuario = (CRUDService) SpringUtil.getBean("CRUDService");
	@WireVariable
	protected CRUDService serviciorol = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Mensaje> mensajes;
	private Mensaje msg;
	
	private final List<String> listaMensajes = new ArrayList<String>();
	private List<Mensaje> todosLosMensajes = new ArrayList<Mensaje>();
	private int TOTAL_MENSAJES = 25;
	private Random randomGenerator = new Random();
	
	public ControladorMensajes() {

		}
	
	public List<Mensaje> getTodosLosMensajes() {
		return this.todosLosMensajes;
	}
		
	public List<String> getAvailableItems() {
		return listaMensajes;
	}
	
	private void generarMnesajes(){
		todosLosMensajes.add(null);

	}
		
		
		
	
}
