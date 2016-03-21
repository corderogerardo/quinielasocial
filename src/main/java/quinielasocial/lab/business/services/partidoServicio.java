package quinielasocial.lab.business.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import quinielasocial.lab.domain.entity.Partido;

public class partidoServicio {
	
	//data model
		private List<Partido> listaPartido= new LinkedList<Partido>();
		private static int id = 1;
		//initialize book data
		public partidoServicio() {
		
		}
			
		
		
		public List<Partido> findAll(){
			return listaPartido;
		}
		


}
