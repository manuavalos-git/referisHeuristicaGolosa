package servicio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class PartidoTest {

	@Test
	public void igualesAlDerecho() {
		Partido p1=new Partido(new Equipo("Dinamita"),new Equipo("El Dinamo"));
		Partido p2=new Partido(new Equipo("Dinamita"),new Equipo("El Dinamo"));
		
		assertTrue(p1.equals(p2));
	}
	@Test
	public void igualesAlReves() {
		Partido p1=new Partido(new Equipo("El Dinamo"),new Equipo("Dinamita"));
		Partido p2=new Partido(new Equipo("Dinamita"),new Equipo("El Dinamo"));
		
		assertTrue(p1.equals(p2));
	}
	@Test
	public void noIguales() {
		Partido p1=new Partido(new Equipo("Trueno"),new Equipo("Relampago"));
		Partido p2=new Partido(new Equipo("Trueno"),new Equipo("Rayo"));
		
		assertFalse(p1.equals(p2));
	}
}
