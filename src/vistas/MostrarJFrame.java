package vistas;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controladores.ControlMenuJugador;


@SuppressWarnings("serial")
public class MostrarJFrame extends JFrame implements ActionListener{
	    
   public JTable tabla;
   public JScrollPane scrollPane; 
   public JLabel ltitulo, mostrarDato;
   public JButton BMostrar, BVolver;
   ControlMenuJugador control;
   MenuJugador mj; 
   
    public MostrarJFrame(MenuJugador x, ControlMenuJugador con){
   	
    	mj=x;
    	control= con;
				    	
       	setLayout(null); 
        setResizable(false);
 	    setLocationRelativeTo(null);
 	    setLayout(new FlowLayout());
 	   
        setSize(new Dimension(700, 600));
        setTitle("Mostrar Jugador");
        setLayout(null);
        setVisible(true);
        this.getContentPane().setBackground(Color.white);
        ltitulo = new JLabel("CONSULTA DE JUGADORES");
       	ltitulo.setBounds(30,38,200,25);  
       	
        BMostrar = new JButton("MOSTRAR");
        BMostrar.setBounds(30, 100 , 100, 25);
        BMostrar.addActionListener(this);
        
        BVolver = new JButton("VOLVER");
        BVolver.setBounds(150,100,100,25);
        BVolver.addActionListener(this);
       
        this.add(ltitulo);   
        this.add(BMostrar);
        this.add(BVolver);
	    setSize(600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void mensaje(String msj){
    	JOptionPane.showMessageDialog(null, msj);
    }
    
    public void cargarDatos(){
        String[] columnas = {"N°","NOMBRE", "ALIAS","NIVEL","PUNTUACION"};
		Object[][] datos= control.mostrarJugador();
		
		if(control.indice!=-1) 
        {	
        	tabla = new JTable(datos,columnas);
            tabla.setPreferredScrollableViewportSize(new Dimension(300,190));		
			scrollPane = new JScrollPane(tabla);
        	scrollPane.setBounds(100,200,400,200);
        	scrollPane.setViewportView(tabla);
        	
        	scrollPane.setVisible(true);
			tabla.setVisible(true);	
            this.add(scrollPane);
        }
		else
			mensaje("No hay jugador para mostrar");
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(BMostrar)){
			cargarDatos();
		}
		else if(e.getSource().equals(BVolver)){
	        	 mj.setVisible(true);
	             this.setVisible(false);             
	         }		
	}
}   	