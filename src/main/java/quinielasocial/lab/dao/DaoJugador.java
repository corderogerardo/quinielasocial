package quinielasocial.lab.dao;

import quinielasocial.lab.conf.Sesion;
import quinielasocial.lab.entity.Jugador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaoJugador {
	
	private Sesion sesionPostgres;
	
	public void agregarJugador(Jugador dato) throws Exception{
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
	public Jugador obtenerJugador(String cedula) throws Exception{
		@SuppressWarnings("static-access")
		Session sesion = sesionPostgres.openSession();
		Jugador dato = null;
		try{
			dato = (Jugador) sesion.get(Jugador.class, cedula);
		}catch(Exception e){
			e.printStackTrace();
			
			throw new Exception(e.getMessage(),e.getCause());
		}finally{
			sesion.close();
		}
		return dato;

	}
	public void actualizarJugador(Jugador dato) throws Exception{
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
	public List<Jugador> obtenerTodos() throws Exception{
		List<Jugador> datos = new ArrayList<Jugador>();
		Session em = sesionPostgres.openSession();
		try{
			datos = (List<Jugador>) em.createCriteria(Jugador.class).list();
		}catch (Exception e){
			throw new Exception(e.getMessage(), e.getCause());
		}finally{
			em.close();
		}
		return datos;
	}

}
