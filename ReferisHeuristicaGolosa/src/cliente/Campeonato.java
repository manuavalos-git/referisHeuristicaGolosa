package cliente;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Insets;
import javax.swing.JSpinner;


public class Campeonato {

	private JFrame frmCampenato;
	private JButton botonMostrarArbitros,botonEmpezar,botonMostrarCalendarioSinArbitros;
	private JLabel lblTitulo;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblCampeonato;
	private JSpinner spinner;
	private JButton botonAnterior;
	private JButton botonSiguiente;

	/**
	 * Create the application.
	 */
	public Campeonato() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.frmCampenato = new JFrame();
		frmCampenato.setResizable(false);
		frmCampenato.setTitle("Campeonatos");
		frmCampenato.setBounds(100, 100, 845, 372);
		frmCampenato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    this.panel = new JPanel();
	    panel.setBackground(new Color(109,166,145));
		frmCampenato.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		this.botonEmpezar = new JButton();
		botonEmpezar.setRolloverEnabled(false);
		botonEmpezar.setFocusable(false);
		botonEmpezar.setMargin(new Insets(7, 14, 7, 14));
		botonEmpezar.setIconTextGap(0);
		botonEmpezar.setBorder(null);
		botonEmpezar.setBackground(new Color(255,176,32));
		botonEmpezar.setForeground(new Color(103,37,6));
		botonEmpezar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonEmpezar.setText("Empezar");
		botonEmpezar.setBounds(352, 263, 121, 39);
		panel.add(botonEmpezar);
		
		this.botonMostrarCalendarioSinArbitros = new JButton();
		botonMostrarCalendarioSinArbitros.setFocusable(false);
		botonMostrarCalendarioSinArbitros.setBorder(null);
		botonMostrarCalendarioSinArbitros.setBackground(new Color(255,176,32));
		botonMostrarCalendarioSinArbitros.setForeground(new Color(103,37,6));
		botonMostrarCalendarioSinArbitros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonMostrarCalendarioSinArbitros.setText("Sin Arbitros");
		botonMostrarCalendarioSinArbitros.setBounds(541, 136, 263, 32);
		panel.add(botonMostrarCalendarioSinArbitros);
		botonMostrarCalendarioSinArbitros.setVisible(false);
		
		this.botonMostrarArbitros = new JButton();
		botonMostrarArbitros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonMostrarArbitros.setFocusable(false);
		botonMostrarArbitros.setBorder(null);
		botonMostrarArbitros.setBackground(new Color(255,176,32));
		botonMostrarArbitros.setForeground(new Color(103,37,6));
		botonMostrarArbitros.setText("Asignar arbitros");
		botonMostrarArbitros.setBounds(541, 136, 263, 32);
		panel.add(botonMostrarArbitros);
		botonMostrarArbitros.setVisible(false);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(171,233,210));
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 72, 506, 155);
		scrollPane.getViewport().setBackground(new Color(171,233,210));
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		this.lblTitulo = new JLabel("Campeonatos");
		lblTitulo.setBounds(95, 37, 635, 215);
		lblTitulo.setForeground(new Color(103,37,6));
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 90));
		
		this.lblCampeonato = new JLabel("Torneo :");
		lblCampeonato.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCampeonato.setHorizontalAlignment(SwingConstants.LEFT);
		lblCampeonato.setBounds(10, 22, 506, 39);
		lblCampeonato.setForeground(new Color(103,37,6));
		lblCampeonato.setVisible(false);
		panel.add(lblCampeonato);
		
		this.spinner = new JSpinner();
		spinner.setRequestFocusEnabled(false);
		spinner.setBorder(null);
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner.setVisible(false);
		spinner.setBackground(new Color(171,233,210));
		spinner.setForeground(new Color(171,233,210));;
		spinner.setBounds(541, 179, 263, 46);
		panel.add(spinner);
		
		this.botonSiguiente = new JButton();
		botonSiguiente.setVisible(false);
		botonSiguiente.setText("Siguiente fecha");
		botonSiguiente.setRolloverEnabled(false);
		botonSiguiente.setMargin(new Insets(7, 14, 7, 14));
		botonSiguiente.setIconTextGap(0);
		botonSiguiente.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonSiguiente.setFocusable(false);
		botonSiguiente.setBorder(null);
		botonSiguiente.setBackground(new Color(255,176,32));
		botonSiguiente.setForeground(new Color(103,37,6));
		botonSiguiente.setBounds(352, 263, 164, 39);
		panel.add(botonSiguiente);
		
		this.botonAnterior = new JButton();
		botonAnterior.setVisible(false);
		botonAnterior.setText("Anterior fecha");
		botonAnterior.setRolloverEnabled(false);
		botonAnterior.setMargin(new Insets(7, 14, 7, 14));
		botonAnterior.setIconTextGap(0);
		botonAnterior.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonAnterior.setFocusable(false);
		botonAnterior.setBorder(null);
		botonAnterior.setBackground(new Color(255,176,32));
		botonAnterior.setForeground(new Color(103,37,6));
		botonAnterior.setBounds(10, 263, 164, 39);
		panel.add(botonAnterior);
	
		
		this.table = new JTable();
		table.setBackground(new Color(171,233,210));
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowHeight(25);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 17));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBorder(null);
		table.getTableHeader().setBackground(new Color(255,176,32));
		table.setRowSelectionAllowed(false);
		
		

	}
	public JButton getBotonAnterior() {
		return botonAnterior;
	}

	public JButton getBotonSiguiente() {
		return botonSiguiente;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JLabel getLblCampeonato() {
		return lblCampeonato;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBotonMostrarArbitros() {
		return botonMostrarArbitros;
	}

	public JButton getBotonEmpezar() {
		return botonEmpezar;
	}

	public JButton getBotonMostrarCalendarioSinArbitros() {
		return botonMostrarCalendarioSinArbitros;
	}

	public JLabel getLblTitulo() {
		return lblTitulo;
	}

	public JFrame getFrame() {
			return this.frmCampenato;
	}
}
