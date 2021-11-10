package servicio;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EquipoTest {

	@Test
	public void iguales() {
		Equipo e1=new Equipo("La Estrella");
		Equipo e2=new Equipo("La Estrella");
		
		assertTrue(e1.equals(e2));
	}
	@Test
	public void diferentes() {
		Equipo e1=new Equipo("La Estrella");
		Equipo e2=new Equipo("Los Paraisos");
		
		assertFalse(e1.equals(e2));
	}

}
