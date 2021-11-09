package servicio;

import java.io.Serializable;
import java.util.ArrayList;

public class Fecha implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Partido> partidos;
	
	public Fecha(ArrayList<Partido> partidos) {
		this.partidos=partidos;
	}
	public ArrayList<Partido> getPartidos() {
		return partidos;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null || this.getClass()!= obj.getClass()) {
			return false;
		}
		Fecha otro= (Fecha)obj;
		for(Partido p:this.partidos) {
			if(!otro.partidos.contains(p)) {
				return false;
			}
		}
		return this.partidos.size()==otro.partidos.size();
	
	}
}
