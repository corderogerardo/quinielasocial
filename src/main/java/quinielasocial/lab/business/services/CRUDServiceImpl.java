package quinielasocial.lab.business.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quinielasocial.lab.business.dao.CRUDDao;

@Service
public class CRUDServiceImpl implements CRUDService {

	@Autowired
	private CRUDDao CRUDDao;

	@Transactional(readOnly = true)
	public <T> List<T> getAll(Class<T> klass) {
		return CRUDDao.getTodos(klass);
	}
	
	@Transactional(readOnly = true)
	public <T> List<T> getEquiposUnTorneo(Class<T> klass,long id) {
		// TODO Auto-generated method stub
		return CRUDDao.getEquiposUnTorneo(klass,id);
	}

	@Transactional
	public <T> void Save(T klass) throws DataAccessException {
		CRUDDao.Save(klass);
	}

	@Transactional
	public <T> void delete(T klass) throws DataAccessException {
		CRUDDao.eliminar(klass);
	}

	@Transactional
	public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {
		return CRUDDao.GetUniqueEntityByNamedQuery(query, params);
	}

	@Transactional
	public <T> List<T> GetListByNamedQuery(String query, Object... params) {
		return CRUDDao.ObtenerNombrePorNombreQuery(query, params);
	}

	@Transactional(readOnly = true)
	public <T> Long getQueryCount(String query, Object... params) {
		return CRUDDao.getQueryCount(query, params);
	}

	@Transactional(readOnly = true)
	public <T> T findByPrimaryKey(Class<T> klass, Serializable id) {
		 return CRUDDao.encontrarPorId(klass, id);
	}
	@Transactional(readOnly = true)
	public <T> T findByEmail(Class<T> klass, String correo) {
		 return CRUDDao.encontrarPorId(klass, correo);
	}
	
	@Transactional(readOnly = true)
	public <T> List<T> getEquiposbyNombre(Class<T> klass,String id) {
		// TODO Auto-generated method stub
		return CRUDDao.getEquiposbyNombre(klass,id);
	}
	@Transactional(readOnly = true)
	public<T> List<T> getEquiposbyNombreyTorneo(Class<T> klass,String id, long id1 ) {
		// TODO Auto-generated method stub
		return CRUDDao.getEquiposbyNombreyTorneo(klass, id, id1);
	}
	@Transactional(readOnly = true)
	public <T> List<T> getPartidosUnTorneo(Class<T> klass,long id) {
		// TODO Auto-generated method stub
		return CRUDDao.getPartidosUnTorneo(klass,id);
	}
	
	@Transactional(readOnly = true)
	public <T> List<T> getUnTorneobyIdAdmin(Class<T> klass,String id) {
		// TODO Auto-generated method stub
		return CRUDDao.getUnTorneobyIdAdmin(klass,id);
	}
	
	@Transactional(readOnly = true)
	public <T> List<T> getJugadorTorneobyCedulaJugador(Class<T> klass,String id ) {
		// TODO Auto-generated method stub
		return CRUDDao.getJugadorTorneobyCedulaJugador(klass,id);
	}
	
	@Transactional(readOnly = true)
	public <T> List<T> getSolicitudesPendientes(Class<T> klass,String id ) {
		// TODO Auto-generated method stub
		return CRUDDao.getSolicitudesPendientes(klass,id);
	}

	@Transactional
	public <T> void Update(Class<T> klass,long id,String estado) throws DataAccessException {
		CRUDDao.Update(klass,id,estado);
	}

	
	
}
