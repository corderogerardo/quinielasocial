package quinielasocial.lab.business.dao;

import quinielasocial.lab.conf.Sesion;
import quinielasocial.lab.domain.entity.Rol;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoRolImpl {
	
private Sesion sesionPostgres;
	
	public void agregarUsuario(Rol dato) throws Exception{
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
	public Rol obtenerUsuario(String id) throws Exception{
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();
		Rol dato = null;
		try{
			dato = (Rol) sesion.get(Rol.class, id);
		}catch(Exception e){
			e.printStackTrace();
			
			throw new Exception(e.getMessage(),e.getCause());
		}finally{
			sesion.close();
		}
		return dato;

	}
	public void actualizarUsuario(Rol dato) throws Exception{
		@SuppressWarnings("static-access")
		Session em = sesionPostgres.openSession();
		Transaction tx = null;
		try{
			tx= em.beginTransaction();
			em.update(dato);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
			throw e;
		}finally{
			em.close();
		}
	}
	public List<Rol> obtenerTodos() throws Exception{
		List<Rol> datos = new ArrayList<Rol>();
		Session em = sesionPostgres.openSession();
		try{
			datos = (List<Rol>) em.createCriteria(Rol.class).list();
		}catch (Exception e){
			throw new Exception(e.getMessage(), e.getCause());
		}finally{
			em.close();
		}
		return datos;
	}

}
