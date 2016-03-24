package quinielasocial.lab.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;

public class ControladorBarraSesion extends SelectorComposer<Component> {
@Wire
private Button cerrarSesion;
@Wire
private Button inicio;

@Listen("onClick=#cerrarSesion; onOk=#barraSesion")
public void cerrarSesion(){
	Executions.sendRedirect("/index.zul");
	
}
@Listen("onClick=#inicio; onOk=#barraSesion")
public void irInicio(){
	Executions.sendRedirect("/indexSesion.zul");
	
}


}
