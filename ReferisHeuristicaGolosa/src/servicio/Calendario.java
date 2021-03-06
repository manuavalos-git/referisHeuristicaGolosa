package servicio;

import java.io.Serializable;
import java.util.ArrayList;



public class Calendario implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Fecha> fechas;
	private ArrayList<Equipo> equipos;
	private ArrayList<Arbitro> arbitros;
	
	public Calendario(ArrayList<Equipo> equipos,ArrayList<Fecha> fechas) {
		if(!cumpleCondiciones(equipos, fechas)) {
			throw new IllegalArgumentException("La cantidad de equipos debe ser par ,mayor que 1,todos los equipos tienen que estar 1 vez por fecha");
		}
		this.equipos=equipos;
		this.fechas=fechas;
		this.arbitros=listaArbitros();
	}
	public Calendario() {
	
	}
	
	public ArrayList<Arbitro> copiaArbitros() {
		ArrayList<Arbitro> nueva=new ArrayList<Arbitro>();
		for (Arbitro arbitro : arbitros) {
			nueva.add(new Arbitro(arbitro.getEquipos().length,arbitro.getNombre()));
		}
		return nueva;
	}
	public ArrayList<Equipo> copiaEquipos() {
		ArrayList<Equipo> nueva=new ArrayList<Equipo>();
		for (Equipo equipo: equipos) {
			nueva.add(new Equipo(equipo.getNombre()));
		}
		return nueva;
	}
	public ArrayList<Fecha> copiaFechas() {
		ArrayList<Fecha> nueva=new ArrayList<Fecha>();
		for (Fecha fecha: fechas) {
			nueva.add(new Fecha(copiarPartidos(fecha.getPartidos())));
		}
		return nueva;
	}
	private ArrayList<Partido> copiarPartidos(ArrayList<Partido> partidos) {
		ArrayList<Partido> nueva=new ArrayList<Partido>();
		for (Partido partido : partidos) {
			nueva.add(new Partido(partido.getLocal(), partido.getVisitante()));
		}
		return nueva;
	}
	private ArrayList<Arbitro> listaArbitros() {
		ArrayList<Arbitro> nueva=new ArrayList<Arbitro>();
		if(equipos.size()>2) {	
			for(int i=1;i<=equipos.size()/2;i++) {
				nueva.add(new Arbitro(equipos.size(),i));
			}
		}	
		else {
			nueva.add(new Arbitro(equipos.size(),1));
			nueva.add(new Arbitro(equipos.size(),2));
		}
		return nueva;
	}
	private boolean cumpleCondiciones(ArrayList<Equipo> equipos,ArrayList<Fecha> fechas) {
		for(Equipo equipo: equipos) {
			int cont=0;
			for (Fecha fecha : fechas) {
				for(Partido partido:fecha.getPartidos()) {
					if(partido.getLocal().getNombre().equals(equipo.getNombre()) || partido.getVisitante().getNombre().equals(equipo.getNombre())) {
						cont+=1;
					}
				}
				
			}
			if(cont!=fechas.size()) {
				return false;
			}
		}	
		return equipos.size()==fechas.get(0).getPartidos().size()*2 && equipos.size()==fechas.size()+1;
	}
	
}
