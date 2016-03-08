package quinielasocial.lab.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import quinielasocial.lab.entity.Torneo;
public class torneoServicio {
	private List<Torneo> torneos = new ArrayList<Torneo>();
	
	public torneoServicio(){
		torneos.add(new Torneo("Futbol","Copa America",ConvertirStringFecha("30/06/2016"),ConvertirStringFecha("30/07/2016"),12));
		torneos.add(new Torneo("Baloncesto","Torneo de las Americas",ConvertirStringFecha("01/07/2016"),ConvertirStringFecha("01/08/2016"),18));

	}
	
	
	public List<Torneo> getAllTorneos() {
		return torneos;
	}
	
	public void agregarJugador(String deporte, String nombre, Date fechaInicio, Date fechaFin, int cantParticipantes){
		torneos.add(new Torneo(deporte,nombre,fechaInicio,fechaFin,cantParticipantes));
	}
	

	
	public String ConvertirFechaString(Date fecha){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(fecha);
	}
	
	public Date ConvertirStringFecha(String fecha){
	/*	Date newdate=null;
        SimpleDateFormat dateformat2 = new SimpleDateFormat("dd/MM/yyyy");
        try {
            newdate = dateformat2.parse(fecha);
            return newdate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newdate;
        */
        
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha1 = null;
		try {

		fecha1 = formatoDelTexto.parse(fecha);

		} catch (ParseException ex) {

		ex.printStackTrace();

		}
		System.out.println(fecha1.toString());

		return fecha1;

	
        
	}
	
	public Torneo buscar(String palabraClave){
		if (palabraClave!=null ||  palabraClave!=""){
			for (Torneo e: torneos){
				if (e.getNombre().toLowerCase().contains(palabraClave.toLowerCase())){
					return e;
				}
			}
		}
		return torneos.get(0);
					
	}
	
	public List<Torneo> search(String palabraClave){
		List<Torneo> result = new LinkedList<Torneo>();
		if (palabraClave==null || "".equals(palabraClave)){
			result = torneos;
		}else{
			for (Torneo c: torneos){
				if (c.getNombre().toLowerCase().contains(palabraClave.toLowerCase())
					||c.getDeporte().toLowerCase().contains(palabraClave.toLowerCase())){
					result.add(c);
				}
			}
		}
		return result;
	}

	
}
