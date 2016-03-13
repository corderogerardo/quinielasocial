package quinielasocial.lab.dao;


import quinielasocial.lab.conf.Sesion;
import quinielasocial.lab.entity.Persona;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoPersona {
	
	private Sesion sesionPostgres;
	
	public void agregarPersona(Persona dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();
		Transaction tx = null;
		try{
			tx = em.beginTransaction();
			em.save(dato);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			em.close();
		}
	}

}
