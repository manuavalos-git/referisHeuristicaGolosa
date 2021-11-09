package servicio;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

class FechaTest {

	@Test
	void iguales() {
		Fecha fecha1=generarfecha1();
		Fecha fecha2=generarfecha2();
		
		assertTrue(fecha1.equals(fecha2));
	}
	@Test
	void  dferentes() {
		Fecha fecha1=generarfecha1();
		Fecha fecha2=generarfecha3();
		
		assertFalse(fecha1.equals(fecha2));
	}

	private Fecha generarfecha3() {
		ArrayList<Partido> partidos=new ArrayList<Partido>();
		partidos.add(new Partido(new Equipo("San Miguel"),new Equipo("Boca")));
		partidos.add(new Partido(new Equipo("Racing"),new Equipo("Lanus")));
		partidos.add(new Partido(new Equipo("santa Cruz"),new Equipo("Chacarita")));
		return new Fecha(partidos);
	}
	private Fecha generarfecha2() {
		ArrayList<Partido> partidos=new ArrayList<Partido>();
		partidos.add(new Partido(new Equipo("Boca"),new Equipo("River")));
		partidos.add(new Partido(new Equipo("Lanus"),new Equipo("Racing")));
		partidos.add(new Partido(new Equipo("santa Cruz"),new Equipo("Chacarita")));
		return new Fecha(partidos);
	}

	private Fecha generarfecha1() {
		ArrayList<Partido> partidos=new ArrayList<Partido>();
		partidos.add(new Partido(new Equipo("River"),new Equipo("Boca")));
		partidos.add(new Partido(new Equipo("Racing"),new Equipo("Lanus")));
		partidos.add(new Partido(new Equipo("santa Cruz"),new Equipo("Chacarita")));
		return new Fecha(partidos);
	}

}
