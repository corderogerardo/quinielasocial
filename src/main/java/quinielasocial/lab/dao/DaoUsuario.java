package quinielasocial.lab.dao;

import quinielasocial.lab.conf.Sesion;
import quinielasocial.lab.entity.Usuario;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoUsuario {
	
private Sesion sesionPostgres;
	
	public void agregarUsuario(Usuario dato) throws Exception{
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
	public Usuario obtenerUsuario(String correo) throws Exception{
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();
		Usuario dato = null;
		try{
			dato = (Usuario) sesion.get(Usuario.class, correo);
		}catch(Exception e){
			e.printStackTrace();
			
			throw new Exception(e.getMessage(),e.getCause());
		}finally{
			sesion.close();
		}
		return dato;

	}
	public void actualizarUsuario(Usuario dato) throws Exception{
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
	public List<Usuario> obtenerTodos() throws Exception{
		List<Usuario> datos = new ArrayList<Usuario>();
		Session em = sesionPostgres.openSession();
		try{
			datos = (List<Usuario>) em.createCriteria(Usuario.class).list();
		}catch (Exception e){
			throw new Exception(e.getMessage(), e.getCause());
		}finally{
			em.close();
		}
		return datos;
	}

}
