package quinielasocial.lab.controller;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Textbox;

public class ControladorUsuario extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;
	//wire components
		@Wire
		Textbox usuario;
		@Wire
		Textbox password;
		@Wire
		Label message;
}
