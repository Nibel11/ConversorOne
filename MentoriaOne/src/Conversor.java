import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField valor;
	private JComboBox opciones;
	private JButton botonConvertir;
	private JLabel resultado;
	private JButton botonSalir;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Conversor() {
		setTitle("Conversor ONE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 586);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Colores");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Gris");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setBackground(Color.LIGHT_GRAY);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor Moneda");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(85, 34, 212, 46);
		contentPane.add(lblNewLabel);
		
		opciones = new JComboBox();
		opciones.setFont(new Font("Tahoma", Font.PLAIN, 20));
		opciones.setModel(new DefaultComboBoxModel(new String[] {"Pesos a Dolares", "Dolares a Pesos"}));
		opciones.setBounds(85, 122, 168, 29);
		contentPane.add(opciones);
		
		JLabel lblNewLabel_1 = new JLabel("Ingrese un Monto");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(85, 201, 198, 29);
		contentPane.add(lblNewLabel_1);
		
		valor = new JTextField();
		valor.setBounds(256, 206, 143, 28);
		contentPane.add(valor);
		valor.setColumns(10);
		
		botonConvertir = new JButton("Convertir");
		botonConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor2 = valor.getText();
				double valorNum = Double.parseDouble(valor2);
				
				double tipoCambio = 600;
				double resultadoFinal = 0;
				
				DecimalFormat formatear = new DecimalFormat("0.00");
				
				if(opciones.getSelectedIndex()==0) {
					resultadoFinal = (valorNum/tipoCambio);
					resultado.setText("Resultado: " + formatear.format(resultadoFinal));
					
				}else if(opciones.getSelectedIndex()==1) {
					resultadoFinal = (valorNum*tipoCambio);
					resultado.setText("Resultado: " + formatear.format(resultadoFinal));
				}
				
			}
		});
		botonConvertir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonConvertir.setBounds(115, 292, 155, 38);
		contentPane.add(botonConvertir);
		
		botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		botonSalir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		botonSalir.setBounds(277, 459, 155, 38);
		contentPane.add(botonSalir);
		
		resultado = new JLabel("0");
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultado.setBounds(302, 301, 323, 29);
		contentPane.add(resultado);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Luis\\Downloads\\one-acate-800x533_resized.jpg"));
		lblNewLabel_2.setBounds(384, 0, 449, 175);
		contentPane.add(lblNewLabel_2);
	}
}
