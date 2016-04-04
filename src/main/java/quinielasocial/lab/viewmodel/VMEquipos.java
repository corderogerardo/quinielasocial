package quinielasocial.lab.viewmodel;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Equipo;
import quinielasocial.lab.domain.entity.Torneo;
import quinielasocial.lab.domain.entity.Usuario;

public class VMEquipos {
	
	@WireVariable
	protected CRUDService servicio = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Equipo> equipos;
	private List<Equipo> equiposDeEseTorneo;
	private Equipo selected;
	private List<Equipo> noRepetido;
	
	Session session = Sessions.getCurrent();
	Torneo torneosesion = (Torneo) session.getAttribute("torneo");
	
	
	
	public VMEquipos() {
		super();
		equiposDeEseTorneo = servicio.getEquiposUnTorneo(Equipo.class, torneosesion.getTorneoId());
		equipos = servicio.getAll(Equipo.class);
	}

	private String nombreequipo, descripcionequipo;

	public String getNombreequipo() {
		return nombreequipo;
	}

	public void setNombreequipo(String nombreequipo) {
		this.nombreequipo = nombreequipo;
	}

	public String getDescripcionequipo() {
		return descripcionequipo;
	}

	public void setDescripcionequipo(String descripcionequipo) {
		this.descripcionequipo = descripcionequipo;
	}
	public String texto(Textbox text){
		return text.getValue().toString();
	}
	
	@Command
	@NotifyChange("message")
	public void guardarequipo(){
		
		noRepetido = servicio.getEquiposbyNombreyTorneo(Equipo.class, getNombreequipo(), torneosesion.getTorneoId());
		if(noRepetido.isEmpty()){
			Equipo newteam = new Equipo((long)equipos.size()+1, getNombreequipo(), getDescripcionequipo(), "/logo", torneosesion.getTorneoId());
			servicio.Save(newteam);
			Executions.getCurrent().sendRedirect("");
		}else{
			Messagebox.show("Ya has registrado ese equipo en el torneo","Informacion", Messagebox.OK,Messagebox.INFORMATION);
		}
	}//fin guardar equipo
	@Command
	@NotifyChange("message")
	public void finalizarequipo(){
		Executions.sendRedirect("sesionAgregarPartidos.zul");
	}
	//Metodos para cargar la vista
	public List<Equipo> getEquipoList(){
		return equiposDeEseTorneo;
	}

	public Equipo getSelectedEquipo() {
		return selected;
	}

	public void setSelectedEquipo(Equipo selected) {
		this.selected = selected;
	}
	
}
