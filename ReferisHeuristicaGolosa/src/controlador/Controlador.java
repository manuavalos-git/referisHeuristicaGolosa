package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import cliente.Campeonato;
import servicio.Calendario;

public class Controlador {
	private ArrayList<Calendario> calendarios;
	private Campeonato campeonato;
	

	public Controlador(Campeonato campeonato) {
		this.campeonato=campeonato;
		this.calendarios=new ArrayList<Calendario>();
	}

	public void iniciarControlador() {
		//leo serializables
		agregarCalendarios();
		//hago visible el frame
		this.campeonato.getFrame().setVisible(true);
		//controla que luz o boton es pulsado
		controlListeners();
	}

	private void agregarCalendarios() {
		this.calendarios.add(leerSerializado("C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioLigaEspañola.ddr"));
		this.calendarios.add(leerSerializado("C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioPremierLeague.ddr"));
		this.calendarios.add(leerSerializado("C:\\Users\\alumno\\git\\referisHeuristicaGolosa\\ReferisHeuristicaGolosa\\src\\servicio\\calendarioTorneoArgentina.ddr"));
	}

	private Calendario leerSerializado(String ubicacion) {
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

	private void controlListeners() {
		controlEmpezar();
//		controlGraficar();
//		controlGenerar();
	}

	private void controlEmpezar() {
		ActionListener bE=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				campeonato.getLblTitulo().setVisible(false);
				campeonato.getBotonEmpezar().setVisible(false);
				campeonato.getBotonMostrarCalendarioSinArbitros().setVisible(true);
				campeonato.getBotonMostrarArbitros().setVisible(true);
				campeonato.getScrollPane().setVisible(true);
				campeonato.getScrollPane2().setVisible(true);
				campeonato.getLblArbitros().setVisible(true);
				campeonato.getLblCampeonato().setVisible(true);
			}
			
		};
		this.campeonato.getBotonEmpezar().addActionListener(bE);
	}
}
