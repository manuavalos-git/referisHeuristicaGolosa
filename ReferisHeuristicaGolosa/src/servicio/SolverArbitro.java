package servicio;
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
		this.fechas=calendario.copiaFechas();
	}
	//recorrre cada fecha y asigna arbitros a cada partido
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
}
