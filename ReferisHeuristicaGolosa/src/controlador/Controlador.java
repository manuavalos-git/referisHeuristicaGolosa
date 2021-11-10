package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.SpinnerListModel;
import javax.swing.table.DefaultTableModel;

import cliente.Campeonato;
import servicio.Calendario;
import servicio.Fecha;

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
		controlGraficar();
//		controlGenerar();
	}
	private void controlGraficar() {
		ActionListener mC=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				campeonato.getTable().setModel(new DefaultTableModel(
					fechasSinArbitros(campeonato.getSpinner().getValue().toString()),
					cabecera(campeonato.getSpinner().getValue().toString())
					
				));
				campeonato.getScrollPane().setViewportView(campeonato.getTable());
				campeonato.getBotonMostrarArbitros().setEnabled(true);
			}
		};
		this.campeonato.getBotonMostrarCalendarioSinArbitros().addActionListener(mC);
		
	}
	private String[] cabecera(String string) {
		String[] cabecera = null;
		switch (string) {
		case "Liga Española":
			cabecera=asignarCabecera(calendarios.get(0));
			break;
		case"Premier League":
			cabecera=asignarCabecera(calendarios.get(1));
			break;
		case"Torneo Argentina":
			cabecera=asignarCabecera(calendarios.get(2));
			break;
		}
		return cabecera;
	}
	private String[] asignarCabecera(Calendario calendario) {
		int columnas=(calendario.copiaFechas().size()*3)+calendario.copiaFechas().size()-1;
		String[] cabecera = new String [columnas];
		int i=0;
		int fecha=1;
		while(i<columnas) {
			if(i==12) {
				cabecera[i]="FE "+fecha;
				i+=3;
			}
			else {
				cabecera[i]="Fecha N°"+fecha;
				cabecera[i+1]="Arbitros";
				cabecera[i+2]="   ";
				cabecera[i+3]="   ";
				i+=4;
				fecha+=1;
			}
		}
		return cabecera;
	}

	private String[][] fechasSinArbitros(String value) {
		String[][] matriz = null;
		switch (value) {
		case "Liga Española":
			matriz=matrizSinArbitros(calendarios.get(0));
			break;
		case"Premier League":
			matriz=matrizSinArbitros(calendarios.get(1));
			break;
		case"Torneo Argentina":
			matriz=matrizSinArbitros(calendarios.get(2));
			break;
		}
		return matriz;
	}
	
	private String[][] matrizSinArbitros(Calendario calendario) {
		ArrayList<Fecha> fechas=calendario.copiaFechas();
		
		String[][] matriz=new String[calendario.copiaArbitros().size()][(calendario.copiaFechas().size()*3)+calendario.copiaFechas().size()-1];
			for(int i=0;i<calendario.copiaArbitros().size();i++) {
				int j=0;
				while(j<(calendario.copiaFechas().size()*3)+calendario.copiaFechas().size()-1) {
					//arreglar,sacar fecha afuera
					int fecha=0;
					if(j==24) {
						matriz[i][j]=fechas.get(fecha).getPartidos().get(i).getLocal().getNombre();
						matriz[i][j+1]="";
						matriz[i][j+2]=fechas.get(fecha).getPartidos().get(i).getVisitante().getNombre();
						j+=3;
					}
					else {
						matriz[i][j]=fechas.get(fecha).getPartidos().get(i).getLocal().getNombre();
						matriz[i][j+1]="";
						matriz[i][j+2]=fechas.get(fecha).getPartidos().get(i).getVisitante().getNombre();
						matriz[i][j+3]="";
						fecha+=1;
						j+=4;
					}
				}
			}
		
		return matriz;
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
				campeonato.getLblCampeonato().setVisible(true);
				campeonato.getSpinner().setVisible(true);
				campeonato.getSpinner().setModel(new SpinnerListModel(new String[] {"Liga Española","Premier League","Torneo Argentina"}));
				
			}
			
		};
		this.campeonato.getBotonEmpezar().addActionListener(bE);
	}
}
