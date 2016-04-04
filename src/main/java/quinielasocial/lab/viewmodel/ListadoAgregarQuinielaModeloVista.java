package quinielasocial.lab.viewmodel;

//import modelo.data.Carro;
//import modelo.servicio.IServicio;
//import modelo.servicio.Servicio;


import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.*;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.*;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Torneo;

public class ListadoAgregarQuinielaModeloVista extends SelectorComposer<Component> {

	private static final long serialVersionUID = 1L;
	@WireVariable
	protected CRUDService servicioListadoAgregarQuinielaModeloVista = (CRUDService) SpringUtil.getBean("CRUDService");


	public ListadoAgregarQuinielaModeloVista() {
		super();
	}


	@Wire
	private Textbox txtPalabraClave;
	@Wire
	private Listbox lstListaQuinielas;
	@Wire
	private Label lblModelo;
	@Wire
	private Label lblMarca;
	@Wire
	private Label lblPrecio;
	@Wire
	private Label lblDescripcion;
	@Wire
	private Image imgImagenPrevia;
	

	public List<Torneo> torneos = servicioListadoAgregarQuinielaModeloVista.getAll(Torneo.class);

//	private IServicio servicioCarro = new Servicio();
    public List<Torneo> getTorneoList() {
        return torneos;
    }

	
	@Listen("onClick = #btnBuscar")
	public void search(){
		Clients.showNotification("Lo sentimos :( La B�squeda No Produjo Resultados","ERROR",null,null,1500);

	}

	
}
