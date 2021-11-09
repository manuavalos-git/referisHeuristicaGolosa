package servicio;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

class EquipoTest {

	@Test
	void iguales() {
		Equipo e1=new Equipo("La Estrella");
		Equipo e2=new Equipo("La Estrella");
		
		assertTrue(e1.equals(e2));
	}
	@Test
	void diferentes() {
		Equipo e1=new Equipo("La Estrella");
		Equipo e2=new Equipo("Los Paraisos");
		
		assertFalse(e1.equals(e2));
	}

}
