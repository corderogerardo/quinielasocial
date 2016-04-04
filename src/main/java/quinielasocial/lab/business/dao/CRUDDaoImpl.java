package quinielasocial.lab.business.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public class CRUDDaoImpl implements CRUDDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getTodos(Class<T> klass){
		return getCurrentSession().createQuery("from "+klass.getName())
				.list();
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> getEquiposUnTorneo(Class<T> klass,long id ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where torneoid = "+id);
		return query.list();
	}
	protected final Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	public <T> void Save(T klass) throws DataAccessException {
		getCurrentSession().saveOrUpdate(klass);
		
	}
	public <T> void eliminar(T klass) throws DataAccessException {
		getCurrentSession().delete(klass);
	}
	@SuppressWarnings("unchecked")
	public <T> T encontrarPorId(Class<T> klass, Serializable id) {
		return (T) getCurrentSession().get(klass, id);
	}
	@SuppressWarnings("unchecked")
	public <T> T encontrarPorCorreo(Class<T> klass, String correo) {
		return (T) getCurrentSession().get(klass, correo);
	}
	
	@SuppressWarnings("unchecked")
	public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {

		Query q = getCurrentSession().getNamedQuery(query);

		int i = 1;
		String arg = "arg";
		for (Object o : params) {
			q.setParameter(arg + i, o);
			i++;
		}

		List<T> results = q.list();

		T foundentity = null;
		if (!results.isEmpty()) {
			// ignores multiple results
			foundentity = results.get(0);
		}
		return foundentity;
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> ObtenerNombrePorNombreQuery(String query, Object... params) {
		// TODO Auto-generated method stub
		Query q = getCurrentSession().getNamedQuery(query);

		int i = 1;
		String arg = "arg";
		if (params != null) {
			for (Object o : params) {
				if (o != null) {
					q.setParameter(arg + i, o);
					i++;
				}
			}
		}

		List<T> list = (List<T>) q.list();
		return list;
	}



	public <T> Long getQueryCount(String query, Object... params) {
		// TODO Auto-generated method stub
		Query q = getCurrentSession().getNamedQuery(query);
		int i = 1;
		String arg = "arg";
		Long count = (long) 0;

		if (params != null) {
			for (Object o : params) {
				if (o != null) {
					q.setParameter(arg + i, o);
					i++;
				}
			}
		}
		count = (Long) q.uniqueResult();
		return count;
	}

	
	@SuppressWarnings("unchecked")
	public<T> List<T> getEquiposbyNombre(Class<T> klass,String id ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where nombre = :id");
		query.setParameter("id", id);
		return query.list();

	}

	
	
	@SuppressWarnings("unchecked")
	public<T> List<T> getEquiposbyNombreyTorneo(Class<T> klass,String id, long id1 ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where nombre = :id and torneoid = :id1");
		query.setParameter("id", id);
		query.setParameter("id1", id1);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> getPartidosUnTorneo(Class<T> klass,long id ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where idtor = "+id);
		return query.list();
	}
	
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getUnTorneobyIdAdmin(Class<T> klass,String id ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where cedula_administrador = :id");
		query.setParameter("id", id);
		return query.list();
	}
	@SuppressWarnings("unchecked")
	public <T> List<T> getJugadorTorneobyCedulaJugador(Class<T> klass,String id ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where cedulajugador = :id");
		query.setParameter("id", id);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> getSolicitudesPendientes(Class<T> klass,String id ){
		Query query = getCurrentSession().createQuery("from "+ klass.getName()+ " where estado = :id");
		query.setParameter("id", "PENDIENTE");
		return query.list();
	}

	public <T> void Update(Class<T> klass,long id,String estado) {
		Query query = getCurrentSession().createQuery("update "+ klass.getName()+" set estado = :estado" +
				" where jugadortorneo_id = :codigo");
		query.setParameter("estado", estado);
		query.setParameter("codigo", id);
		query.executeUpdate();
	}
	
}
