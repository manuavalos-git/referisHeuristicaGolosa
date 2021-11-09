package servicio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

public class Assert
{
	
	public static void todosCeros(Calendario calendario)
	{
		boolean todosCeros=true;
		for (Fecha fecha : calendario.copiaFechas()) {
			for (Partido partido : fecha.getPartidos()) {
				if(partido.getArbitro()!=0) {
					todosCeros=todosCeros&&false;
				}
			}
		}
		assertTrue(todosCeros);
	}

	public static void sinCeros(ArrayList<Fecha> lista) {
		boolean sinCeros=true;
		for (Fecha fecha : lista) {
			for (Partido partido : fecha.getPartidos()) {
				if(partido.getArbitro()==0) {
					sinCeros=sinCeros&&false;
				}
			}
		}
		assertTrue(sinCeros);
	}

	public static void fechaEscalonada(ArrayList<Fecha> lista) {
		int sumaEsperada=sumatoria((lista.size()+1)/2);
		int sumaReturn=0;
		for (Partido partido : lista.get(0).getPartidos()) {
			sumaReturn+=partido.getArbitro();
		}
		assertEquals(sumaEsperada,sumaReturn);
	}
	public static void fechasDiferentes(ArrayList<Fecha> lista) {
		boolean fechasDiferentes=true;
		for (Fecha fecha : lista) {
			ArrayList<Integer> recorridos=new ArrayList<Integer>();
			for (Partido partido: fecha.getPartidos()) {
				if(!recorridos.contains(partido.getArbitro())){
					recorridos.add(partido.getArbitro());
				}
			}
			if (recorridos.size()!=(lista.size()+1)/2) {
				fechasDiferentes=fechasDiferentes&&false;
			}
		}
		assertTrue(fechasDiferentes);
		
	}
	private static int sumatoria(int i) {
		int sumatoria=0;
		for(int j=1;j<=i;j++) {
			sumatoria+=j;
		}
		return sumatoria;
	}
}
