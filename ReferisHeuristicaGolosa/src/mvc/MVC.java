package mvc;

import java.awt.EventQueue;
import javax.swing.UIManager;
import cliente.Campeonato;
import controlador.Controlador;


public class MVC {
	public static void main(String[] args) {
		
		//inicializo objetos
		Campeonato campeonato=new Campeonato();
		String [] ubicaciones={"C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioLigaEspañola.ddr"
					,"C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioPremierLeague.ddr"
					,"C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioTorneoArgentina.ddr"};
		Controlador controlador=new Controlador(campeonato, ubicaciones);
		
		try
		 {
		//cambio el LookAndFeel
		 UIManager.setLookAndFeel(
		 UIManager.getSystemLookAndFeelClassName());
		 }
		catch(Exception e) { 
			e.printStackTrace();
		} 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//inicia el cotrolador
					controlador.iniciarControlador();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
