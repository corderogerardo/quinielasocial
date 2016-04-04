package quinielasocial.lab.business.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




import quinielasocial.lab.conf.Sesion;
import quinielasocial.lab.domain.entity.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;





import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class EquipoDAO {
	private Sesion sesionPostgres;
	Equipo eq;
	public void obtenerEquiposTorneo() throws Exception {            
		List<Equipo> datos1 = new ArrayList<Equipo>();  
	  Session em = sesionPostgres.openSession();  	
	  Query query = em.createQuery("SELECT p.nombre,p.descripcion FROM equipo p");
	   List<Object[]> listDatos = query.list();
	   for (Object[] datos : listDatos) {
	       System.out.println(datos[0] + "--" + datos[1]);
	   }

	}	
}
