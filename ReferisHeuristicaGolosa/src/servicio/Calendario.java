package servicio;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
		if(!(equipos.size()%2 ==0) && equipos.size()>0 ) {
			throw new IllegalArgumentException("La cantidad de equipos debe ser par y mayor que 1");
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
			nueva.add(arbitro);
		}
		return nueva;
	}
	public ArrayList<Equipo> copiaEquipos() {
		ArrayList<Equipo> nueva=new ArrayList<Equipo>();
		for (Equipo equipo: equipos) {
			nueva.add(equipo);
		}
		return nueva;
	}
	public ArrayList<Fecha> copiaFechas() {
		ArrayList<Fecha> nueva=new ArrayList<Fecha>();
		for (Fecha fecha: fechas) {
			nueva.add(fecha);
		}
		return nueva;
	}
	public void serializar(String nombreArchTxt){
		try // Debe estar en un try/catch
		{
		 FileOutputStream fos = new FileOutputStream(nombreArchTxt);
		 ObjectOutputStream out = new ObjectOutputStream(fos);
		 out.writeObject(this);
		 out.close();
		}
		catch (Exception ex)
		{
		ex.printStackTrace();
		}

	}
	//	private ArrayList<Fecha> generarFechas() {
//		ArrayList<Partido> partidosTotal=generarPartidos();
//		ArrayList<Fecha> fechas=new ArrayList<Fecha>();
//		for(int i=0;i<equipos.size()-1;i++) {
//			fechas.add(new Fecha(generarFecha(partidosTotal)));
//		}
//		return fechas;
//	}
//	
//	private ArrayList<Partido> generarFecha(ArrayList<Partido> partidosTotal) {
//		ArrayList<Partido> nueva=new ArrayList<Partido>();
//		ArrayList<Partido> guia=new ArrayList<Partido>();;
//		for (int i=0;i<equipos.size()/2;i++){
//			for (int j=0;j<partidosTotal.size();j++) {
//				if(!guia.contains(partidosTotal.get(j))&& noUsadosEnEstaFecha(partidosTotal.get(j).getLocal().getNombre(),partidosTotal.get(j).getVisitante().getNombre(),guia)) {
//					nueva.add(partidosTotal.get(j));
//					guia.add(partidosTotal.get(j));
//					j=partidosTotal.size();
//				}
//			}
//		}
//		for (Partido p: guia) {
//			partidosTotal.remove(p);
//		}
//		return nueva;
//	}
//	private boolean noUsadosEnEstaFecha(String nombre, String nombre2, ArrayList<Partido> guia) {
//		for (Partido partido : guia) {
//			if(partido.getLocal().getNombre().equals(nombre)||partido.getLocal().getNombre().equals(nombre2)||partido.getVisitante().getNombre().equals(nombre)|| partido.getVisitante().getNombre().equals(nombre2)) {
//				return false;
//			}
//		}
//		return true;
//	}
//	private ArrayList<Partido> generarPartidos() {
//		ArrayList<Partido> partidos=new ArrayList<Partido>();
//		for(int i=0;i<equipos.size();i++) {
//			for (int j=0;j<equipos.size();j++) {
//				if(i!=j) {
//					Partido nueva=new Partido(equipos.get(i),equipos.get(j));
//					if(!(partidos.contains(nueva))) {
//						partidos.add(nueva);
//					}
//				}
//			}
//		}
//		return partidos;
//	}
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
	
}
