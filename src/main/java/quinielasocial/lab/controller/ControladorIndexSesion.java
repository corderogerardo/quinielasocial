package quinielasocial.lab.controller;


import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Include;


public class ControladorIndexSesion extends SelectorComposer<Component>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Wire 
	private Include middle;
	
	@Wire
	private Button nuevo;
		
@Listen("onClick=#nuevo; onOk=#indexSesion")
public void ggg(){
	middle.setSrc("../registrarTorneo.zul");
	
}
}
