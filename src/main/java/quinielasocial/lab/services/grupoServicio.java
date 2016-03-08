package quinielasocial.lab.services;

import java.util.LinkedList;
import java.util.List;

import quinielasocial.lab.entity.Grupo;

public class grupoServicio {
	
	//data model
		private List<Grupo> listaGrupo= new LinkedList<Grupo>();
		private static int id = 1;
		//initialize book data
		public grupoServicio() {
			listaGrupo.add(
					new Grupo(id++,
							"A",
							"1"));
			listaGrupo.add(
					new Grupo(id++,
							"B",
							"1"));
			listaGrupo.add(
					new Grupo(id++, 
							"C",
							"1"));
			
			listaGrupo.add(
					new Grupo(id++, 
							"D",
							"1"));
		}
			
		
		public List<Grupo> findAll(){
			return listaGrupo;
		}
		
		public List<Grupo> search(String palabraClave){
			List<Grupo> result = new LinkedList<Grupo>();
			if (palabraClave==null || "".equals(palabraClave)){
				result = listaGrupo;
			}else{
				for (Grupo c: listaGrupo){
					if (c.getNombreg().toLowerCase().contains(palabraClave.toLowerCase())){
						result.add(c);
					}
				}
			}
			return result;
		}

}
