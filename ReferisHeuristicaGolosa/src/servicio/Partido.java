package servicio;
import java.io.Serializable;
import java.util.LinkedList;

public class Partido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LinkedList<Equipo> equipos;
	private int arbitro;
	
	public Partido(Equipo local,Equipo visitante) {
		this.equipos=new LinkedList<Equipo>();
		this.equipos.add(local);
		this.equipos.addLast(visitante);
		this.arbitro=0;
	}
	public Equipo getLocal() {
		return equipos.get(0);
	}
	public Equipo getVisitante() {
		return equipos.get(1);
	}
	public void setArbitro(int arbitro) {
		this.arbitro = arbitro;
	}
	
	public int getArbitro() {
		return arbitro;
	}
	@Override
	public boolean equals(Object obj) {
		
		if(obj==null || this.getClass()!= obj.getClass()) {
			return false;
		}
		Partido otro= (Partido)obj;
		return ( equipos.get(0).equals(otro.equipos.get(0)) && equipos.get(1).equals(otro.equipos.get(1)) ) || ( equipos.get(1).equals(otro.equipos.get(0))&& equipos.get(0).equals(otro.equipos.get(1)) )  ;
	
	}
}
