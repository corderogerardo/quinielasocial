package quinielasocial.lab.business.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import quinielasocial.lab.business.dao.CRUDDao;

@Service
public class CRUDServicioImpl implements CRUDServicio {
	
	@Autowired
	private CRUDDao cruddao;
	
	@Transactional(readOnly = true)
	public <T> List<T> getTodos(Class<T> klass) {
		// TODO Auto-generated method stub
		return cruddao.getTodos(klass);
	}
	
	@Transactional
	public <T> void Save(T klass) {
		// TODO Auto-generated method stub
		cruddao.Save(klass);
	}
	public <T> void eliminar(T klass) {
		// TODO Auto-generated method stub
		cruddao.eliminar(klass);
	}

	public <T> T encontrarPorId(Class<T> klass, Serializable id) {
		// TODO Auto-generated method stub
		return cruddao.encontrarPorId(klass, id);
	}

	public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {
		// TODO Auto-generated method stub
		return cruddao.GetUniqueEntityByNamedQuery(query, params);
	}

	public <T> List<T> ObtenerNombrePorNombreQuery(String query, Object... params) {
		// TODO Auto-generated method stub
		return cruddao.ObtenerNombrePorNombreQuery(query, params);
	}

	public <T> Long getQueryCount(String query, Object... params) {
		// TODO Auto-generated method stub
		return cruddao.getQueryCount(query, params);
	}

}
