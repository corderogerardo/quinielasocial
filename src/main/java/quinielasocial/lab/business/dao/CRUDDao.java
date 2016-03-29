package quinielasocial.lab.business.dao;

import java.io.Serializable;
import java.util.List;

public interface CRUDDao {
	
	<T> List<T> getTodos(Class<T> klass);
	
	<T> List<T> getEquiposUnTorneo(Class<T> klass,long id );
	
	<T> void Save(T klass);
	
	<T> T encontrarPorId(Class<T> klass, Serializable id);
	<T> T encontrarPorCorreo(Class<T> klass, String correo); 
	
	<T> T GetUniqueEntityByNamedQuery(String query, Object... params);
	
	<T> List<T> ObtenerNombrePorNombreQuery(String query, Object... params);
	
	<T> void eliminar(T klass);
	
	<T> Long getQueryCount(String query, Object... params);


}
