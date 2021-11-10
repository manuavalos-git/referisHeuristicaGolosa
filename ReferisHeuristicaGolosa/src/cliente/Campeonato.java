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
//		frmCampenato.setIconImage(Toolkit.getDefaultToolkit().getImage(Campeonato.class.getResource("/multimedia/icono.png")));
		frmCampenato.setTitle("Campeonatos");
		frmCampenato.setBounds(100, 100, 914, 620);
		frmCampenato.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    this.panel = new JPanel();
	    panel.setBackground(new Color(255, 228, 225));
		frmCampenato.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		this.botonEmpezar = new JButton();
		botonEmpezar.setRolloverEnabled(false);
		botonEmpezar.setFocusable(false);
		botonEmpezar.setMargin(new Insets(7, 14, 7, 14));
		botonEmpezar.setIconTextGap(0);
		botonEmpezar.setBorder(null);
		botonEmpezar.setBackground(new Color(176, 224, 230));
		botonEmpezar.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonEmpezar.setText("Empezar");
		botonEmpezar.setBounds(279, 461, 121, 39);
		panel.add(botonEmpezar);
		
		this.botonMostrarCalendarioSinArbitros = new JButton();
		botonMostrarCalendarioSinArbitros.setFocusable(false);
		botonMostrarCalendarioSinArbitros.setBorder(null);
		botonMostrarCalendarioSinArbitros.setForeground(new Color(0, 0, 0));
		botonMostrarCalendarioSinArbitros.setBackground(new Color(176, 224, 230));
		botonMostrarCalendarioSinArbitros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonMostrarCalendarioSinArbitros.setText("Mostrar Calendario\r\n");
		botonMostrarCalendarioSinArbitros.setBounds(635, 464, 263, 32);
		panel.add(botonMostrarCalendarioSinArbitros);
		botonMostrarCalendarioSinArbitros.setVisible(false);
		
		this.botonMostrarArbitros = new JButton();
		botonMostrarArbitros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonMostrarArbitros.setFocusable(false);
		botonMostrarArbitros.setBorder(null);
		botonMostrarArbitros.setBackground(new Color(176, 224, 230));
		botonMostrarArbitros.setEnabled(false);
		botonMostrarArbitros.setText("Asignar arbitros");
		botonMostrarArbitros.setBounds(645, 510, 229, 32);
		panel.add(botonMostrarArbitros);
		botonMostrarArbitros.setVisible(false);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 240, 245));
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 61, 864, 281);
		scrollPane.getViewport().setBackground(new Color(255, 240, 245));
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		
		this.lblTitulo = new JLabel("Campeonatos");
		lblTitulo.setBounds(164, 191, 635, 215);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 90));
		
		this.lblCampeonato = new JLabel("Fechas   :");
		lblCampeonato.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(72, 11, 222, 39);
		lblCampeonato.setVisible(false);
		panel.add(lblCampeonato);
		
		this.spinner = new JSpinner();
		spinner.setVisible(false);
		spinner.setBounds(382, 496, 263, 46);
		panel.add(spinner);
	
		
		this.table = new JTable();
		table.setBackground(new Color(255, 240, 245));
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowHeight(30);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBorder(null);
		table.getTableHeader().setBackground(new Color(176, 224, 230));
		table.setRowSelectionAllowed(false);
		
		

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
