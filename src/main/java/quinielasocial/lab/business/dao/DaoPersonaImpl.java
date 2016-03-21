package quinielasocial.lab.business.dao;


import quinielasocial.lab.conf.Sesion;
import quinielasocial.lab.domain.entity.Persona;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class DaoPersonaImpl {
	
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
	public Persona obtenerPersona(String cedula) throws Exception{
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();
		Persona dato = null;
		try{
			dato = (Persona) sesion.get(Persona.class, cedula);
		}catch(Exception e){
			e.printStackTrace();
			
			throw new Exception(e.getMessage(),e.getCause());
		}finally{
			sesion.close();
		}
		return dato;

	}
	public void actualizarPersona(Persona dato) throws Exception{
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
	public List<Persona> obtenerTodos() throws Exception{
		List<Persona> datos = new ArrayList<Persona>();
		Session em = sesionPostgres.openSession();
		try{
			datos = (List<Persona>) em.createCriteria(Persona.class).list();
		}catch (Exception e){
			throw new Exception(e.getMessage(), e.getCause());
		}finally{
			em.close();
		}
		return datos;
	}
}
