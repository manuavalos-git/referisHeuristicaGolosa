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
import java.awt.Frame;
import java.awt.Toolkit;

public class Campeonato {

	private JFrame frmCampenato;
	private JButton botonMostrarArbitros,botonEmpezar,botonMostrarCalendarioSinArbitros;
	private JLabel lblTitulo;
	private JPanel panel;
	private JTable table,table2;
	private JScrollPane scrollPane,scrollPane2;
	private JLabel lblCampeonato;
	private JLabel lblArbitros;

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
		frmCampenato.setIconImage(Toolkit.getDefaultToolkit().getImage(Campeonato.class.getResource("/multimedia/icono.png")));
		frmCampenato.setTitle("Kruskal");
		frmCampenato.setExtendedState(Frame.MAXIMIZED_BOTH);
//		frame.setResizable(false);
		frmCampenato.setBounds(100, 100, 1281, 672);
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
		botonEmpezar.setBounds(570, 537, 121, 39);
		panel.add(botonEmpezar);
		
		this.botonMostrarCalendarioSinArbitros = new JButton();
		botonMostrarCalendarioSinArbitros.setFocusable(false);
		botonMostrarCalendarioSinArbitros.setBorder(null);
		botonMostrarCalendarioSinArbitros.setForeground(new Color(0, 0, 0));
		botonMostrarCalendarioSinArbitros.setBackground(new Color(176, 224, 230));
		botonMostrarCalendarioSinArbitros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonMostrarCalendarioSinArbitros.setText("Generar nuevos grafos\r\n");
		botonMostrarCalendarioSinArbitros.setBounds(219, 587, 263, 32);
		panel.add(botonMostrarCalendarioSinArbitros);
		botonMostrarCalendarioSinArbitros.setVisible(false);
		
		this.botonMostrarArbitros = new JButton();
		botonMostrarArbitros.setFont(new Font("Segoe UI", Font.BOLD, 20));
		botonMostrarArbitros.setFocusable(false);
		botonMostrarArbitros.setBorder(null);
		botonMostrarArbitros.setBackground(new Color(176, 224, 230));
		botonMostrarArbitros.setEnabled(false);
		botonMostrarArbitros.setText("Graficar tiempos");
		botonMostrarArbitros.setBounds(922, 587, 229, 32);
		panel.add(botonMostrarArbitros);
		botonMostrarArbitros.setVisible(false);
		//panel.add(table);
		
		this.scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(255, 240, 245));
		scrollPane.setFocusable(false);
		scrollPane.setWheelScrollingEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 61, 703, 495);
		scrollPane.getViewport().setBackground(new Color(255, 240, 245));
		scrollPane.setVisible(false);
		panel.add(scrollPane);
		
		this.scrollPane2= new JScrollPane();
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setFocusable(false);
		scrollPane2.setWheelScrollingEnabled(false);
		scrollPane2.setBackground(new Color(255, 240, 245));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane2.setBounds(783, 61, 483, 495);
		scrollPane2.getViewport().setBackground(new Color(255, 240, 245));
		scrollPane2.setVisible(false);
		panel.add(scrollPane2);
		
		this.lblTitulo = new JLabel("Kruskal\r\n");
		lblTitulo.setBounds(312, 201, 635, 215);
		panel.add(lblTitulo);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 90));
		
		this.lblCampeonato = new JLabel("Valores de los grafos generados :");
		lblCampeonato.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblCampeonato.setHorizontalAlignment(SwingConstants.CENTER);
		lblCampeonato.setBounds(146, 11, 414, 39);
		lblCampeonato.setVisible(false);
		panel.add(lblCampeonato);
		
		this.lblArbitros = new JLabel("Microsegundos :");
		lblArbitros.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblArbitros.setHorizontalAlignment(SwingConstants.CENTER);
		lblArbitros.setBounds(922, 11, 229, 39);
		lblArbitros.setVisible(false);
		panel.add(lblArbitros);
	
		
		this.table = new JTable();
		table.setBackground(new Color(255, 240, 245));
		table.setFocusable(false);
		table.setAutoscrolls(false);
		table.setRowHeight(18);
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBorder(null);
		table.getTableHeader().setBackground(new Color(176, 224, 230));
		table.setRowSelectionAllowed(false);
		
		this.table2 = new JTable();
		table2.setBackground(new Color(255, 240, 245));
		table2.setFocusable(false);
		table2.setAutoscrolls(false);
		table2.setRowHeight(18);
		table2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		table2.getTableHeader().setOpaque(false);
		table2.getTableHeader().setBackground(new Color(176, 224, 230));
		table2.getTableHeader().setBorder(null);
		table2.setAutoscrolls(false);
		table2.setRowSelectionAllowed(false);

	}
	public JLabel getLblCampeonato() {
		return lblCampeonato;
	}

	public JLabel getLblArbitros() {
		return lblArbitros;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JScrollPane getScrollPane2() {
		return scrollPane2;
	}

	public JTable getTable() {
		return table;
	}
	
	public JTable getTable2() {
		return table2;
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
