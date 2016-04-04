package quinielasocial.lab.business.services;

import java.io.Serializable;
import java.util.List;

public interface CRUDService {
	<T> List<T> getAll(Class<T> klass);
	
	

	<T> void Save(T klass);

	<T> T findByPrimaryKey(Class<T> klass, Serializable id);
	<T> T findByEmail(Class<T> klass, String email);

	<T> void delete(T klass);

	public <T> T GetUniqueEntityByNamedQuery(String query, Object... params);

	<T> List<T> GetListByNamedQuery(String query, Object... params);

	<T> Long getQueryCount(String query, Object... params);
	
	<T> List<T> getEquiposUnTorneo(Class<T> klass,long id );
	<T> List<T> getEquiposbyNombre(Class<T> klass,String id );
	<T> List<T> getEquiposbyNombreyTorneo(Class<T> klass,String id, long id1 );
	<T> List<T> getPartidosUnTorneo(Class<T> klass,long id );
	<T> List<T> getUnTorneobyIdAdmin(Class<T> klass,String id );
	<T> List<T> getJugadorTorneobyCedulaJugador(Class<T> klass,String id );
	<T> List<T> getSolicitudesPendientes(Class<T> klass,String id );
	<T> void Update(Class<T> klass,long id,String estado);
}
