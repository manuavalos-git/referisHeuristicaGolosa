package servicio;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.junit.Test;

class SolverArbitroTest {

	@Test
	void sinSolver() {
		Calendario calendario=leerSerializado("C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioLigaEspañola.ddr");
	
		Assert.todosCeros(calendario);
	}
	@Test
	void sinCeros() {
		ArrayList<Fecha> lista=listaFechas();
		
		Assert.sinCeros(lista);
	}
	@Test
	void primerFechaEscalonada() {
		ArrayList<Fecha> lista=listaFechas();
		
		Assert.fechaEscalonada(lista);
	}
	@Test
	void todasDiferentes() {
		ArrayList<Fecha> lista=listaFechas();
		
		Assert.fechasDiferentes(lista);
	}
	private ArrayList<Fecha> listaFechas() {
		Calendario calendario=leerSerializado("C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioLigaEspañola.ddr");
		SolverArbitro solver=new SolverArbitro(calendario);
		
		return solver.resolver();
	}
	private static Calendario leerSerializado(String ubicacion) {
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
}
