package servicio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SolverArbitro
{
	private ArrayList<Equipo> equipos;
	private ArrayList<Fecha> fechas ;
	private ArrayList<Arbitro> arbitros;
	
	public SolverArbitro(Calendario calendario)
	{
		this.arbitros=calendario.copiaArbitros();
		this.equipos=calendario.copiaEquipos();
		this.fechas= calendario.copiaFechas();
	}
	
	public ArrayList<Fecha> resolver()
	{
		for(int i=0;i<fechas.size();i++)
		{
			resolverFecha(fechas.get(i));
		}
		return this.fechas;
	}
	private void resolverFecha(Fecha fecha)
	{
		int indiceLocal=conocerIndice(fecha.getPartidos().get(0).getLocal().getNombre());
		int indiceVisitante=conocerIndice(fecha.getPartidos().get(0).getVisitante().getNombre());
		ArrayList<Arbitro> ordenados=arbitrosOrdenados(indiceLocal,indiceVisitante);
		for(int i=0;i<ordenados.size();i++)
		{
			int nombre=ordenados.get(i).getNombre();
			agregarPartidoArbitrado(nombre,conocerIndice(fecha.getPartidos().get(i).getLocal().getNombre()),conocerIndice(fecha.getPartidos().get(i).getVisitante().getNombre()));
			fecha.getPartidos().get(i).setArbitro(nombre);
		}
	}
	
	private void agregarPartidoArbitrado(int nombre, int indiceLocal, int indiceVisitante) {
		for (Arbitro arbitro : arbitros) {
			if(arbitro.getNombre()==(nombre)) {
				arbitro.sumarPartido(indiceLocal,indiceVisitante);
			}
		}
	}

	private int conocerIndice(String nombre) {
		for(int i=0;i<equipos.size();i++) {
			if(equipos.get(i).getNombre().equals(nombre)) {
				return i;
			}
		}
		return -1;
	}

	private ArrayList<Arbitro> arbitrosOrdenados(int indiceLocal,int indiceVisitante)
	{
		ArrayList<Arbitro> ordenados =this.arbitros;
		Collections.sort(ordenados,new Comparator<Arbitro>() {

			@Override
			public int compare(Arbitro a1, Arbitro a2) {
				double promedioA1=(a1.getEquipos()[indiceLocal]+a1.getEquipos()[indiceVisitante])/2;
				double promedioA2=(a2.getEquipos()[indiceLocal]+a2.getEquipos()[indiceVisitante])/2;
				
				if( promedioA1 > promedioA2 )
					return 1;
				else if( promedioA1 == promedioA2 )
					return 0;
				else
					return -1;
			}
		});
		
		return ordenados;
	}
	public static Calendario leerSerializado(String ubicacion) {
		Calendario calen=new Calendario();
		try 
		{
		FileInputStream fis = new FileInputStream(ubicacion);
		ObjectInputStream in = new ObjectInputStream(fis);
		
		calen= (Calendario) in.readObject();
		
		in.close();
		}
		catch (Exception ex) { 
			
		}
		return calen;
	}
//	public static void main(String[]args) {
//		ArrayList<Equipo> equipos= new ArrayList<Equipo>();
//	//	klacnlk
//		String c="Chelsea";
//		String mc="Manchester City";
//		String we="West Ham";
//		String l="Liverpool";
//		String a="Arsenal";
//		String mu="Manchester United";
//		String b="Brighton";
//		String wo="Wolves";
//		String t="Tottenham";
//		String e="Everton";
//		
//		equipos.add(new Equipo(c));
//		equipos.add(new Equipo(mc));
//		equipos.add(new Equipo(we));
//		equipos.add(new Equipo(l));
//		equipos.add(new Equipo(a));
//		equipos.add(new Equipo(mu));
//		equipos.add(new Equipo(b));
//		equipos.add(new Equipo(wo));
//		equipos.add(new Equipo(t));
//		equipos.add(new Equipo(e));
//		
//		ArrayList<Fecha> fechas= new ArrayList<Fecha>();
//		
//		ArrayList<Partido> partidos1=new ArrayList<Partido>();
//		partidos1.add(new Partido(new Equipo(c),new Equipo(wo)));
//		partidos1.add(new Partido(new Equipo(mc),new Equipo(we)));
//		partidos1.add(new Partido(new Equipo(l), new Equipo(b)));
//		partidos1.add(new Partido(new Equipo(a), new Equipo(mu)));
//		partidos1.add(new Partido(new Equipo(e), new Equipo(t)));
//		fechas.add(new Fecha(partidos1));
//		
//		ArrayList<Partido> partidos2=new ArrayList<Partido>();
//		partidos2.add(new Partido(new Equipo(we),new Equipo(c)));
//		partidos2.add(new Partido(new Equipo(mu),new Equipo(e)));
//		partidos2.add(new Partido(new Equipo(b), new Equipo(a)));
//		partidos2.add(new Partido(new Equipo(wo), new Equipo(l)));
//		partidos2.add(new Partido(new Equipo(t), new Equipo(mc)));
//		fechas.add(new Fecha(partidos2));
//		
//		ArrayList<Partido> partidos3=new ArrayList<Partido>();
//		partidos3.add(new Partido(new Equipo(c),new Equipo(t)));
//		partidos3.add(new Partido(new Equipo(mc),new Equipo(mu)));
//		partidos3.add(new Partido(new Equipo(l), new Equipo(we)));
//		partidos3.add(new Partido(new Equipo(wo), new Equipo(b)));
//		partidos3.add(new Partido(new Equipo(e), new Equipo(a)));
//		fechas.add(new Fecha(partidos3));
//		
//		ArrayList<Partido> partidos4=new ArrayList<Partido>();
//		partidos4.add(new Partido(new Equipo(we),new Equipo(wo)));
//		partidos4.add(new Partido(new Equipo(a),new Equipo(mc)));
//		partidos4.add(new Partido(new Equipo(mu), new Equipo(c)));
//		partidos4.add(new Partido(new Equipo(b), new Equipo(e)));
//		partidos4.add(new Partido(new Equipo(t), new Equipo(l)));
//		fechas.add(new Fecha(partidos4));
//		
//		ArrayList<Partido> partidos5=new ArrayList<Partido>();
//		partidos5.add(new Partido(new Equipo(c),new Equipo(a)));
//		partidos5.add(new Partido(new Equipo(mc),new Equipo(e)));
//		partidos5.add(new Partido(new Equipo(we), new Equipo(b)));
//		partidos5.add(new Partido(new Equipo(l), new Equipo(mu)));
//		partidos5.add(new Partido(new Equipo(wo), new Equipo(t)));
//		fechas.add(new Fecha(partidos5));
//		
//		ArrayList<Partido> partidos6=new ArrayList<Partido>();
//		partidos6.add(new Partido(new Equipo(a),new Equipo(l)));
//		partidos6.add(new Partido(new Equipo(mu),new Equipo(wo)));
//		partidos6.add(new Partido(new Equipo(b), new Equipo(mc)));
//		partidos6.add(new Partido(new Equipo(t), new Equipo(we)));
//		partidos6.add(new Partido(new Equipo(e), new Equipo(c)));
//		fechas.add(new Fecha(partidos6));
//		
//		ArrayList<Partido> partidos7=new ArrayList<Partido>();
//		partidos7.add(new Partido(new Equipo(c),new Equipo(mc)));
//		partidos7.add(new Partido(new Equipo(we),new Equipo(mu)));
//		partidos7.add(new Partido(new Equipo(l), new Equipo(e)));
//		partidos7.add(new Partido(new Equipo(wo), new Equipo(a)));
//		partidos7.add(new Partido(new Equipo(t), new Equipo(b)));
//		fechas.add(new Fecha(partidos7));
//		
//		ArrayList<Partido> partidos8=new ArrayList<Partido>();
//		partidos8.add(new Partido(new Equipo(c),new Equipo(b)));
//		partidos8.add(new Partido(new Equipo(mc),new Equipo(l)));
//		partidos8.add(new Partido(new Equipo(a), new Equipo(we)));
//		partidos8.add(new Partido(new Equipo(mu), new Equipo(t)));
//		partidos8.add(new Partido(new Equipo(e), new Equipo(wo)));
//		fechas.add(new Fecha(partidos8));
//		
//		ArrayList<Partido> partidos9=new ArrayList<Partido>();
//		partidos9.add(new Partido(new Equipo(we),new Equipo(e)));
//		partidos9.add(new Partido(new Equipo(l),new Equipo(c)));
//		partidos9.add(new Partido(new Equipo(b), new Equipo(mu)));
//		partidos9.add(new Partido(new Equipo(wo), new Equipo(mc)));
//		partidos9.add(new Partido(new Equipo(t), new Equipo(a)));
//		fechas.add(new Fecha(partidos9));
//		
//		Calendario calendario=new Calendario(equipos,fechas);
//		
//	//	calendario.serializar("C:\\Users\\alumno\\git\\referisGolosos\\ReferisGolosos\\src\\servicio\\calendarioTorneoArgentina.ddr");
//		calendario.serializar("C:\\Users\\alumno\\git\\referisGolosos\\ReferisGolosos\\src\\servicio\\calendarioPremierLeague.ddr");
////		SolverArbitro solver=new SolverArbitro(leerSerializado("C:\\Users\\alumno\\git\\referisGolosos\\ReferisGolosos\\src\\servicio\\calendarioTorneoArgentina.ddr"));
//		SolverArbitro solver=new SolverArbitro(calendario);
//		ArrayList<Fecha> fec=solver.resolver();
//		int i=1;
//		for (Fecha fecha : fec) {
//			System.out.print("fecha nuemero:"+i+"\n\n");
//			for (Partido  p: fecha.getPartidos()) {
//				System.out.print("Local:"+ p.getLocal().getNombre()+"\n");
//				System.out.print("Arbitro____:"+ p.getArbitro()+"\n");
//				System.out.print("Visitante:"+ p.getVisitante().getNombre()+"\n\n");
//			}
//			i++;
//			System.out.print("___________________________\n");
//		}
//	}
}
