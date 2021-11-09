package servicio;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArbitroTest {

	@Test
	public void sumarPartidoFeliz() {
		Arbitro a=new Arbitro(6,3);
		a.sumarPartido(4, 5);
		assertTrue(a.getEquipos()[4]==1 && a.getEquipos()[5]==1);
	}
	@Test
	public void sumarPartidoAOtro() {
		Arbitro a=new Arbitro(6,3);
		a.sumarPartido(4, 5);
		assertFalse(a.getEquipos()[3]==1 || a.getEquipos()[2]==1);
	}
}
