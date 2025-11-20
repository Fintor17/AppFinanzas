package Prueba;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.toedter.calendar.JDateChooser;

public class DosBotonesApp2 {
    public static void main(String[] args) {
    	JFrame frame = new JFrame("Mi App con Dos Botones");
        frame.setSize(700, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setBackground(Color.GRAY);

        JButton botonGastos = new JButton("Gastos");
        JButton botonEstado = new JButton("Estado de Cuenta");

        botonGastos.addActionListener(e -> new VentanaGastos());
        botonEstado.addActionListener(e -> new VentanaEstado());


       

        frame.add(botonGastos);
        frame.add(botonEstado);
        frame.setVisible(true);
    }
}

class VentanaGastos extends JFrame{
	public VentanaGastos() {
		setTitle("Gastos");
		setSize(800, 500);
		
		//Layout Ordenado
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		//Campos del fomulario
		JLabel lblFecha = new JLabel("Fecha de compa:");
		JDateChooser dateChooser = new JDateChooser ();
		
		JLabel lblConcepto = new JLabel("Concepto");
		JTextField txtConcepto = new JTextField();
		
		JLabel lblTarjeta = new JLabel("Tarjeta de Crédito");
		String[] opcionesTarjeta = {"", "BBVA,", "Mercado Pago"};
		JComboBox<String> comboTarjeta = new JComboBox<>(opcionesTarjeta);
		
		JLabel lblMontoHector = new JLabel("Monto Héctor");
		JTextField txtMontoHector = new JTextField();
		
		JLabel lblMontoLili = new JLabel("Monto Lili");
		JTextField txtMontoLili = new JTextField();
		
		JLabel lblMontoOtros = new JLabel("Monto Otros");
		JTextField txtMontoOtros = new JTextField();
		
		JLabel lblMSI = new JLabel("MSI");
		JRadioButton rbtMSI = new JRadioButton("MSI", false);
		JTextField txtMontoMSI = new JTextField();
		txtMontoMSI.setBounds(20, 60, 150, 30);
        txtMontoMSI.setEnabled(false); // Inicialmente deshabilitado

		
        JButton btnGuardar = new JButton("Guardar");
        
        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> dispose());

     // Añadir componentes
             gbc.gridx = 0; gbc.gridy = 0;
             add(lblFecha, gbc);
             gbc.gridx = 1;
             add(dateChooser, gbc);

             gbc.gridx = 0; gbc.gridy = 1;
             add(lblConcepto, gbc);
             gbc.gridx = 1;
             add(txtConcepto, gbc);

             gbc.gridx = 0; gbc.gridy = 2;
             add(lblTarjeta, gbc);
             gbc.gridx = 1;
             add(comboTarjeta, gbc);
             
             gbc.gridx = 0; gbc.gridy = 3;
             add(lblMontoHector, gbc);
             gbc.gridx = 1;
             add(txtMontoHector, gbc);
             
             gbc.gridx = 0; gbc.gridy = 4;
             add(lblMontoLili, gbc);
             gbc.gridx = 1;
             add(txtMontoLili, gbc);
             
             gbc.gridx = 0; gbc.gridy = 5;
             add(lblMontoOtros, gbc);
             gbc.gridx = 1;
             add(txtMontoOtros, gbc);
             
             gbc.gridx = 3; gbc.gridy = 1; gbc.gridwidth = 1;
             add(lblMSI, gbc);
             gbc.gridx = 4;
             add(rbtMSI, gbc);
             gbc.gridx = 3; gbc.gridy = 2;
             add(txtMontoMSI, gbc);

             gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
             add(btnGuardar, gbc);
             

             // Botón Cerrar
             gbc.gridx = 2; gbc.gridy = 6; gbc.gridwidth = 2;
             add(botonCerrar, gbc);
             
             /*Condicion de MSI
             if(rbtMSI.isSelected()) {
            	 txtMontoMSI.setEnabled(true);
             }else {
            	 txtMontoMSI.setEnabled(false);
            	
             }*/
             
             rbtMSI.addActionListener(new ActionListener() {
                 @Override
                 	public void actionPerformed(ActionEvent e) {
                     	txtMontoMSI.setEnabled(rbtMSI.isSelected());
                 	}
             	});
        
     // Acción del botón: limpiar campo
             btnGuardar.addActionListener(e -> {
                 txtConcepto.setText("");
                 txtMontoHector.setText("");
                 txtMontoLili.setText("");
                 txtMontoOtros.setText("");
                 comboTarjeta.setSelectedIndex(0);
                 JOptionPane.showMessageDialog(this, "Datos limpiados (simulación de guardado)");
             });

        setVisible(true);

	}
}


class VentanaEstado extends JFrame {
    public VentanaEstado() {
        setTitle("Estado de Cuenta");
        setSize(400, 300);
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Consulta tu Estado de Cuenta", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        add(label, BorderLayout.NORTH);
        
 

        JButton botonCerrar = new JButton("Cerrar");
        botonCerrar.addActionListener(e -> dispose());
        add(botonCerrar, BorderLayout.SOUTH);

        setVisible(true);
    }
}
