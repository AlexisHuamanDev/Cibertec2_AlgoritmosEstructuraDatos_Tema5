package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import semana_05.ArregloPrecios;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Propuesto_5_2 extends JFrame implements ActionListener {
	
	ArregloPrecios ap = new ArregloPrecios();
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JButton btnListar;
	private JButton btnReportar;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnGenerar;

	DecimalFormat df = new DecimalFormat("0.00");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Propuesto_5_2 frame = new Propuesto_5_2();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Propuesto_5_2() {
		setTitle("Propuesto_5_2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(75, 11, 95, 23);
		contentPane.add(btnListar);
		
		btnReportar = new JButton("Reportar");
		btnReportar.addActionListener(this);
		btnReportar.setBounds(180, 11, 95, 23);
		contentPane.add(btnReportar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 44, 414, 406);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane.setViewportView(txtS);
		
		btnGenerar = new JButton("Generar");
		btnGenerar.addActionListener(this);
		btnGenerar.setBounds(285, 11, 89, 23);
		contentPane.add(btnGenerar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnGenerar) {
			actionPerformedBtnGenerar(arg0);
		}
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
	}
protected void actionPerformedBtnListar(ActionEvent arg0) {
		
		txtS.setText("");
		for(int i=0;i<ap.tamanio();i++) {
			imprimir(" ["+i+ "] : "+ ap.obtener(i));
		}
		imprimir("");
	}
	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		
		imprimir("Tamaño del arreglo: "+ap.tamanio());
		imprimir("Sueldo Promedio: "+df.format(ap.precioPromedio()));
		imprimir("Sueldo Mayor: "+ap.precioMayor());
		imprimir("Sueldo Menor: "+ap.precioMenor());
		imprimir("Cantidad de productos con sueldos mayor al promedio: "+ap.cantMayoresprecioPromedio());
		imprimir("Cantidad de productos con sueldos menor al promedio: "+ap.cantMenoresprecioPromedio());
		imprimir("Posición del primer precio mayor al segundo de los precios: "+ap.posPrimerPrecioMayorAlSegundo());
		imprimir("Posición del último precio menor al penúltimo de los precios: "+ap.posUltimoPrecioMenorAlPenultimo());
		
	}
	protected void actionPerformedBtnGenerar(ActionEvent arg0) {
		imprimir();
		ap.generarPrecios();
    	imprimir("Los números han sido cambiados. Pulse [Listar]");
	}
	//  Métodos tipo void (sin parámetros)
	void imprimir() {
		imprimir("");
	}
	//  Métodos tipo void (con parámetros)
	void imprimir(String s) {
		txtS.append(s + "\n");
	}
}