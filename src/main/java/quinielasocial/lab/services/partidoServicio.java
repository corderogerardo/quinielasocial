package quinielasocial.lab.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import quinielasocial.lab.entity.Partido;

public class partidoServicio {
	
	//data model
		private List<Partido> listaPartido= new LinkedList<Partido>();
		private static int id = 1;
		//initialize book data
		public partidoServicio() {
			listaPartido.add(
					new Partido(id++,
							"30/06/15",
							"01:30",
							"estadio nacional",
							"Venezuela",
							"Chile",
							"1"));
			listaPartido.add(
					new Partido(id++, 
							"15/06/15",
							"08:00",
							"Estadio Monumental",
							"Ecuador",
							"Bolivia",
							"2"));
			listaPartido.add(
					new Partido(id++, 
							"16/06/15",
							"02:00",
							"Estadio ester Roa",
							"Chile",
							"Mexico",
							"3"));
			
			listaPartido.add(
					new Partido(id++, 
							"14/06/15",
							"16:00",
							"estadio la Portada",
							"Colombia",
							"Venezuela",
							"4"));
		}
			
		
		
		public List<Partido> findAll(){
			return listaPartido;
		}
		


}
