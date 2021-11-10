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
import servicio.SolverArbitro;

public class Controlador {
	private ArrayList<Calendario> calendarios;
	private Campeonato campeonato;
	private int fecha=0;
	private boolean asignar=false;

	public Controlador(Campeonato campeonato,String[] ubicaciones) {
		this.campeonato=campeonato;
		this.calendarios=agregarCalendarios(ubicaciones);
	}

	public void iniciarControlador() {
		//hace visible el frame
		this.campeonato.getFrame().setVisible(true);
		//controla interacciones con las fechas
		controlListeners();
	}

	private ArrayList<Calendario> agregarCalendarios(String [] ubicaciones) {
		ArrayList<Calendario> calendarios=new ArrayList<Calendario>();
		for (String ubicacion: ubicaciones) {
			calendarios.add(leerSerializado(ubicacion));
		}
		return calendarios;
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
		controlSiguiente();
		controlAnterior();
		controlAsignar();
	}
	private void controlGraficar() {
		ActionListener mC=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				asignar=false;
				fecha=0;
				campeonato.getTable().setModel(new DefaultTableModel(
					fechas(campeonato.getSpinner().getValue().toString()),
					cabecera(campeonato.getSpinner().getValue().toString())
					
				));
				campeonato.getScrollPane().setViewportView(campeonato.getTable());
				campeonato.getBotonMostrarCalendarioSinArbitros().setVisible(false);
				campeonato.getBotonSiguiente().setVisible(true);
				campeonato.getBotonAnterior().setVisible(false);
				campeonato.getBotonMostrarArbitros().setVisible(true);
			}
		};
		this.campeonato.getBotonMostrarCalendarioSinArbitros().addActionListener(mC);
		
	}
	private void controlSiguiente() {
		ActionListener s=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fecha+=1;
				campeonato.getTable().setModel(new DefaultTableModel(
					fechas(campeonato.getSpinner().getValue().toString()),
					cabecera(campeonato.getSpinner().getValue().toString())
					
				));
				campeonato.getScrollPane().setViewportView(campeonato.getTable());
				campeonato.getBotonAnterior().setVisible(true);
			}
		};
		this.campeonato.getBotonSiguiente().addActionListener(s);
		
	}
	private void controlAnterior() {
		ActionListener a=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fecha-=1;
				campeonato.getTable().setModel(new DefaultTableModel(
					fechas(campeonato.getSpinner().getValue().toString()),
					cabecera(campeonato.getSpinner().getValue().toString())
					
				));
				campeonato.getScrollPane().setViewportView(campeonato.getTable());
				campeonato.getBotonSiguiente().setVisible(true);
			}
		};
		this.campeonato.getBotonAnterior().addActionListener(a);
		
	}
	private void controlAsignar() {
		ActionListener as=new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				asignar=true;
				campeonato.getTable().setModel(new DefaultTableModel(
					fechas(campeonato.getSpinner().getValue().toString()),
					cabecera(campeonato.getSpinner().getValue().toString())
					
				));
				campeonato.getScrollPane().setViewportView(campeonato.getTable());
				campeonato.getBotonMostrarArbitros().setVisible(false);
				campeonato.getBotonMostrarCalendarioSinArbitros().setVisible(true);
			}
		};
		this.campeonato.getBotonMostrarArbitros().addActionListener(as);
		
	}
	private String[] cabecera(String string) {
		String[] cabecera = null;
		switch (string) {
		case "Liga Española":
			cabecera=asignarCabecera(calendarios.get(0));
			campeonato.getLblCampeonato().setText("Torneo : Liga Española");
			break;
		case"Premier League":
			cabecera=asignarCabecera(calendarios.get(1));
			campeonato.getLblCampeonato().setText("Torneo : Premier League");
			break;
		case"Torneo Argentina":
			cabecera=asignarCabecera(calendarios.get(2));
			campeonato.getLblCampeonato().setText("Torneo : Torneo Argentina");
			break;
		}
		return cabecera;
	}
	private String[] asignarCabecera(Calendario calendario) {
		int columnas=3;
		String[] cabecera = new String [columnas];
		cabecera[0]="Fecha N°"+ (fecha+1);
		cabecera[1]="Arbitros";
		cabecera[2]="   ";
		return cabecera;
	}

	private String[][] fechas(String value) {
		String[][] matriz = null;
		if(value.equals("Liga Española")) {
			if(asignar) {
				matriz=matriz(asignarArbitros(0));
			}
			else{
				matriz=matriz(calendarios.get(0).copiaFechas());
			}
		}
		else if(value.equals("Premier League")){
				if(asignar) {
					matriz=matriz(asignarArbitros(1));
				}
				else{
					matriz=matriz(calendarios.get(1).copiaFechas());
				}
		}
		else {
			if(asignar) {
				matriz=matriz(asignarArbitros(2));
			}
			else{
				matriz=matriz(calendarios.get(2).copiaFechas());
			}
		}
		return matriz;
	}
	
	private ArrayList<Fecha> asignarArbitros(int i) {
		SolverArbitro solver=new SolverArbitro(calendarios.get(i));
		ArrayList<Fecha> fechas=solver.resolver();
		return fechas;
	}

	private String[][] matriz(ArrayList<Fecha> fechas) {
		if(fechas.size()-1==this.fecha) {
			campeonato.getBotonSiguiente().setVisible(false);
		}
		if(0==this.fecha) {
			campeonato.getBotonAnterior().setVisible(false);
		}
		Fecha fecha=fechas.get(this.fecha);
		String[][] matriz=new String[fechas.get(0).getPartidos().size()][3];
		for(int i=0;i<fechas.get(0).getPartidos().size();i++) {
			matriz[i][0]=fecha.getPartidos().get(i).getLocal().getNombre();
			if(fecha.getPartidos().get(i).getArbitro()==0) {
				matriz[i][1]="  ";
			}	
			else {
				matriz[i][1]=String.valueOf(fecha.getPartidos().get(i).getArbitro());
			}
			matriz[i][2]=fecha.getPartidos().get(i).getVisitante().getNombre();	
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
				campeonato.getScrollPane().setVisible(true);
				campeonato.getLblCampeonato().setVisible(true);
				campeonato.getSpinner().setVisible(true);
				campeonato.getSpinner().setModel(new SpinnerListModel(new String[] {"Liga Española","Premier League","Torneo Argentina"}));
				
			}
			
		};
		this.campeonato.getBotonEmpezar().addActionListener(bE);
	}
}
