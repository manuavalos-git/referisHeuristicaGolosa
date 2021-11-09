package servicio;

import java.io.Serializable;

public class Equipo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre; 
	
	public Equipo(String nombre){
		this.nombre=nombre;
	}
	public String getNombre() {
		return this.nombre;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null || this.getClass()!= obj.getClass()) {
			return false;
		}
		Equipo otro= (Equipo)obj;
		return this.nombre.equals(otro.nombre);
	
	}
}
