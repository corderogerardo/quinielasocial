package quinielasocial.lab.viewmodel;

import java.util.List;

import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.SpringUtil;

import quinielasocial.lab.business.services.CRUDService;
import quinielasocial.lab.domain.entity.Equipo;

public class VMEquipos {
	
	@WireVariable
	protected CRUDService servicio = (CRUDService) SpringUtil.getBean("CRUDService");
	
	private List<Equipo> equipos;
	private List<Equipo> equiposDeEseTorneo;
	private Equipo selected;
	private List<Equipo> noRepetido;

}
