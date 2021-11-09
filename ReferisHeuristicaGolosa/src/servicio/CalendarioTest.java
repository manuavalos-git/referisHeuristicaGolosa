package servicio;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class CalendarioTest {

	@Test (expected = IllegalArgumentException.class)
	public void noCumpleCantEquipos() {
		
		Calendario calendario=new Calendario(generarEquipos(), generarfechas());
	
	}
	@Test (expected = IllegalArgumentException.class)
	public void noCumpleFechas() {
		
		Calendario calendario=new Calendario(generarEquipos2(), generarfechas2());
	
	}
	@Test 
	public void calendarioFeliz() {
		Calendario calendario=new Calendario(generarEquipos2(), generarfechas());
		assertTrue(calendario.copiaArbitros().size()==calendario.copiaEquipos().size()/2);
	}
	private ArrayList<Fecha> generarfechas2() {
		ArrayList<Fecha> fechas=new ArrayList<Fecha> ();
		ArrayList<Partido> partidos=new ArrayList<Partido>();
		partidos.add(new Partido(new Equipo("San Miguel"),new Equipo("Boca")));
		partidos.add(new Partido(new Equipo("Racing"),new Equipo("Lanus")));
		fechas.add(new Fecha(partidos));
		
		ArrayList<Partido> partidos2=new ArrayList<Partido>();
		partidos2.add(new Partido(new Equipo("San Miguel"),new Equipo("Racing")));
		partidos2.add(new Partido(new Equipo("Boca"),new Equipo("Lanus")));
		fechas.add(new Fecha(partidos2));

		
		return fechas;
	}
	private ArrayList<Equipo> generarEquipos2() {
		ArrayList<Equipo> equipos=new ArrayList<Equipo>();
		equipos.add(new Equipo("San Miguel"));
		equipos.add(new Equipo("Boca"));
		equipos.add(new Equipo("Racing"));
		equipos.add(new Equipo("Lanus"));
		
		return equipos;
	}
	private ArrayList<Equipo> generarEquipos() {
		ArrayList<Equipo> equipos=new ArrayList<Equipo>();
		equipos.add(new Equipo("San Miguel"));
		equipos.add(new Equipo("Boca"));
		equipos.add(new Equipo("Racing"));
//		equipos.add(new Equipo("Lanus"));
		
		return equipos;
	}
	private ArrayList<Fecha> generarfechas() {
		ArrayList<Fecha> fechas=new ArrayList<Fecha> ();
		ArrayList<Partido> partidos=new ArrayList<Partido>();
		partidos.add(new Partido(new Equipo("San Miguel"),new Equipo("Boca")));
		partidos.add(new Partido(new Equipo("Racing"),new Equipo("Lanus")));
		fechas.add(new Fecha(partidos));
		
		ArrayList<Partido> partidos2=new ArrayList<Partido>();
		partidos2.add(new Partido(new Equipo("San Miguel"),new Equipo("Racing")));
		partidos2.add(new Partido(new Equipo("Boca"),new Equipo("Lanus")));
		fechas.add(new Fecha(partidos2));

		ArrayList<Partido> partidos3=new ArrayList<Partido>();
		partidos3.add(new Partido(new Equipo("San Miguel"),new Equipo("Lanus")));
		partidos3.add(new Partido(new Equipo("Boca"),new Equipo("Racing")));
		fechas.add(new Fecha(partidos3));

		
		return fechas;
	}
}
