package servicio;

import java.io.Serializable;

public class Arbitro implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[] equipos;
	private int nombre;
	
	public Arbitro(int canEquipos,int nombre)
	{
		this.nombre=nombre;
		this.equipos= new int[canEquipos];
	}
	public void sumarPartido(int local,int visitante) {
		equipos[local]+=1;
		equipos[visitante]+=1;
	}
	public int getNombre() {
		return nombre;
	}
	public int[] getEquipos() {
		return equipos;
	}
	
}
